/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.*;
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
    String[] usuarios = {"Jogador","Juiz","Administrador"};
    JComboBox tipoUsuario = new JComboBox(usuarios);
    
    
    
    public void desenha(){
        tela = new JFrame("Sistema de Torneios");
        tela.addWindowListener(new GerenciaUsuarios(this));
        
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
        descricao.add(new JLabel());
        
        JPanel campos = new JPanel();
        campos.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        tfnome = new JTextField(20);
        tfsenha = new JTextField(20);
//      tfsenha = new JPasswordField(20) ;  Esse é campo de senha que o gleiph disse
        
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
        botoes.add(btnExclui);
        
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
    //implementar função de busca de usuario se usuario for cadastrado return true
    
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
    
    public void login(){
        String nome = tfnome.getText();
        try{
            Senha senha = new Senha(tfsenha.getText());
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é inválida!");
        } finally { 
            //Fazer aqui a verificação de login
            //Provavelmente tem outro try catch aqui para dar excecao Usuário Nao Encontrado
            
        }
        System.out.println("Tentou fazer login");
    }
    
    //FIXME esse bgl ta o mais primitivo possivel peço perdão
    //Esse negocio ficou pior pq tinha esquecido do singleton
    //Devo melhorar isso dps
    
    public void removeUsuario(){
       int index = tipoUsuario.getSelectedIndex();

       if(index !=-1){
           if(index == 0){
         int selectedIndex = jogadores.getSelectedIndex();
                if (selectedIndex != -1 && selectedIndex < jogadores.getModel().getSize()) {
                    DefaultListModel<Jogador> model = (DefaultListModel<Jogador>) jogadores.getModel();
                    model.remove(selectedIndex);
                    JOptionPane.showMessageDialog(tela, "Usuário removido");
                } else {
                    System.out.println("Nenhum jogador selecionado ou índice fora dos limites.");
                }
           }
           if(index == 1){
        int selectedIndex = juizes.getSelectedIndex();
                if (selectedIndex != -1 && selectedIndex < juizes.getModel().getSize()) {
                    DefaultListModel<Juiz> model = (DefaultListModel<Juiz>) juizes.getModel();
                    model.remove(selectedIndex);
                    JOptionPane.showMessageDialog(tela, "Usuário removido");
                } else {
                    System.out.println("Nenhum juiz selecionado ou índice fora dos limites.");
                }
           }
           if(index == 2){
        int selectedIndex = admins.getSelectedIndex();
                if (selectedIndex != -1 && selectedIndex < admins.getModel().getSize()) {
                    DefaultListModel<Admin> model = (DefaultListModel<Admin>) admins.getModel();
                    model.remove(selectedIndex);
                    JOptionPane.showMessageDialog(tela, "Usuário removido");
                } else {
                    System.out.println("Nenhum administrador selecionado ou índice fora dos limites.");
                }
       
           }
       } 
    }
}
