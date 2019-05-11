/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.dao;

import br.com.senai.sout.banco.DbUtils;
import br.com.senai.sout.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class UsuarioDao implements Repository {

    private Usuario parse(ResultSet res) throws SQLException {
        Usuario model = new Usuario();

        model.setId((int) res.getLong("id"));
        model.setEmail(res.getString("email"));
        model.setIePermissao(res.getString("iePermissao"));
        model.setTelefone(res.getString("telefone"));
        model.setLogin(res.getString("login"));
        model.setNome(res.getString("nome"));
        model.setPassword(res.getString("password"));
        model.setIePermissao(res.getString("iePermissao"));

        return model;
    }

    @Override
    public void inserir(Object o) {
        try {
            Usuario user = (Usuario) o ;
            String sql = "INSERT INTO Usuario (nome,email,telefone,login) VALUES (?,?,?,?)";

            Connection conn = DbUtils.getConnection();

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getNome());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getTelefone());
            stm.setString(4, user.getLogin());

            stm.execute();

            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    @Override
    public void alterar(Object o) {

    }

    @Override
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Usuario WHERE id=?";
            
            Connection conn = DbUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setLong(1, id);
            
            stm.execute();
            
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void commitar() {

    }

    @Override
    public List lista() {
        try {
            String sql = "SELECT id, login, password, nome, telefone, email, iePermissao FROM Usuario";
            Connection conn = DbUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            List<Usuario> registros = new ArrayList<>();

            while (res.next()) {
                registros.add(parse(res));

            }
            res.close();
            stm.close();
            conn.close();

            return registros;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
