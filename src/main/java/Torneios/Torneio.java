/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Torneios;

import Eventos.GerenciaUsuarios;
import Excecao.ExceptionAcabou;
import Excecao.ExceptionRodadaNaoTerminou;
import Usuarios.*;
import java.util.ArrayList;
import java.util.List;
import Excecao.NaoPodeEmparceirarException;

public abstract class Torneio {
    protected final String nome;
    private static int index = 0;
    private final int codigo;
    private final Juiz juiz;
    List<JogadorParticipante> participantes;
    protected List<List<JogadorParticipante>> infoClassificacao;
    protected List<List<Confronto>> infoRodadas;
    protected int maxRodadas = 0;
    
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
        calcularClassificacaoInicial();
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
}
