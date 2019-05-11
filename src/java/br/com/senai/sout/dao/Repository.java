/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.dao;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface Repository {

    void inserir(Object o);

    void alterar(Object o);

    void excluir(int id);

    void commitar();

    List lista();

}
