/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class UsuarioView {

    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<Usuario> listaUsuarios = usuarioDao.lista();
    private Usuario usuario = new Usuario();

    public void excluiUsuario(Usuario usuario) {
        usuarioDao.excluir(usuario.getId());
        atualizaLista();
    }
    public void salvaUsuario(Usuario usuario) {
        usuarioDao.inserir(usuario);
        atualizaLista();
    }

    public UsuarioView() {
    }

    private void atualizaLista() {
        listaUsuarios = usuarioDao.lista();
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     public void salvaUsuario() throws ServletException{       
        usuarioDao.inserir(usuario);        
        usuario = new Usuario();
        atualizaLista();
    }
}
