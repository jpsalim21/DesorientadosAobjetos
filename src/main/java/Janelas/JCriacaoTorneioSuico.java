/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JCriacaoTorneioSuico {
    private final JFrame janela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    public JCriacaoTorneioSuico(){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Informações do torneio"));
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        
        JLabel nomeLabel = new JLabel("Nome do torneio: ");
        JTextField nomeField = new JTextField(20);
        
        JLabel rodadasLabel = new JLabel("Quantas rodadas: ");
        JTextField rodadasField = new JTextField(2);
        
        formulario.add(nomeLabel);
        formulario.add(nomeField);
        formulario.add(rodadasLabel);
        formulario.add(rodadasField);
        
        painelPrincipal.add(formulario);
        
        
        janela.add(painelPrincipal);
    }
}
