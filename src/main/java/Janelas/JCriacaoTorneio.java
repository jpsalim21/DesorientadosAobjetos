/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.Interface.Confirmar;
import Eventos.Interface.Retornar;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JCriacaoTorneio implements JanelaInterface{
    private final JFrame janela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    String[] torneios = {"Suíço","Mata-mata"};
    
    public JCriacaoTorneio(){
        System.out.println("Abriu a tela");
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.addWindowListener(GerenciaUsuarios.getSingleton());
        
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela(){
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Qual torneio deseja criar?"));
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(0, 2, H_GAP, V_GAP));
        
        JLabel nomeLabel = new JLabel("Nome do torneio:");
        JTextField nomeField = new JTextField();
        
        JLabel torneioLabel = new JLabel("Tipo do torneio:");
        JComboBox tipoTorneio = new JComboBox(torneios);
        
        painelFormulario.add(nomeLabel);
        painelFormulario.add(nomeField);
        painelFormulario.add(torneioLabel);
        painelFormulario.add(tipoTorneio);
        
        JPanel painelBtn = new JPanel();
        painelBtn.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        
        JButton btnVoltar = new JButton("Voltar");
        JButton btnConfirmar = new JButton("Prosseguir");
        
        btnVoltar.addActionListener(new Retornar(this));
        btnConfirmar.addActionListener(new Confirmar(this));
        
        painelBtn.add(btnVoltar);
        painelBtn.add(btnConfirmar);
        
        painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        painelPrincipal.add(painelBtn, BorderLayout.SOUTH);
        
        janela.add(painelPrincipal);
    }

    @Override
    public void confirmar() {
        
    }

    @Override
    public void retornar() {
        try{
            GerenciaUsuarios.getSingleton().fazLogin();
        } catch(ExcessaoUsuarioNaoEncontrado e){
            JOptionPane j = new JOptionPane("Algo deu errado. Reinicie o programa");
        }
        janela.dispose();
    }
    
}
