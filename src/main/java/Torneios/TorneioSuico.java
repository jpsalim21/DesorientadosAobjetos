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
import Excecao.NaoPodeEmparceirarException;

public class TorneioSuico extends Torneio{
    private int rodadaAtual;
    
    public TorneioSuico(String nome, Juiz juiz, int rodadas) {
        super(nome, juiz);
        rodadaAtual = 0;
        this.maxRodadas = rodadas;
        GerenciaUsuarios.getSingleton().adicionaTorneio(this);
        
        infoClassificacao = new ArrayList<>();
        infoRodadas = new ArrayList<>();
        
    }
    @Override
    public void emparceirar() throws NaoPodeEmparceirarException{
        if(!calcularClassificacao()){
            throw new NaoPodeEmparceirarException();
        }
        
        List<Confronto> infoRodadaAtual = new ArrayList<>();
        List<JogadorParticipante> classificacao = new ArrayList<>();
        classificacao.addAll(infoClassificacao.get(rodadaAtual));
        System.out.println("Peguei classificacao pré rodada " + rodadaAtual);
        int tamanho = classificacao.size();
        
        //Resolve BYE do último jogador
        if(tamanho%2==1){
            int indiceUltimoBye = tamanho - 1;
            while(classificacao.get(indiceUltimoBye).getBye()){
                indiceUltimoBye--;
            }
            classificacao.get(indiceUltimoBye).setBye();
            classificacao.remove(indiceUltimoBye);
        }
        //Emparceiramento de fato
        tamanho = classificacao.size() / 2;
        for(int i = 0; i < tamanho; i++){
            Confronto c = new Confronto(classificacao.get(i), classificacao.get(i + tamanho));
            System.out.println(classificacao.get(i).getUsuario().getNome() + " x " + classificacao.get(i + tamanho).getUsuario().getNome());
            infoRodadaAtual.add(c);
        }
        
        rodadaAtual++;
        infoRodadas.add(infoRodadaAtual);
    }
    private boolean calcularClassificacao(){
        System.out.println("Calculando classificacao da rodada " + rodadaAtual);
        System.out.println("infoRodadas tem " + infoRodadas.size());
        for(Confronto c : infoRodadas.get(rodadaAtual - 1)){
            if(!c.getTerminouConfronto()){
                return false;
            }
        }
        
        for(Confronto c : infoRodadas.get(rodadaAtual - 1)){
            c.terminarConfronto();
        }
        
        List<JogadorParticipante> classificacao = new ArrayList<>();
        classificacao.addAll(participantes);
        
        Collections.sort(classificacao);
        for(JogadorParticipante j : classificacao){
            System.out.println(j.getUsuario().getNome());
        }
        
        
        infoClassificacao.add(classificacao);
        return true;
    }
    @Override
    protected void calcularClassificacaoInicial(){
        List<JogadorParticipante> classificacao = new ArrayList<>();
        classificacao.addAll(participantes);
        Collections.sort(classificacao);
        
        for(JogadorParticipante j : classificacao){
            System.out.println(j.getUsuario().getNome());
        }
        
        infoClassificacao.add(classificacao);
        
        List<Confronto> infoRodadaAtual = new ArrayList<>();
        System.out.println("Peguei classificacao pré rodada " + rodadaAtual);
        int tamanho = classificacao.size();
        
        //Resolve BYE do último jogador
        if(tamanho%2==1){
            int indiceUltimoBye = tamanho - 1;
            while(classificacao.get(indiceUltimoBye).getBye()){
                indiceUltimoBye--;
            }
            classificacao.get(indiceUltimoBye).setBye();
            classificacao.remove(indiceUltimoBye);
        }
        //Emparceiramento de fato
        tamanho = classificacao.size() / 2;
        for(int i = 0; i < tamanho; i++){
            Confronto c = new Confronto(classificacao.get(i), classificacao.get(i + tamanho));
            System.out.println(classificacao.get(i).getUsuario().getNome() + " x " + classificacao.get(i + tamanho).getUsuario().getNome());
            infoRodadaAtual.add(c);
        }
        
        infoRodadas.add(infoRodadaAtual);
        rodadaAtual++;
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
