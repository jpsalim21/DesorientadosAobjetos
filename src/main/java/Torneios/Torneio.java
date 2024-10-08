/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Torneios;

import Singleton.GerenciaUsuarios;
import Excecao.ExceptionAcabou;
import Excecao.ExceptionRodadaNaoTerminou;
import Usuarios.*;
import java.util.ArrayList;
import java.util.List;
import Excecao.NaoPodeEmparceirarException;

public abstract class Torneio {
    protected final String nome;
    private final int codigo;
    private Juiz juiz;
    List<JogadorParticipante> participantes;
    protected List<List<JogadorParticipante>> infoClassificacao;
    protected List<List<Confronto>> infoRodadas;
    protected int maxRodadas = 0;
    
    public Torneio(String nome, Juiz juiz){
        this.nome = nome;
        this.juiz = juiz;
        participantes = new ArrayList<>();
        GeradorID gerador = GeradorID.getSingleton();
        codigo = gerador.generateTournamentID();
        
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
        calcularClassificacaoInicial();
    }
    
    public void removerParticipante(int id){
        for(JogadorParticipante j : participantes){
            if(j.getUsuario().getID() == id){
                participantes.remove(j);
            }
        }
    }
    
    public void removerJuiz(){
        juiz = null;
    }
    
    public abstract void emparceirar() throws NaoPodeEmparceirarException, ExceptionAcabou;
    
    protected abstract void calcularClassificacaoInicial();
    
    public abstract boolean calcularClassificacao();
    
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
    
    public List<JogadorParticipante> getClassInfo(int rodadaDesejada){
        if(rodadaDesejada >= infoClassificacao.size()){
            calcularClassificacao();
            if(rodadaDesejada >= infoClassificacao.size()){
                return null;
            }
        }
        return infoClassificacao.get(rodadaDesejada);
    }
    public List<Confronto> getRodadaInfo(int rodadaDesejada){
        if(rodadaDesejada >= infoRodadas.size()) return null;
        return infoRodadas.get(rodadaDesejada);
    }
    
    public int getMaxRodadas(){
        return maxRodadas;
    }
    
    public void remover(){
        juiz.removerTorneio(codigo);
        for(JogadorParticipante j : participantes){
            j.getUsuario().removerTorneio(codigo);
        }
    }
}
