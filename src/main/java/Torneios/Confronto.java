/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneios;

/**
 *
 * @author ice
 */
public class Confronto {
    private final JogadorParticipante jogador1;
    private final JogadorParticipante jogador2;
    private JogadorParticipante vencedor = null;
    
    public Confronto(JogadorParticipante j1, JogadorParticipante j2){
        jogador1 = j1;
        jogador2 = j2;
    }
    //Pode ter jeitos melhores de setar isso, mas como temos caso de empate, não podemos usar boolean
    public void setResultado(int r){
        switch(r){
            case -1 -> {
                jogador1.getUsuario().addVitorias();
                jogador2.getUsuario().addDerrotas();
                vencedor = jogador1;
                jogador1.adicionarPontuacao(1);
            }
            case 0 -> {
                jogador1.getUsuario().addEmpates();
                jogador2.getUsuario().addEmpates();
                jogador1.adicionarPontuacao(0.5f);
                jogador2.adicionarPontuacao(0.5f);
            }
            case 1 -> {
                jogador1.getUsuario().addDerrotas();
                jogador2.getUsuario().addVitorias();
                vencedor = jogador2;
                jogador2.adicionarPontuacao(1);
            }
        }
    }
    public JogadorParticipante getVencedor(){
        return vencedor;
    }
    
    
}
