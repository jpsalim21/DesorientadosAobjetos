package Excecao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC12643
 */
public class ExcecaoUsuarioJaExistente extends Exception{
    public ExcecaoUsuarioJaExistente(){
        super("Usuário já existe");
    }
}
