/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.*;
import Excecao.*;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Usuarios.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author mateu
 */
public class Janela2 {
    
    private JFrame tela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    private JTextField tfnome;
    private JTextField tfsenha;
    private JList<Jogador> jogadores;
    private JList<Juiz> juizes;
    private JList<Admin> admins;
    String[] usuarios = {"Jogador","Juiz","Administrador"};
    JComboBox tipoUsuario = new JComboBox(usuarios);
    
    
    
    public void desenha(){
        tela = new JFrame("Sistema de Torneios");
        tela.addWindowListener(GerenciaUsuarios.getSingleton());
        
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaLogin();
        
        tela.pack();
    }

    public void dispose() {
        if (tela != null) {
            tela.dispose();
        }
    }
    
    private void desenhaLogin(){
        DefaultListModel<Jogador> l1 = new DefaultListModel<>();
        DefaultListModel<Juiz> l2 = new DefaultListModel<>();
        DefaultListModel<Admin> l3 = new DefaultListModel<>();
        jogadores = new JList<>(l1);
        juizes = new JList<>(l2);
        admins = new JList<>(l3);
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT*2/3));
        painel.setBorder(BorderFactory.createTitledBorder("Bem-Vindo"));
        
        JPanel formulario = new JPanel();
        JPanel descricao = new JPanel();
        //nao sabemos o pq funciona mas isso arruma o layout da tela de login
        descricao.setLayout(new GridLayout(0, 1, H_GAP,V_GAP + 10));
        descricao.add(new JLabel("Nome"));
        descricao.add(new JLabel("Senha"));
        descricao.add(new JLabel("Acessar como:"));
        
        JPanel campos = new JPanel();
        campos.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        tfnome = new JTextField(20);
        tfsenha = new JPasswordField(20);
        
        campos.add(tfnome);
        campos.add(tfsenha);
        campos.add(tipoUsuario);
        
        formulario.add(descricao);
        formulario.add(campos);
        
        painel.setLayout(new BorderLayout());
        painel.add(formulario,BorderLayout.NORTH);
        
        tipoUsuario.setSelectedIndex(0);
        JButton btnLogin = new JButton("Login");
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnExclui = new JButton("Exclui conta");
        
        btnLogin.addActionListener(new BotaoLogin(this));
        btnCadastrar.addActionListener(new AdicionaUsuario(this));
        btnExclui.addActionListener(new ExcluiUsuario(this));
        
        JPanel botoes = new JPanel();
        botoes.add(btnLogin);
        botoes.add(btnCadastrar);
        
        painel.add(botoes,BorderLayout.SOUTH);
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void addUsuario(){
        int index = tipoUsuario.getSelectedIndex();
        try{
            if(index != -1){
                if(index == 0){
                    GerenciaUsuarios.getSingleton().adicionaJogador(tfnome.getText(), new Senha(tfsenha.getText()));
                }
                if(index == 1){
                    GerenciaUsuarios.getSingleton().adicionaJuiz(tfnome.getText(), new Senha(tfsenha.getText()));
                }
                if(index == 2){
                    GerenciaUsuarios.getSingleton().adicionaAdmin(tfnome.getText(), new Senha(tfsenha.getText()));
                }
            }
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é invalida!");
        } catch (ExcecaoUsuarioJaExistente e){
            JOptionPane.showMessageDialog(tela, "Usuário já existe");
        }
    }
    
    public void login(){
        String nome = tfnome.getText();
        String senha = tfsenha.getText();
        try{
            //Senha senha = new Senha(tfsenha.getText());
            GerenciaUsuarios.getSingleton().tentaLogin(nome, senha);
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é inválida!");
            return;
        } catch (ExcessaoUsuarioNaoEncontrado e){
            JOptionPane.showMessageDialog(tela, "Usuario ou senha não estão corretos. Digite novamente");
            return;
        }
        JanelaUsuario secondFrame = new JanelaUsuario();
        tela.dispose();
    }
    
    public void removeUsuario(){
        //diferenciar usuario ativo
        
    }
}
