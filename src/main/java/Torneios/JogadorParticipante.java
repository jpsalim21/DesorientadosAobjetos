/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneios;

import Usuarios.Jogador;

/**
 *
 * @author ice
 */
public class JogadorParticipante implements Comparable<JogadorParticipante>{
    private Jogador usuario;
    private float pontuacao;
    private boolean bye;
    
    public JogadorParticipante(Jogador j){
        usuario = j;
        pontuacao = 0;
        bye = false;
    }
    
    public Jogador getUsuario(){
        return usuario;
    }
    
    public void adicionarPontuacao(float valor){
        if(valor < 0){
            return;
        }
        pontuacao += valor;
    }
    public float getPontuacao(){
        return pontuacao;
    }
    public void setBye(){
        bye = true;
        adicionarPontuacao(1);
    }
    public boolean getBye(){
        return bye;
    }

    @Override
    public int compareTo(JogadorParticipante o) {
        return Float.compare(pontuacao, o.getPontuacao());
    }
    
}
