/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Torneios.JogadorParticipante;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author PC12643
 */
public class JanelaClassificacao {
    private final JFrame tela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private JList<JogadorParticipante> jlJogadores;
    
    public JanelaClassificacao(List<JogadorParticipante> jogadores){
        tela = new JFrame("Sistema de Torneios");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaTela();
        carregarLista(jogadores);
        tela.pack();
    }
    
    private void desenhaTela(){
        DefaultListModel<JogadorParticipante> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Classificacao"));
        painelPrincipal.setLayout(new BorderLayout());
        
        jlJogadores = new JList<>(model);
        painelPrincipal.add(new JScrollPane(jlJogadores));
        
        tela.add(painelPrincipal);
    }
    private void carregarLista(List<JogadorParticipante> jogadores){
        DefaultListModel<JogadorParticipante> model = (DefaultListModel<JogadorParticipante>)jlJogadores.getModel();
        
        for(JogadorParticipante j : jogadores){
            model.addElement(j);
        }
        
    }
    
}
