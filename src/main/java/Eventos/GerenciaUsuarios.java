/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Excecao.ExcecaoUsuarioJaExistente;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Usuarios.*;
import Persistencias.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateu
 */
public class GerenciaUsuarios implements WindowListener{
    private static GerenciaUsuarios singleton;
    List<Jogador> jogadores;
    List<Juiz> juizes;
    List<Admin> administradores;
    List<Usuario> usuarios;

    public GerenciaUsuarios() {
        if(singleton != null){
            return;
        }
        singleton = this;
    }
    public static GerenciaUsuarios getSingleton(){
        return singleton;
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
        Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
        Persistencia<Admin> admPersistencia = new AdminPersistencia();
        jogadores = jogPersistencia.findAll();
        juizes = juiPersistencia.findAll();
        administradores = admPersistencia.findAll();
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
    public void adicionaJogador(String nome, Senha senha) throws ExcecaoUsuarioJaExistente{
        procuraNomeIgual(nome);
        Jogador newJogador = new Jogador(nome, senha);
        jogadores.add(newJogador);
        usuarios.add(newJogador);
        System.out.println("Adicionou novo jogador");
    }
    public void adicionaJuiz(String nome, Senha senha) throws ExcecaoUsuarioJaExistente{
        procuraNomeIgual(nome);
        Juiz newJuiz = new Juiz(nome, senha);
        juizes.add(newJuiz);
        usuarios.add(newJuiz);
        System.out.println("Adicionou novo juiz");
    }
    public void adicionaAdmin(String nome, Senha senha) throws ExcecaoUsuarioJaExistente{
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
                if (usuario instanceof Jogador) {
                    jogadores.remove(usuario);
                    usuarios.remove(usuario);
                    System.out.println("Jogador removido.");
                } else {
                    System.out.println("Usuário não é um jogador.");
                }
            }
            case 1 -> {
                if (usuario instanceof Juiz) {
                    juizes.remove(usuario);
                    usuarios.remove(usuario);
                    System.out.println("Juiz removido.");
                } else {
                    System.out.println("Usuário não é um juiz.");
                }
            }
            case 2 -> {
                if (usuario instanceof Admin) {
                    administradores.remove(usuario);
                    usuarios.remove(usuario);
                    System.out.println("Admin removido.");
                } else {
                    System.out.println("Usuário não é um admin.");
                }
            }
            default -> System.out.println("Tipo de usuário desconhecido.");
        }
    }
   
    public void tentaLogin(String nome, Senha senha) throws ExcessaoUsuarioNaoEncontrado{
        for(Usuario u : usuarios){
            if(u.getNome().equals(nome)){
                //FIXME: Isso tá muito feio, quero arrumar isso. 
                //Mas parece que o problema é a classe Senha
                if(u.getSenha().getSenha().equals(senha.getSenha())){
                    return;
                    
                }
            }
        }
        throw new ExcessaoUsuarioNaoEncontrado();
    }
}
