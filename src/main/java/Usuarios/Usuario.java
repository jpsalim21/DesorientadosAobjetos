/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author Thales
 */
public abstract class Usuario {
    private String nome;
    private String senha;
    
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
}
