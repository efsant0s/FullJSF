/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Celina
 */
@ManagedBean
public class CalculatorView {
    private Calculator calculadora = new Calculator();
    
    public void calcular(){
        calculadora.calcular();

    }

    public Calculator getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculator calculadora) {
        this.calculadora = calculadora;
    }
    
}
