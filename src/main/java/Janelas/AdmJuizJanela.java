/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;
import Torneios.Torneio;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Thales
 */
public class AdmJuizJanela{
    private JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 200;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private JList<Torneio>torneios;
    
    private AdmJuizJanela(){
        //Sei que ta igual o bgl do gleiph, mas não tem muito como fugir aqui isso é uma lista
        tela = new JFrame();
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());

        desenhaLista();

        tela.pack();
    }
    
    private void desenhaLista(){
        JPanel painel = new JPanel();
        
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Torneios"));
        painel.setBorder(BorderFactory.createTitledBorder("Contatos"));
        painel.setPreferredSize(new Dimension(WIDTH/3, HEIGHT));
        painel.setLayout(new BorderLayout());
        
        torneios = new JList<>();
        //torneios.addListSelectionListener(listener);

        painel.add(new JScrollPane(torneios), BorderLayout.CENTER);
    }
}
