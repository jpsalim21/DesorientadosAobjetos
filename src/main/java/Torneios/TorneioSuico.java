/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneios;

import Usuarios.Jogador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ice
 */
public class TorneioSuico extends Torneio{
    
    private List<List<JogadorParticipante>> infoClassificacao;
    private List<List<Confronto>> infoRodadas;
    private int rodadaAtual;
    
    public TorneioSuico(String nome, int rodadas) {
        super(nome);
        rodadaAtual = 0;
        
        infoClassificacao = new ArrayList<>();
        infoRodadas = new ArrayList<>();
    }
    
    public void emparceirar(){
        List<Confronto> infoRodadaAtual = new ArrayList<>();
        List<JogadorParticipante> classificacao = infoClassificacao.get(rodadaAtual);
        int tamanho = classificacao.size();
        
        //Resolve BYE do último jogador
        if(tamanho%2==1){
            classificacao.get(tamanho - 1).setBye();
        }
        //Emparceiramento de fato
        tamanho = tamanho / 2;
        for(int i = 0; i < tamanho; i++){
            Confronto c = new Confronto(classificacao.get(i), classificacao.get(i + tamanho));
            infoRodadaAtual.add(c);
        }
        
        
        rodadaAtual++;
        infoRodadas.add(infoRodadaAtual);
    }
    private void calcularClassificacao(){
        for(Confronto c : infoRodadas.get(rodadaAtual)){
            if(!c.getTerminouConfronto()){
                return;
            }
        }
        
        List<JogadorParticipante> classificacao = new ArrayList<>();
        classificacao.addAll(participantes);
        
        Collections.sort(classificacao);
        
        infoClassificacao.add(classificacao);
    }
    
    public List<JogadorParticipante> getClassInfo(int rodadaDesejada){
        return infoClassificacao.get(rodadaDesejada);
    }
    public List<Confronto> getRodadaInfo(int rodadaDesejada){
        return infoRodadas.get(rodadaDesejada);
    }
    
}
