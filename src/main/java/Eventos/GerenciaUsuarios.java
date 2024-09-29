/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Excecao.ExcecaoDeSenha;
import Excecao.ExcecaoUsuarioJaExistente;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Janelas.JanelaJogador;
import Janelas.JanelaJuizNew;
import Usuarios.*;
import Persistencias.*;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import static Usuarios.Usuario.TipoUsuario.JOGADOR;
import static Usuarios.Usuario.TipoUsuario.JUIZ;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class GerenciaUsuarios implements WindowListener{
    private static GerenciaUsuarios singleton;
    private List<Jogador> jogadores;
    private List<Juiz> juizes;
    private List<Usuario> usuarios;
    //private List<Torneio> torneios;
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
    
    public void abriuPrograma(){
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
    
    @Override
    public void windowClosing(WindowEvent e) {
        if(jogadores != null){
            Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
            jogPersistencia.save(jogadores);
        }
        if(juizes != null){
            Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
            juiPersistencia.save(juizes);
        }
        if(torneioSuico != null){
            System.out.println("Salvou os torneios");
            System.out.println("Temos x torneios:" + torneioSuico.size());
            Persistencia<TorneioSuico> torPersistencia = new TorneioSuicoPersistencia();
            torPersistencia.save(torneioSuico);
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    public void adicionaJogador(String nome, String senha) throws ExcecaoUsuarioJaExistente,ExcecaoDeSenha{
        procuraNomeIgual(nome);
        Jogador newJogador = new Jogador(nome, senha);
        jogadores.add(newJogador);
        usuarios.add(newJogador);
        System.out.println("Adicionou novo jogador");
    }
    public void adicionaJuiz(String nome, String senha) throws ExcecaoUsuarioJaExistente,ExcecaoDeSenha{
        procuraNomeIgual(nome);
        Juiz newJuiz = new Juiz(nome, senha);
        juizes.add(newJuiz);
        usuarios.add(newJuiz);
        System.out.println("Adicionou novo juiz");
    }
    private void procuraNomeIgual(String nome) throws ExcecaoUsuarioJaExistente{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                throw new ExcecaoUsuarioJaExistente();
            }
        }
    }
    public Jogador procuraJogador(String nome) throws ExcessaoUsuarioNaoEncontrado{
        for(Jogador j : jogadores){
            if(j.getNome().equals(nome)){
                return j;
            }
        }
        throw new ExcessaoUsuarioNaoEncontrado();
    }
    public Jogador procuraJogador(int id) throws ExcessaoUsuarioNaoEncontrado{
        for(Jogador j : jogadores){
            if(j.getID() == id){
                return j;
            }
        }
        throw new ExcessaoUsuarioNaoEncontrado();
    }
    public Usuario procuraUsuario(int id) throws ExcessaoUsuarioNaoEncontrado{
        for(Usuario u : usuarios){
            if(u.getID() == id){
                return u;
            }
        }
        throw new ExcessaoUsuarioNaoEncontrado();
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
            System.out.println("Usuário não encontrado.");
            return;
        }
    
        Usuario usuario = usuarios.get(cont);
        switch (tipo) {
            case 0 -> {
                if (usuario instanceof Jogador j) {
                    jogadores.remove(j);
                    usuarios.remove(usuario);
                    System.out.println("Jogador removido.");
                } else {
                    System.out.println("Usuário não é um jogador.");
                }
            }
            case 1 -> {
                if (usuario instanceof Juiz j) {
                    juizes.remove(j);
                    usuarios.remove(usuario);
                    System.out.println("Juiz removido.");
                } else {
                    System.out.println("Usuário não é um juiz.");
                }
            }
            default -> System.out.println("Tipo de usuário desconhecido.");
        }
    }

    public void tentaLogin(String nome, String senha) throws ExcessaoUsuarioNaoEncontrado,ExcecaoDeSenha{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                if(u.getSenha().equals(senha)){
                    usuarioLogado = u;
                    return;
                }
            }
        }
        throw new ExcessaoUsuarioNaoEncontrado();
    }
    
    public void fazLogin() throws ExcessaoUsuarioNaoEncontrado{
        if(usuarioLogado == null) {
            throw new ExcessaoUsuarioNaoEncontrado();
        }
        
        switch(usuarioLogado.getTipoUsuario()){
            case JOGADOR -> {
                JanelaJogador janelaJogador = new JanelaJogador((Jogador)usuarioLogado);
            }
            case JUIZ -> {
                JanelaJuizNew janelaJuiz = new JanelaJuizNew((Juiz)usuarioLogado);
            }
        }
    }
    
    
    public void adicionaTorneio(TorneioSuico t){
        System.out.println("Adicionamos um torneio");
        torneioSuico.add(t);
        System.out.println(torneioSuico.size());
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

    @Override
    public void windowOpened(WindowEvent e) {
        
    }
}
