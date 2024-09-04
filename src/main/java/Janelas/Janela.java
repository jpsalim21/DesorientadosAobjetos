/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * @author Thales
 */
public class Janela extends JFrame {
   private JDesktopPane desktop;
   private JPanel painel;
   private JFrame tela;
   private final int WIDTH = 500;
   private final int HEIGHT = 200;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
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
       
       DesenhaMenu();      

       tela.pack();
   }
   
   private void DesenhaMenu(){
       
       painel = new JPanel();
       JPanel painel2= new JPanel(); 
       painel.setBorder(BorderFactory.createCompoundBorder());
       painel2.setBorder(BorderFactory.createCompoundBorder());
       
       JPanel Texto = new JPanel();
       
       Texto.setLayout(new  GridLayout(0, 1, H_GAP, V_GAP));
       Texto.add(new JLabel("Bem-vindo"));
       
       painel2.add(Texto,BorderLayout.CENTER);
       painel.add(painel2);
       painel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
       
       
       //FIXME procurar uma forma melhor de usar 
       /*painel2.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));
       painel.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));*/
       
       painel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));     
       
       JButton botao = new JButton("Adm");
    //  botao.addActionListener(this);
       JButton botaoU = new JButton("Usuário");
    //  botao.addActionListener(this);
        JButton botaoJ = new JButton("Juiz");
    //  botao.addActionListener(this);   
       JPanel botoes = new JPanel();
       
       botoes.add(botao);
       botoes.add(botaoU);
       botoes.add(botaoJ);
       
       //Talvez desnecessário
       /*botao.setVerticalTextPosition(AbstractButton.CENTER);
       botao.setHorizontalTextPosition(AbstractButton.RIGHT);
       botao.setEnabled(true);*/
       //boolean visibi = botao.isVisible();
       //botao.
       
       botoes.setVisible(true);
       painel.add(botoes, BorderLayout.SOUTH);
       tela.getContentPane().add(painel,BorderLayout.CENTER);
   }
}
