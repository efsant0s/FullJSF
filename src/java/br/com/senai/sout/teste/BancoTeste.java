/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.teste;

import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Usuario;
import java.util.List;

/**
 *
 * @author Celina
 */
public class BancoTeste {
    public static void main(String[] args) {
        testeConexaoBanco();
    }

    private static void testeConexaoBanco() {
        UsuarioDao dao = new UsuarioDao();
        List lista = dao.lista();
        for (Object object : lista) {
            System.out.println(((Usuario) object).toString());
        }
    }
}
