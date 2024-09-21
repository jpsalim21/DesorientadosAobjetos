/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Torneios.JogadorParticipante;
import Torneios.Torneio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author ice
 */
public class JCriacaoEdicaoTorneio {
    private final JFrame janela;
    protected final int WIDTH = 1920;
    protected final int HEIGHT = 1080;
    protected final int V_GAP = 10;
    protected final int H_GAP = 5;
    private Torneio torneio;
    private JList<JogadorParticipante> jogadores;
    
    public JCriacaoEdicaoTorneio(Torneio t){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        this.torneio = t;
        
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela(){
        DefaultListModel<JogadorParticipante> model = new DefaultListModel<>();
        
        JPanel painel = new JPanel();
        
        JPanel torneioPanel = new JPanel();
            JPanel inputPanel = new JPanel();
            
        JPanel jogadoresPanel = new JPanel();
            JPanel botoesJogadores = new JPanel();
        
        torneioPanel.setLayout(new BorderLayout());
        torneioPanel.setBorder(BorderFactory.createTitledBorder("Informações do torneio"));
        
        inputPanel.setLayout(new GridLayout(0, 2, H_GAP, V_GAP));
        JLabel nome = new JLabel("Nome do torneio");
        inputPanel.add(nome);
        inputPanel.add(new JTextField());
        torneioPanel.add(inputPanel);
        
//        jogadores = new JList<>(model);
//        JScrollPane painelScrollTorneios = new JScrollPane(jogadores);
//        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 4/8, HEIGHT*2/5));
//        jogadores.add(painelScrollTorneios, BorderLayout.CENTER);
        
        botoesJogadores.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        botoesJogadores.add(new JButton("Adicionar Jogador"));
        botoesJogadores.add(new JButton("Deletar jogador"));
        jogadoresPanel.add(botoesJogadores, BorderLayout.SOUTH);
        
        painel.add(torneioPanel, BorderLayout.WEST);
        painel.add(jogadoresPanel, BorderLayout.CENTER);
        
        janela.add(painel);
        
        
        
    }
    
}
