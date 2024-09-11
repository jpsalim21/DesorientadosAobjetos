/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Excecao.ExcecaoDeSenha;
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
    
    private JTextField nome;
    private JTextField senha;
    String[] usuarios = {"Jogador","Juiz","Usuario"};
    JComboBox tipoUsuario = new JComboBox(usuarios);
    
    public void desenha(){
        tela = new JFrame("Sistema de Torneios");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaLogin();
        
        tela.pack();
    }
    
    private void desenhaLogin(){
        JPanel painel = new JPanel();
        JPanel aux = new JPanel();
        painel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT*2/3));
        painel.setBorder(BorderFactory.createTitledBorder("Bem-Vindo"));
        aux.setPreferredSize(new Dimension(WIDTH/2,HEIGHT*1/4));
        
        JPanel formulario = new JPanel();
        JPanel descricao = new JPanel();
        descricao.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        descricao.add(new JLabel("Nome"));
        descricao.add(new JLabel("Senha"));
        
        JPanel campos = new JPanel();
        campos.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        tfnome = new JTextField(20);
        tfsenha = new JTextField(20);
        
        campos.add(tfnome);
        campos.add(tfsenha);
        
        formulario.add(descricao);
        formulario.add(campos);
        
        painel.setLayout(new BorderLayout());
        //painel.add(formulario,BorderLayout.NORTH);
        aux.add(formulario,BorderLayout.NORTH);
        
        tipoUsuario.setSelectedIndex(0);
//        painel.add(tipoUsuario);
        aux.add(tipoUsuario,BorderLayout.CENTER);
        
        painel.add(aux,BorderLayout.NORTH);
        JButton btnLogin = new JButton("Login");
        JButton btnCadastrar = new JButton("Cadastrar");
        
        JPanel botoes = new JPanel();
        botoes.add(btnLogin);
        botoes.add(btnCadastrar);
        
        painel.add(botoes,BorderLayout.SOUTH);
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }

    public void carregaUsuarios(List<Jogador> jogador, List<Juiz> juiz, List<Admin> adm){
        DefaultListModel<Jogador> l1 = (DefaultListModel<Jogador>)jogadores.getModel();
        DefaultListModel<Juiz> l2 = (DefaultListModel<Juiz>)juizes.getModel();
        DefaultListModel<Admin> l3 = (DefaultListModel<Admin>)admins.getModel();
        for(Jogador j: jogador){
            l1.addElement(j);
        }
        for(Juiz j : juiz){
            l2.addElement(j);
        }
        for(Admin a: adm){
            l3.addElement(a);
        }
    }
    
    public List<Jogador> listaJogadores(){
        DefaultListModel<Jogador> lista = (DefaultListModel<Jogador>)jogadores.getModel();
        List<Jogador> jog = new ArrayList<>();
        
        for(int i = 0; i < lista.size(); i++)
            jog.add(lista.get(i));
        return jog;
    }
    
    public List<Juiz> listaJuizes(){
        DefaultListModel<Juiz> lista = (DefaultListModel<Juiz>)juizes.getModel();
        List<Juiz> juiz = new ArrayList<>();
        
        for(int i = 0; i < lista.size(); i++)
            juiz.add(lista.get(i));
        return juiz;
    }
    
    public List<Admin> listaAdmins(){
        DefaultListModel<Admin> lista = (DefaultListModel<Admin>)admins.getModel();
        List<Admin> adm = new ArrayList<>();
        
        for(int i = 0; i < lista.size(); i++)
            adm.add(lista.get(i));
        return adm;
    }
    
    public void addUsuario(){
        int index = tipoUsuario.getSelectedIndex();
        
        if(index != -1){
            if(index == 0)
                addJogador();
            if(index == 1)
                addJuiz();
            if(index == 2)
                addAdmin();
        }
    }
    
    public void addJogador(){
        DefaultListModel<Jogador> lista = (DefaultListModel<Jogador>)jogadores.getModel();
        try {
            lista.addElement(new Jogador(tfnome.getText(),new Senha(tfsenha.getText())));
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é invalida!");
        }
    }
    
    public void addJuiz(){
        DefaultListModel<Juiz> lista = (DefaultListModel<Juiz>)juizes.getModel();
        try {
            lista.addElement(new Juiz(tfnome.getText(),new Senha(tfsenha.getText())));
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é invalida!");
        }
    }
    
    public void addAdmin(){
        DefaultListModel<Admin> lista = (DefaultListModel<Admin>)admins.getModel();
        try {
            lista.addElement(new Admin(tfnome.getText(),new Senha(tfsenha.getText())));
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é invalida!");
        }
    }
}
