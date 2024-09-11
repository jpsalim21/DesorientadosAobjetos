/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Usuarios.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * @author Thales
 */
public class Janela extends JFrame {
   //private JDesktopPane desktop; não to usando
   private JPanel painel;
   private JFrame tela;
   private JTextField tfUsuario;
   private JTextField tfSenha;
   private final int WIDTH = 500;
   private final int HEIGHT = 200;
   private final int V_GAP = 10;
   private final int H_GAP = 5;
   
   private JTextField nome;
   private JTextField senha;
   private JList<Jogador> jogadores;
   private JList<Juiz> juizes;
   private JList<Admin> admins;
   /*public Janela(){
       super("Janela");
       Dimension screenSize = 
   }*/
   
   public void Janela(){
       tela = new JFrame("TESTE");
       
       //Mexer com icon dps
       //tela.setIconImage(image); Add uma imagem formato "imagem.png"
       //tela.addWindowListener(a); Ver oque deve ser adcionado de parametro na hora de abrir janela
       
       tela.setSize(WIDTH, HEIGHT);
       tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       tela.setVisible(true);
       tela.setLayout(new BorderLayout());
       
       desenhaMenu();      

       tela.pack();
   }
   
   private void desenhaMenu(){
       //ficou melhor, porém não bom
       painel = new JPanel();
       JPanel painel2= new JPanel(); 
       JPanel painelField= new JPanel(); 
       
       painel.setBorder(BorderFactory.createCompoundBorder());
       painel2.setBorder(BorderFactory.createCompoundBorder());
       
       painel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
       painel2.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/2));
       
       painel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));   
       painel2.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
       
       
       painel2.add(new JLabel("Alguma coisa:"),BorderLayout.CENTER);
       painel2.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));
       painel.add(painel2);
       
       
       painelField.setBorder(BorderFactory.createEmptyBorder());
       painelField.setLayout(new GridLayout(0, 1, H_GAP/3, V_GAP));
       painelField.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/2));
       
       painelField.add(new JLabel("Usuário:"));
       painelField.add(new JTextField(20));
       
       painelField.add(new JLabel("Senha:"));
       painelField.add(new JTextField(20));
       
       painel2.add(painelField);
       
       JButton botao = new JButton("Adm");
    //    botao.addActionListener(new AdmJ());
       JButton botaoU = new JButton("Usuário");
    //    botao.addActionListener(this);
        JButton botaoJ = new JButton("Juiz");
    //  botaoJ.addActionListener(new AdmJ());
       JPanel botoes = new JPanel();
     botoes.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/2));
       
       botoes.add(botao);
       botoes.add(botaoU);
       botoes.add(botaoJ);
       
       JButton botaoC = new JButton("Cadastro");
       //  botao.addActionListener(this);  
       
       botoes.add(botaoC,BorderLayout.PAGE_END);
       /*cadastro.add(botaoC);
       cadastro.setVisible(true);
       cadastro.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));*/
       
       
       botoes.setVisible(true);
       botoes.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));
       
       painel2.add(botoes);
       painel.add(painel2, BorderLayout.CENTER);
       //painel.add(cadastro,BorderLayout.SOUTH);
       painel.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));
       tela.getContentPane().add(painel,BorderLayout.CENTER);
   }
}