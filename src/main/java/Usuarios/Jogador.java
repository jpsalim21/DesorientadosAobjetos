/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
/**
 *
 * @author ice
 */
public class Jogador extends Usuario {
    private int derrotas;
    private int empates;
    private int vitorias;
    
    public Jogador(String nome, Senha senha) {
        super(nome, senha);
        tipo = TipoUsuario.JOGADOR;
    }
    
    public int getDerrotas() {
        return derrotas;
    }

    public void addDerrotas(){
        derrotas++;
    }
    
    public int getEmpates() {
        return empates;
    }

    public void addEmpates(){
        empates++;
    }
    
    public int getVitorias() {
        return vitorias;
    }
    
    public void addVitorias(){
        vitorias++;
    }
}
