/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;

import Eventos.*;
import Eventos.Interface.Confirmar;
import Excecao.*;
import Usuarios.*;
import java.awt.*;
import javax.swing.*;

public class Janela2 implements JanelaInterface {
    
    private JFrame tela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    private JTextField tfnome;
    private JTextField tfsenha;
    String[] usuarios = {"Jogador","Juiz"};
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
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT*2/3));
        painel.setBorder(BorderFactory.createTitledBorder("Bem-Vindo"));
        
        JPanel formulario = new JPanel();
        JPanel descricao = new JPanel();
        //nao sabemos o pq funciona mas isso arruma o layout da tela de login
        descricao.setLayout(new GridLayout(0, 1, H_GAP,V_GAP+ 10));
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
        
        btnLogin.addActionListener(new Confirmar(this));
        btnCadastrar.addActionListener(new AdicionaUsuario(this));
        btnExclui.addActionListener(new ExcluiUsuario(this));
        
        JPanel botoes = new JPanel();
        botoes.add(btnLogin);
        botoes.add(btnCadastrar);
        botoes.add(btnExclui);
        
        painel.add(botoes,BorderLayout.SOUTH);
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    public void addUsuario(){
        int index = tipoUsuario.getSelectedIndex();
        try{
            if(index != -1){
                if(index == 0){
                    GerenciaUsuarios.getSingleton().adicionaJogador(tfnome.getText(), tfsenha.getText());
                }
                if(index == 1){
                    GerenciaUsuarios.getSingleton().adicionaJuiz(tfnome.getText(), tfsenha.getText());
                }
            }
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é invalida!");
        } catch (ExcecaoUsuarioJaExistente e){
            JOptionPane.showMessageDialog(tela, "Usuário já existe");
        }
    }
    
    public void removeUsuario(){
        int index = tipoUsuario.getSelectedIndex();
        GerenciaUsuarios gere = GerenciaUsuarios.getSingleton();
    
        if (index == -1) {
            JOptionPane.showMessageDialog(tela, "Nenhum usuário selecionado.");
            return;
        }
    
        String name = tfnome.getText();
        switch (index) {
            case 0 -> {
                gere.remove(name, index);
                JOptionPane.showMessageDialog(tela, "Jogador removido");
            }
            case 1 -> {
                gere.remove(name, index);
                JOptionPane.showMessageDialog(tela, "Juiz removido");
            }
            case 2 -> {
                gere.remove(name, index);
                JOptionPane.showMessageDialog(tela, "Admin removido");
            }
            default -> JOptionPane.showMessageDialog(tela, "Tipo de usuário desconhecido.");
        }
   } 

    @Override
    public void confirmar() {
        String nome = tfnome.getText();
        String senha = tfsenha.getText();
        Usuario u;
        try{
            GerenciaUsuarios.getSingleton().tentaLogin(nome, senha);
        } catch (ExcecaoDeSenha e){
            JOptionPane.showMessageDialog(tela, "A senha é inválida!");
            return;
        } catch (ExcessaoUsuarioNaoEncontrado e){
            JOptionPane.showMessageDialog(tela, "Usuario ou senha incorretos. Digite novamente");
            return;
        }
        try{
            GerenciaUsuarios.getSingleton().fazLogin();
        } catch(ExcessaoUsuarioNaoEncontrado e){
            System.out.println("Deu esse erro aqui");
            JOptionPane.showMessageDialog(tela, "Usuario ou senha incorretos. Digite novamente");
            return;
        }
        tela.dispose();
    }

    @Override
    public void retornar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
} 
  
    
