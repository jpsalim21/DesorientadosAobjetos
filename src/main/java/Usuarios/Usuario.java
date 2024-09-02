/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import java.util.*;
/**
 *
 * @author ice
 */
public abstract class Usuario {
    private String nome;
    private String senha;
    private List<Torneio> torneio = new ArrayList<>();
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    
}
