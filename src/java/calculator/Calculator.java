/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Celina
 */
public class Calculator {

    private double x;
    private double y;
    private double result;
    private char operacao;

    public void calcular() {
        if(operacao == '*') {
            result = Math.round((x*y) * 100d) / 100d ;
        }
        if(operacao == '+') {
            result = x+y;
        }
        if(operacao == '-') {
            result = x-y;
        }
        if(operacao == '/') {
            result = x/y;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public char getOperacao() {
        return operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}