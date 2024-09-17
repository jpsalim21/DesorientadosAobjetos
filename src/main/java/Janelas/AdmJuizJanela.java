/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;
import Eventos.DeslogaJuiz;
import Torneios.Torneio;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Thales
 */
public class AdmJuizJanela{
    
    //Oq falta aqui é mexer com a edição de torneio e no negocio de acessar torneio
    //ver com eles um jeito de mexer no torneio
    private final JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private JList<Torneio>torneios;
    
    public AdmJuizJanela(){
        tela = new JFrame("Tela Adm e Juiz");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        //tela.setResizable(false);

        colocaResto();
        desenhaLista();
        tela.pack();
    }
    
    private void desenhaLista(){
        JPanel painel = new JPanel();
        
        painel.setBorder(BorderFactory.createTitledBorder("Torneios"));
        painel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        painel.setLayout(new BorderLayout());
        
        torneios = new JList<>();
        //torneios.addListSelectionListener(listener);
        painel.setPreferredSize(new Dimension(550,HEIGHT));
        painel.add(new JScrollPane(torneios), BorderLayout.CENTER);
        tela.getContentPane().add(painel,BorderLayout.WEST);
    }
    
    private void colocaResto(){
        
        JPanel forms = new JPanel();
        JPanel resto = new JPanel();
        JPanel resto2 = new JPanel();
        JPanel botoes = new JPanel();
        
        forms.setPreferredSize(new Dimension(WIDTH,HEIGHT*2));
        forms.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
       
        JButton btnComeça = new JButton("Começar Torneio");
        JButton btnEdita = new JButton("Editar Torneio");
        JButton btnSai = new JButton("Sair");
        JButton botao2 = new JButton("Adicionar Jogador");
        JButton botao3 = new JButton("Remover Jogador");
//        JButton botao2 = new JButton("Adicionar Juiz");
//        JButton botao3 = new JButton("Remover Juiz");
//          minha ideia aqui é passar o tipo  (juiz ou adm e dai deixa esses botões visiveis pro adm)       
        btnSai.addActionListener(new DeslogaJuiz(this));
        
        botoes.add(btnComeça);
        botoes.add(btnEdita);
        botoes.add(botao2);
        botoes.add(botao3);
        botoes.add(btnSai);
       
        forms.add(new JLabel("Nome do torneio:"));
        forms.add(new JTextField(20));
        
        forms.add(new JLabel("Participante:"));
        forms.add(new JTextField(20));
        
        forms.add(new JLabel("Vitorias:"));
        forms.add(new JTextField(20));
        
        forms.add(botoes);
        
        resto2.add(forms);
        
        resto.add(resto2, BorderLayout.EAST);
        tela.getContentPane().add(resto);
        
    }
    
     public void Desloga(){
        JanelaUsuario janelas = new JanelaUsuario(); 
        tela.dispose();
    }
}
