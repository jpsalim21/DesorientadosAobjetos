/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.Interface.AdicionaJogador;
import Eventos.Interface.Confirmar;
import Eventos.Interface.RemoveJogador;
import Eventos.Interface.Retornar;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import Usuarios.Jogador;
import Usuarios.Juiz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class JCriacaoTorneioSuico implements JanelaInterface, InterfaceCriacaoTorneio{
    private final JFrame janela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    JTextField nomeField, rodadasField;
    
    private JTextField nomeJogadorField;
    private List<Jogador> jogadoresAdicionados;
    private JList<Jogador> JListJogadores;
    
    public JCriacaoTorneioSuico(){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        jogadoresAdicionados = new ArrayList<>();
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela() {
        DefaultListModel<Jogador> model = new DefaultListModel<>();
        
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
        
        JPanel jogadoresPainel = new JPanel();
        jogadoresPainel.setLayout(new BorderLayout());
        jogadoresPainel.setBorder(BorderFactory.createTitledBorder("Jogadores adicionados"));
        JListJogadores = new JList<>(model);
        JScrollPane painelScrollJogadores = new JScrollPane(JListJogadores);
        JPanel jogadoresBtnPainel = new JPanel();
        jogadoresBtnPainel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        nomeJogadorField = new JTextField();
        jogadoresBtnPainel.add(new JLabel("Nome do jogador a adicionar:"));
        jogadoresBtnPainel.add(nomeJogadorField);
        JButton addJogador = new JButton("Adicionar jogador");
        addJogador.addActionListener(new AdicionaJogador(this));
        jogadoresBtnPainel.add(addJogador);
        JButton remJogador = new JButton("Remover jogador");
        remJogador.addActionListener(new RemoveJogador(this));
        jogadoresBtnPainel.add(remJogador);
        
        jogadoresPainel.add(painelScrollJogadores);
        jogadoresPainel.add(jogadoresBtnPainel, BorderLayout.SOUTH);
        
        painelPrincipal.add(jogadoresPainel, BorderLayout.CENTER);
        painelPrincipal.add(formulario, BorderLayout.NORTH);
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
        TorneioSuico novoTorneio = new TorneioSuico(nomeTorneio, (Juiz)GerenciaUsuarios.getSingleton().getUsuario(), rodadas);
        novoTorneio.adicionarListaParticipantes(jogadoresAdicionados);
        
        retornar();
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
    
    @Override
    public void adicionarJogador(){
        DefaultListModel<Jogador> model = (DefaultListModel<Jogador>)JListJogadores.getModel();
        Jogador novoJogador;
        try {
            novoJogador = GerenciaUsuarios.getSingleton().procuraJogador(nomeJogadorField.getText());
        } catch (ExcessaoUsuarioNaoEncontrado e) {
            JOptionPane.showMessageDialog(janela, "Jogador não encontrado");
            nomeJogadorField.setText("");
            return;
        }
        model.addElement(novoJogador);
        nomeJogadorField.setText("");
    }
    @Override
    public void removerJogador(){
        int selectedIndex = JListJogadores.getSelectedIndex();
        
        Jogador j;
        if(selectedIndex == -1){
            JOptionPane.showMessageDialog(janela, "Selecione um jogador da lista");
            return;
        }
        DefaultListModel<Jogador> model = (DefaultListModel<Jogador>)JListJogadores.getModel();
        j = model.elementAt(selectedIndex);
        jogadoresAdicionados.remove(j);
        model.remove(selectedIndex);
    }
}
