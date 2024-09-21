/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;

import Torneios.JogadorParticipante;
import Torneios.Torneio;
import Usuarios.Jogador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.*;
import Persistencias.*;

public class JCriacaoEdicaoTorneio {
    private final JFrame janela;
    protected final int WIDTH = 1920;
    protected final int HEIGHT = 1080;
    protected final int V_GAP = 10;
    protected final int H_GAP = 5;
    
    private JTextField nTorneio;
    private final Torneio torneio;
    private JList<JogadorParticipante> jogadores;
    private List<Jogador> jogar;
    
    public JCriacaoEdicaoTorneio(Torneio t){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        this.torneio = t;
        
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela(){
        Persistencia jog = new JogadorPersistencia();
        jogar = jog.findAll();
        DefaultListModel<JogadorParticipante> model = new DefaultListModel<>();
        
        JPanel painel = new JPanel();
        
        JPanel torneioPanel = new JPanel();
            JPanel inputPanel = new JPanel();
            
        JPanel jogadoresPanel = new JPanel();
            JPanel botoesJogadores = new JPanel();
        
        torneioPanel.setLayout(new BorderLayout());
        torneioPanel.setBorder(BorderFactory.createTitledBorder("Informações do torneio"));
        
        inputPanel.setLayout(new GridLayout(0, 2, H_GAP, V_GAP));
        JLabel nome = new JLabel("Nome do torneio");
        inputPanel.add(nome);
        nTorneio =new JTextField();
        inputPanel.add(nTorneio);
        torneioPanel.add(inputPanel);
        
//        jogadores = new JList<>(model);
//        JScrollPane painelScrollTorneios = new JScrollPane(jogadores);
//        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 4/8, HEIGHT*2/5));
//        jogadores.add(painelScrollTorneios, BorderLayout.CENTER);
        
        botoesJogadores.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        botoesJogadores.add(new JButton("Adicionar Jogador"));
        botoesJogadores.add(new JButton("Deletar jogador"));
        jogadoresPanel.add(botoesJogadores, BorderLayout.SOUTH);
        
        painel.add(torneioPanel, BorderLayout.WEST);
        painel.add(jogadoresPanel, BorderLayout.CENTER);
        
        janela.add(painel);
        
        
        
    }
    
    //metodos de remoção e adição de jogador nos torneios
    //Caso queira pode mudar o metodo de remoção e adição
    
    public void AdcionaJogador(){
        List<JogadorParticipante> participante= torneio.getParticipantes();
        if(!(torneio.getNome().equals(nTorneio))){
             JOptionPane.showMessageDialog(janela, "Torneio não encontrado");
             return;
        }
        String naux = JOptionPane.showInputDialog("Digite o nome do jogador a ser adcionado:");
        for(JogadorParticipante u : participante){
            if(u.getUsuario().getNome().equals(naux)){
                JOptionPane.showMessageDialog(janela, "Jogador já adcionado");
                return;
            }
         
        for(Jogador t : jogar){
            if(t.getNome().equals(naux)){
                torneio.adicionarParticipante(t);
            }
        }
        }
    }
    
    public void RemoveJogador(){
          List<JogadorParticipante> aux = torneio.getParticipantes();
          if(!(torneio.getNome().equals(nTorneio))){
             JOptionPane.showMessageDialog(janela, "Torneio não encontrado");
             return;
          }
          
        for(JogadorParticipante a : aux){
            String naux = JOptionPane.showInputDialog("Digite o nome do jogador a ser removido:");
            if(a.getUsuario().getNome().equals(naux)){
                torneio.removerParticipante(a);
            }
        }
    }
}
