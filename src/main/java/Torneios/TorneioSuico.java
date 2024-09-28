/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Torneios;

import Eventos.GerenciaUsuarios;
import Usuarios.Juiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TorneioSuico extends Torneio{
    private int rodadaAtual;
    
    public TorneioSuico(String nome, Juiz juiz, int rodadas) {
        super(nome, juiz);
        rodadaAtual = 0;
        
        GerenciaUsuarios.getSingleton().adicionaTorneio(this);
        
        infoClassificacao = new ArrayList<>();
        infoRodadas = new ArrayList<>();
    }
    
    public void emparceirar(){
        List<Confronto> infoRodadaAtual = new ArrayList<>();
        List<JogadorParticipante> classificacao = infoClassificacao.get(rodadaAtual);
        int tamanho = classificacao.size();
        
        //Resolve BYE do último jogador
        if(tamanho%2==1){
            int indiceUltimoBye = tamanho - 1;
            while(classificacao.get(indiceUltimoBye).getBye()){
                indiceUltimoBye--;
            }
            classificacao.get(indiceUltimoBye).setBye();
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
    @Override
    public String toString(){
        return "Torneio suico: " + nome;
    }
}
