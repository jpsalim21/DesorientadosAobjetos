/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;
import Eventos.GerenciaUsuarios;
import Excecao.ExcecaoDeSenha;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import Usuarios.Jogador;
import Usuarios.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Thales
 */
public class JanelaUsuario {
    
    public static void CarregaJanelaAdequada(){
        
    }
    
    /*
    protected void desenhaTela(){
        DefaultListModel<Torneio> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Tela do jogador"));
        painelPrincipal.setLayout(new BorderLayout());
        
        JPanel painelInformacoes = new JPanel();
        JPanel painelInformacoesAux = new JPanel();
        painelInformacoes.setBorder(BorderFactory.createTitledBorder("Suas informações"));
        painelInformacoes.setPreferredSize(new Dimension(WIDTH/8, HEIGHT));
        
        JLabel nome = new JLabel("Nome: " + usuarioLogado.getNome());
//        JLabel vitorias = new JLabel("Vitórias: " + jogadorLogado.getVitorias());
//        JLabel empates = new JLabel("Empates: " + jogadorLogado.getEmpates());
//        JLabel derrotas = new JLabel("Derrotas: " + jogadorLogado.getDerrotas());
        
        painelInformacoesAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        painelInformacoesAux.add(nome);
//        painelInformacoesAux.add(vitorias);
//        painelInformacoesAux.add(empates);
//        painelInformacoesAux.add(derrotas);
        
        
        JPanel painelTorneios = new JPanel();
        painelTorneios.setBorder(BorderFactory.createTitledBorder("Seus torneios"));
        JPanel torneiosList = new JPanel();
        painelTorneios.setLayout(new BorderLayout());
        JPanel botoesPainelTorneios = new JPanel();
        torneiosEntrados = new JList<>(model);
        JScrollPane painelScrollTorneios = new JScrollPane(torneiosEntrados);
        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 5/8, HEIGHT*3/5));
        torneiosList.add(painelScrollTorneios, BorderLayout.CENTER);
        
        JButton btnAcessar = new JButton("Acessar Torneio");
        JButton btnDeslogar = new JButton("Deslogar da Conta");
        botoesPainelTorneios.add(btnAcessar);
        botoesPainelTorneios.add(btnDeslogar);
        
        painelTorneios.add(torneiosList, BorderLayout.NORTH);
        painelTorneios.add(botoesPainelTorneios, BorderLayout.SOUTH);
        //painelPrincipal.add(new JScrollPane(torneiosEntrados), BorderLayout.CENTER);
        
        
        painelInformacoes.add(painelInformacoesAux, BorderLayout.NORTH);
        
        painelPrincipal.add(painelInformacoes, BorderLayout.WEST);
        painelPrincipal.add(painelTorneios, BorderLayout.CENTER);
        janela.add(painelPrincipal);
        janela.pack();
    }
*/
    
}
