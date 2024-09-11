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
<<<<<<< HEAD
    private final JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
=======
    private JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 200;
>>>>>>> main
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private JList<Torneio>torneios;
    
<<<<<<< HEAD
    public AdmJuizJanela(){
        //Sei que ta igual o bgl do gleiph, mas não tem muito como fugir aqui isso é uma lista
        tela = new JFrame("Tela Adm e Juiz");
=======
    private AdmJuizJanela(){
        //Sei que ta igual o bgl do gleiph, mas não tem muito como fugir aqui isso é uma lista
        tela = new JFrame();
>>>>>>> main
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
<<<<<<< HEAD
        tela.setResizable(false);

        colocaResto();
        desenhaLista();
        colocaBotao();
=======

        desenhaLista();

>>>>>>> main
        tela.pack();
    }
    
    private void desenhaLista(){
        JPanel painel = new JPanel();
        
<<<<<<< HEAD
        painel.setBorder(BorderFactory.createTitledBorder("Torneios"));
        painel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
=======
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Torneios"));
        painel.setBorder(BorderFactory.createTitledBorder("Contatos"));
        painel.setPreferredSize(new Dimension(WIDTH/3, HEIGHT));
>>>>>>> main
        painel.setLayout(new BorderLayout());
        
        torneios = new JList<>();
        //torneios.addListSelectionListener(listener);

        painel.add(new JScrollPane(torneios), BorderLayout.CENTER);
<<<<<<< HEAD
        tela.add(painel,BorderLayout.WEST);
    }
    
    private void colocaResto(){
        
        JPanel forms = new JPanel();
        JPanel resto = new JPanel();
        JPanel resto2 = new JPanel();
        resto.setSize(new Dimension(300,200));
        
        //resto.setBorder(BorderFactory.createTitledBorder("String"));
       
        forms.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        
        forms.add(new JLabel("Alguma coisa:"));
        forms.add(new JTextField(20));
        
        forms.add(new JLabel("Alguma coisa 2:"));
        forms.add(new JTextField(20));
        
        forms.add(new JLabel("Alguma coisa 3:"));
        forms.add(new JTextField(20));
        
        resto2.add(forms);
        resto2.setSize(new Dimension(300,200));
        
        resto.add(resto2, BorderLayout.EAST);
        tela.add(resto);
        
    }
    private void colocaBotao(){
        JPanel colocar = new JPanel();
        JPanel botoes = new JPanel();
        
        JButton botao = new JButton("Editar");
        JButton botao2 = new JButton("Adicionar");
        JButton botao3 = new JButton("Remover");
        
        botoes.add(botao);
        botoes.add(botao2);
        botoes.add(botao3);
        
        colocar.add(botoes);
        tela.add(colocar,BorderLayout.SOUTH);
=======
>>>>>>> main
    }
}
