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
    private List<Admin> administradores;
    private List<Usuario> usuarios;
    private List<Torneio> torneios;
    
    private Usuario usuarioLogado;
    
    private GerenciaUsuarios() {
        torneios = new ArrayList<>();
    }
    public static GerenciaUsuarios getSingleton(){
        if(singleton == null){
            singleton = new GerenciaUsuarios();
        }
        return singleton;
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
        Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
        Persistencia<Admin> admPersistencia = new AdminPersistencia();
        Persistencia<Torneio> torPersistencia = new TorneiosPersistencia();
        jogadores = jogPersistencia.findAll();
        juizes = juiPersistencia.findAll();
        administradores = admPersistencia.findAll();
        torneios = torPersistencia.findAll();
        usuarios = new ArrayList<>();
        usuarios.addAll(juizes);
        usuarios.addAll(jogadores);
        usuarios.addAll(administradores);
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
        if(administradores != null){
            Persistencia<Admin> admPersistencia = new AdminPersistencia();
            admPersistencia.save(administradores);
        }
        if(torneios != null){
            Persistencia<Torneio> torPersistencia = new TorneiosPersistencia();
            torPersistencia.save(torneios);
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
    public void adicionaAdmin(String nome, String senha) throws ExcecaoUsuarioJaExistente, ExcecaoDeSenha{
        procuraNomeIgual(nome);
        Admin newAdmin = new Admin(nome, senha);
        administradores.add(newAdmin);
        usuarios.add(newAdmin);
        System.out.println("Adicionou novo admin");
    }
    private void procuraNomeIgual(String nome) throws ExcecaoUsuarioJaExistente{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                throw new ExcecaoUsuarioJaExistente();
            }
        }
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
            case 2 -> {
                if (usuario instanceof Admin a) {
                    administradores.remove(a);
                    usuarios.remove(usuario);
                    System.out.println("Admin removido.");
                } else {
                    System.out.println("Usuário não é um admin.");
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
    
    
    public void adicionaTorneio(Torneio t){
        torneios.add(t);
    }
    
    public List<Torneio> getTorneios(List<Integer> ids){
        List<Torneio> retorno = new ArrayList<>();
        for(int id : ids){
            for(Torneio t : torneios){
                if(t.getId() == id){
                    retorno.add(t);
                }
            }
        }
        return retorno;
    }
}
