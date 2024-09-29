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
    private final int codigo;
    List<Juiz> juizes;
    List<JogadorParticipante> participantes;
    protected List<List<JogadorParticipante>> infoClassificacao;
    protected List<List<Confronto>> infoRodadas;
    
    public Torneio(String nome){
        this.nome = nome;
        juizes = new ArrayList<>();
        participantes = new ArrayList<>();
        GeradorID gerador = GeradorID.getSingleton();
        codigo = gerador.generateTournamentID();
        GerenciaUsuarios.getSingleton().adicionaTorneio(this);
        
        
    }
    
    public void adicionarParticipante(Jogador novoJogador){
        novoJogador.addTorneio(codigo);
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
