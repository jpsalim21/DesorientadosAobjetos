/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import java.util.*;
import Torneios.*;
/**
 *
 * @author Thales
 */
public abstract class Usuario {
    private String nome;
    private String senha;
    protected List<Torneio> torneio = new ArrayList<>();
    
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    
    public void addTorneio(Torneio torneio){
        this.torneio.add(torneio);
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    //faz sentido assim?
    public List<Torneio> getTorneio() {
        return torneio;
    }
    
}
