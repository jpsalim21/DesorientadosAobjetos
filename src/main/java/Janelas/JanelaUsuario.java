/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;
import Excecao.ExcecaoDeSenha;
import Usuarios.Jogador;
import Usuarios.Senha;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Thales
 */
public class JanelaUsuario {
    
    private JFrame janela;
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    private Jogador jogadorLogado;
    
    public JanelaUsuario(){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        
        //Provisório
        try{
            jogadorLogado = new Jogador("Joaquim", new Senha("A1b@cdef"));
        } catch(ExcecaoDeSenha e){
            System.out.println("Senha inválida");
        }
        jogadorLogado.addDerrotas();
        jogadorLogado.addEmpates();
        jogadorLogado.addVitorias();
        jogadorLogado.addVitorias();
        jogadorLogado.addVitorias();
        
    }
    
    public void desenhaTela(){
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Tela de jogador"));
        painelPrincipal.setLayout(new BorderLayout());
        
        JPanel painelInformacoes = new JPanel();
        JPanel painelInformacoesAux = new JPanel();
        painelInformacoes.setBorder(BorderFactory.createTitledBorder("Suas informações"));
        painelInformacoes.setPreferredSize(new Dimension(WIDTH/8, HEIGHT));
        
        painelInformacoesAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        JLabel nome = new JLabel("Nome: " + jogadorLogado.getNome());
        JLabel vitorias = new JLabel("Vitórias: " + jogadorLogado.getVitorias());
        JLabel empates = new JLabel("Empates: " + jogadorLogado.getEmpates());
        JLabel derrotas = new JLabel("Derrotas: " + jogadorLogado.getDerrotas());
        
        painelInformacoesAux.add(nome);
        painelInformacoesAux.add(vitorias);
        painelInformacoesAux.add(empates);
        painelInformacoesAux.add(derrotas);
        
        painelInformacoes.add(painelInformacoesAux, BorderLayout.NORTH);
        painelPrincipal.add(painelInformacoes, BorderLayout.WEST);
        janela.add(painelPrincipal);
        janela.pack();
    }
    
}
