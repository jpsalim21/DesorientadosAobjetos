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
   private JFrame tela;
   private final int WIDTH = 500;
   private final int HEIGHT = 550;
   /*public Janela(){
       super("Janela");
       Dimension screenSize = 
   }*/
   
   public void Janela(){
       tela = new JFrame("TESTE");
       JPanel painel = new JPanel();
       //tela.addWindowListener(a); Ver oque deve ser adcionado de parametro na hora de abrir janela
       tela.setSize(WIDTH, HEIGHT);
       tela.setVisible(true);
       tela.setLayout(new BorderLayout());
       painel.setBackground(new Color (Color.HSBtoRGB(287 / 360f, 46 / 100f, 65 / 100f)));
       tela.getContentPane().add(painel); 
       //tela.setIconImage(image); Add uma imagem formato "imagem.png"
   }
   
   private void DesenhaMenu(){
       //Implementar menu
   }
}
