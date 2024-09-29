/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excecao;

/**
 *
 * @author PC12643
 */
public class ExceptionResultadoImutavel extends Exception{
    public ExceptionResultadoImutavel(){
        super("Resultado não pode ser alterado");
    }
}
