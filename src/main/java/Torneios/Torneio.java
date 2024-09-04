/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneios;

import Usuarios.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Thales
 * 
 */
public class Torneio {
    private String nome;
    List<Juiz> juizes;
    List<JogadorParticipante> participantes;
    List<Admin> admins;
    
    public Torneio(String nome){
        this.nome = nome;
        juizes = new ArrayList<>();
        participantes = new ArrayList<>();
        admins = new ArrayList<>();
    }
    
    public void adicionarParticipante(Jogador novoJogador){
        JogadorParticipante novoElemento = new JogadorParticipante(novoJogador);
        participantes.add(novoElemento);
    }
    //ALERT: Podemos ter problemas aqui, já que a função pede outra classe.
    //É para revermos ao começarmos a interface visual
    public void removerParticipante(JogadorParticipante delJogador){
        participantes.remove(delJogador);
    }

    @Override
    public String toString(){
        return "Torneio: " + nome;
    }
    
}
