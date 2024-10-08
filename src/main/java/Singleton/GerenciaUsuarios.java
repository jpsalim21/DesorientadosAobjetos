/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Singleton;

import Excecao.ExcecaoDeSenha;
import Excecao.ExcecaoUsuarioJaExistente;
import Excecao.ExcecaoUsuarioNaoEncontrado;
import Janelas.JanelaJogador;
import Janelas.JanelaJuiz;
import Usuarios.*;
import Persistencias.*;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import static Usuarios.Usuario.TipoUsuario.JOGADOR;
import static Usuarios.Usuario.TipoUsuario.JUIZ;
import java.util.ArrayList;
import java.util.List;

public class GerenciaUsuarios {
    private static GerenciaUsuarios singleton;
    private List<Jogador> jogadores;
    private List<Juiz> juizes;
    private List<Usuario> usuarios;
    private List<TorneioSuico> torneioSuico;
    
    private Usuario usuarioLogado;
    
    private GerenciaUsuarios() {
        torneioSuico = new ArrayList<>();
    }
    public static GerenciaUsuarios getSingleton(){
        if(singleton == null){
            singleton = new GerenciaUsuarios();
        }
        return singleton;
    }
    
    public void carregaUsuarios(){
        Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
        Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
        Persistencia<TorneioSuico> torPersistencia = new TorneioSuicoPersistencia();
        jogadores = jogPersistencia.findAll();
        juizes = juiPersistencia.findAll();
        torneioSuico = torPersistencia.findAll();
        usuarios = new ArrayList<>();
        usuarios.addAll(juizes);
        usuarios.addAll(jogadores);
    }
    
    public void chamaPersistencia() {
        if(jogadores != null){
            Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
            jogPersistencia.save(jogadores);
        }
        if(juizes != null){
            Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
            juiPersistencia.save(juizes);
        }
        if(torneioSuico != null){
            Persistencia<TorneioSuico> torPersistencia = new TorneioSuicoPersistencia();
            torPersistencia.save(torneioSuico);
        }
    }

    public void adicionaJogador(String nome, String senha) throws ExcecaoUsuarioJaExistente,ExcecaoDeSenha{
        procuraNomeIgual(nome);
        Jogador newJogador = new Jogador(nome, senha);
        jogadores.add(newJogador);
        usuarios.add(newJogador);
    }
    public void adicionaJuiz(String nome, String senha) throws ExcecaoUsuarioJaExistente,ExcecaoDeSenha{
        procuraNomeIgual(nome);
        Juiz newJuiz = new Juiz(nome, senha);
        juizes.add(newJuiz);
        usuarios.add(newJuiz);
    }
    private void procuraNomeIgual(String nome) throws ExcecaoUsuarioJaExistente{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                throw new ExcecaoUsuarioJaExistente();
            }
        }
    }
    public Jogador procuraJogador(String nome) throws ExcecaoUsuarioNaoEncontrado{
        for(Jogador j : jogadores){
            if(j.getNome().equals(nome)){
                return j;
            }
        }
        throw new ExcecaoUsuarioNaoEncontrado();
    }
    public Jogador procuraJogador(int id) throws ExcecaoUsuarioNaoEncontrado{
        for(Jogador j : jogadores){
            if(j.getID() == id){
                return j;
            }
        }
        throw new ExcecaoUsuarioNaoEncontrado();
    }
    public Usuario procuraUsuario(int id) throws ExcecaoUsuarioNaoEncontrado{
        for(Usuario u : usuarios){
            if(u.getID() == id){
                return u;
            }
        }
        throw new ExcecaoUsuarioNaoEncontrado();
    }
    public void remove(int id){
        Usuario usuarioRemover = null;
        for(Usuario u : usuarios){
            if(u.getID() == id){
                usuarioRemover = u;
            }
        }
        if(usuarioRemover == null){
            return;
        }
        switch(usuarioRemover.getTipoUsuario()){
            case JOGADOR -> {
                jogadores.remove((Jogador)usuarioRemover);
            }
            case JUIZ -> {
                juizes.remove((Juiz)usuarioRemover);
            }
        }
        usuarios.remove(usuarioRemover);
        usuarioRemover.remover();
        chamaPersistencia();
    }
    
    public void remove(String nome, int tipo){
        int cont = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNome().equals(nome)) {
                cont = i;
                break;
            }
        }
    
        if (cont == -1) {
            return;
        }
    
        Usuario usuario = usuarios.get(cont);
        switch (tipo) {
            case 0 -> {
                if (usuario instanceof Jogador j) {
                    jogadores.remove(j);
                    usuarios.remove(usuario);
                }
            }
            case 1 -> {
                if (usuario instanceof Juiz j) {
                    juizes.remove(j);
                    usuarios.remove(usuario);
                   
                }
            }
        }
        chamaPersistencia();
    }

    public void tentaLogin(String nome, String senha) throws ExcecaoUsuarioNaoEncontrado,ExcecaoDeSenha{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                if(u.getSenha().equals(senha)){
                    usuarioLogado = u;
                    return;
                }
            }
        }
        throw new ExcecaoUsuarioNaoEncontrado();
    }
    
    public void fazLogin() throws ExcecaoUsuarioNaoEncontrado{
        if(usuarioLogado == null) {
            throw new ExcecaoUsuarioNaoEncontrado();
        }
        
        switch(usuarioLogado.getTipoUsuario()){
            case JOGADOR -> {
                JanelaJogador janelaJogador = new JanelaJogador((Jogador)usuarioLogado);
            }
            case JUIZ -> {
                JanelaJuiz janelaJuiz = new JanelaJuiz((Juiz)usuarioLogado);
            }

        }
    }
    
    public void adicionaTorneio(TorneioSuico t){
        torneioSuico.add(t);
    }
    
    public void removerTorneio(TorneioSuico t){
        torneioSuico.remove(t);
        t.remover();
    }
    
    public TorneioSuico getTorneioByID(int id){
        for(TorneioSuico t : torneioSuico){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    
    public List<Torneio> getTorneios(List<Integer> ids){
        List<Torneio> retorno = new ArrayList<>();
        for(int id : ids){
            for(TorneioSuico t : torneioSuico){
                if(t.getId() == id){
                    retorno.add(t);
                }
            }
        }
        return retorno;
    }
    
    public List<TorneioSuico> getAllTournaments(){
        return torneioSuico;
    }
    
    public List<Usuario> getUsers(){
        return usuarios;
    }
    
    public Usuario getUsuario(){
        return usuarioLogado;
    }
}
