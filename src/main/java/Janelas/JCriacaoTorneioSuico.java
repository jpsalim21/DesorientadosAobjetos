/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.Interface.Confirmar;
import Eventos.Interface.Retornar;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Torneios.TorneioSuico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JCriacaoTorneioSuico implements JanelaInterface{
    private final JFrame janela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    JTextField nomeField, rodadasField;
    
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
        nomeField = new JTextField(20);
        
        JLabel rodadasLabel = new JLabel("Quantas rodadas: ");
        rodadasField = new JTextField(2);
        
        JPanel painelBtn = new JPanel();
        painelBtn.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new Retornar(this));
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new Confirmar(this));
        
        painelBtn.add(btnVoltar);
        painelBtn.add(btnConfirmar);
        
        formulario.add(nomeLabel);
        formulario.add(nomeField);
        formulario.add(rodadasLabel);
        formulario.add(rodadasField);
        
        painelPrincipal.add(formulario);
        painelPrincipal.add(painelBtn, BorderLayout.SOUTH);
        
        janela.add(painelPrincipal);
    }

    @Override
    public void confirmar() {
        String nomeTorneio = nomeField.getText();
        int rodadas = 0;
        try{
            rodadas = Integer.parseInt(rodadasField.getText());
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(janela, "Digite o número de rodadas corretamente");
            return;
        }
        TorneioSuico novoTorneio = new TorneioSuico(nomeTorneio, rodadas);
        
    }

    @Override
    public void retornar() {
        try{
            GerenciaUsuarios.getSingleton().fazLogin();
        } catch (ExcessaoUsuarioNaoEncontrado e){
            JOptionPane.showMessageDialog(janela, "Algo deu errado, reinicie o programa!");
        }
        janela.dispose();
    }
}
