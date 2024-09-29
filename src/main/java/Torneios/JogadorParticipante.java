/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Torneios;

import Singleton.GerenciaUsuarios;
import Excecao.ExcecaoUsuarioNaoEncontrado;
import Usuarios.Jogador;

public class JogadorParticipante implements Comparable<JogadorParticipante>{
    private final int usuario;
    private float pontuacao;
    private boolean bye;
    
    public JogadorParticipante(Jogador j){
        usuario = j.getID();
        pontuacao = 0;
        bye = false;
    }
    
    public Jogador getUsuario(){
        try {
            return GerenciaUsuarios.getSingleton().procuraJogador(usuario);
        } catch (ExcecaoUsuarioNaoEncontrado ex) {
            return null;
        }
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
        return Float.compare(o.getPontuacao(), pontuacao);
    }
    @Override
    public String toString(){
        return getUsuario().getNome() + ": " + pontuacao + " pontos";
    }
    
}
