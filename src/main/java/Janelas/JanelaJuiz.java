/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package Janelas;
//import Torneios.Torneio;
//import Usuarios.Jogador;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import javax.swing.*;
//import java.util.*;
///**
// *
// * @author Vai ficar comentada por enquanto
// */
//public class JanelaJuiz {
//    private JFrame janela;
//    private final int WIDTH = 1920;
//    private final int HEIGHT = 1080;
//    private final int V_GAP = 10;
//    private final int H_GAP = 5;
//    private JList<Jogador> jogadoresEscritos;
//    private JList<Torneio> torneiosEntrados;
//    
//    
//    public JanelaJuiz(){
//        janela = new JFrame();
//        janela.setSize(new Dimension(WIDTH, HEIGHT));
//        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        janela.setVisible(true);
//        janela.setLayout(new BorderLayout());
//        desenhaTela();
//        
//        janela.pack();
//    }
//    
//    private void desenhaTela(){
//        DefaultListModel<Torneio> model = new DefaultListModel<>();
//        DefaultListModel<Jogador> model2 = new DefaultListModel<>();
//        
//        JPanel princip = new JPanel();
//        JPanel botoesPainelJuiz = new JPanel();
//        JPanel TorneioP = new JPanel();
//        JPanel Ljogador = new JPanel();
//        
//        TorneioP.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        TorneioP.setBorder(BorderFactory.createTitledBorder("Torenio"));        
//        
//        Ljogador.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        Ljogador.setBorder(BorderFactory.createTitledBorder("Lista do jogador"));
//        Ljogador.setLayout(new BorderLayout());
//       
//        torneiosEntrados = new JList<>(model);
//        jogadoresEscritos = new JList<>(model2);
//        
//        JScrollPane painelScrollTorneios = new JScrollPane(torneiosEntrados);
//        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 5/8, HEIGHT*3/5));
//        
//        JScrollPane painelScrollJogador = new JScrollPane(jogadoresEscritos);
//        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 5/8, HEIGHT*3/5));
//        
//        Ljogador.add(painelScrollJogador,BorderLayout.CENTER);
//        TorneioP.add(painelScrollTorneios,BorderLayout.CENTER);
//        
//        JButton btnComeça = new JButton("Começar Torneio");
//        JButton btnEdita = new JButton("Editar Torneio");
//        JButton btnSai = new JButton("Sair");
//        
//        botoesPainelJuiz.add(btnComeça);
//        botoesPainelJuiz.add(btnEdita);
//        botoesPainelJuiz.add(btnSai);
//        
//        
//        princip.add( TorneioP, BorderLayout.WEST);
//        princip.add(Ljogador, BorderLayout.EAST);
//        princip.add(botoesPainelJuiz,BorderLayout.SOUTH);
//        
//        janela.add(princip);
//    }
//}
