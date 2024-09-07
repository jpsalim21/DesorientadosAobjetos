/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;


/**
 * @author Thales
 */
public class Janela extends JFrame {
   //Essa aqui vai ser a Janela Inicial 
    
   private JPanel painel;
   private JFrame tela;
   private JTextField tfUsuario;
   private JTextField tfSenha;
   private final int WIDTH = 500;
   private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 10;
    
   /*
    Jlabel -> adiciona texto e imagenms e afins
    JFrame -> adiciona paineis e Janelas
    JButton -> adciona botoes
    
    
    Se vc que ta lendo quiser pode mudar oq se precisar so falar dps
    obs: esse codigo esta me deixando maluco
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
       
       painel = new JPanel();
       
       painel.setBorder(BorderFactory.createCompoundBorder());
       painel.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));   
       
       JPanel painelField= new JPanel(); 
       
       painelField.setBorder(BorderFactory.createEmptyBorder());
       painelField.setLayout(new GridLayout(0, 1, H_GAP/3, V_GAP));
       painelField.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/2));
       
       JLabel texto = new JLabel("Bem-vindo ao gerenciador de Torneios");
       texto.setVerticalTextPosition(JLabel.TOP);
       texto.setHorizontalTextPosition(JLabel.CENTER);
       texto.setFont(new Font("MV Boli",Font.BOLD, 18));
       
       tfUsuario= new JTextField(5);
       tfUsuario.setBounds(6, 10, 30, 15);
       tfSenha = new JPasswordField(10);
       tfUsuario.setBounds(6, 10, 30, 15);


       
       painelField.add(texto, BorderLayout.CENTER);
       painelField.add(tfUsuario);
       painelField.add(tfSenha);
        
       
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
       
       botoes.setVisible(true);
       
       painelField.add(botoes,BorderLayout.SOUTH);
       painel.add(painelField, BorderLayout.CENTER);
       
       tela.getContentPane().add(painel,BorderLayout.CENTER);
   }
}
