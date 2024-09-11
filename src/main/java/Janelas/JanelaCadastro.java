/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Thales
 */
public class JanelaCadastro {

    private final JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    
    public JanelaCadastro() {
        this.tela  = new JFrame("Cadastro");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        FieldETexto();
        
        tela.pack();
    }
    
    
    private void FieldETexto(){
        JPanel pain= new JPanel();
        JPanel button = new JPanel();
        JPanel fim = new JPanel();
        
        pain.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        pain.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        
        fim.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        fim.setPreferredSize(new Dimension(WIDTH/2,HEIGHT/2));
        
        button.setPreferredSize(new Dimension(WIDTH*2,HEIGHT));
        
        pain.add(new JLabel("Nome:"));
        pain.add(new JTextField(20));
        
        pain.add(new JLabel("Senha:"));
        pain.add(new JPasswordField(20));
        
        pain.add(new JLabel("Reptir senha:"));
        pain.add(new JPasswordField(20));
        
        JButton botao = new JButton("Confirmar");
        JButton botao2 = new JButton("Cancelar");
        
        button.add(botao);
        button.add(botao2);
        
        pain.add(button);
        fim.add(pain);
        
        tela.getContentPane().add(fim,BorderLayout.CENTER);
    }
    
}
