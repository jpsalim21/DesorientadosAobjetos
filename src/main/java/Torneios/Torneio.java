/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Torneios;

import Eventos.GerenciaUsuarios;
import Usuarios.*;
import java.util.ArrayList;
import java.util.List;

public class Torneio {
    protected final String nome;
    private static int index = 0;
    private final int codigo;
    private final Juiz juiz;
    List<JogadorParticipante> participantes;
    protected List<List<JogadorParticipante>> infoClassificacao;
    protected List<List<Confronto>> infoRodadas;
    
    public Torneio(String nome, Juiz juiz){
        this.nome = nome;
        this.juiz = juiz;
        participantes = new ArrayList<>();
        codigo = index++;
        
        this.juiz.addTorneio(codigo);
    }
    
    private void adicionarParticipante(Jogador novoJogador){
        novoJogador.addTorneio(codigo);
        JogadorParticipante novoElemento = new JogadorParticipante(novoJogador);
        participantes.add(novoElemento);
        System.out.println("Adicionei mesmo " + novoElemento.getUsuario().getNome());
    }
    
    public void adicionarListaParticipantes(List<Jogador> novosJogadores){
        for(Jogador j : novosJogadores){
            System.out.println("Adicionei " + j.getNome());
            adicionarParticipante(j);
        }
    }

    @Override
    public String toString(){
        return "Torneio: " + nome;
    }
    
    public int getId(){
        return codigo;
    }

    public Object getNome() {
        return nome;
    }

    public List<JogadorParticipante> getParticipantes() {
        return participantes;
    }  
    
    public List<Confronto> getInfoRodada(int indexRodada){
        if(infoRodadas.size() <= indexRodada){
            return null;
        }
        return infoRodadas.get(indexRodada);
    }
}
