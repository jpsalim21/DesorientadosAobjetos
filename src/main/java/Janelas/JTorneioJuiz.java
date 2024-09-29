/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.JTorneio.ConfirmarResultado;
import Torneios.Confronto;
import Torneios.Torneio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author PC12643
 */
public class JTorneioJuiz {
    private final JFrame janela;
    protected final int WIDTH = 1920;
    protected final int HEIGHT = 1080;
    protected final int V_GAP = 10;
    protected final int H_GAP = 5;
    private final Torneio torneio;
    
    private JList<Confronto> confrontosAtuais;
    private int rodadaAtual = 0;
    private JLabel rodadaLabel;
    String[] resultados = {"1 - 0", "1/2 - 1/2", "0 - 1"};
    private JComboBox resultadoConfronto = new JComboBox(resultados);
    
    public JTorneioJuiz(Torneio torneio){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.addWindowListener(GerenciaUsuarios.getSingleton());
        this.torneio = torneio;
        
        desenhaTela();
        carregarRodada();
        janela.pack();
    }
    
    private void desenhaTela(){
        DefaultListModel<Confronto> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        JPanel painelEmparceiramento = new JPanel();
        painelEmparceiramento.setBorder(BorderFactory.createTitledBorder("Emparceiramento"));
        painelEmparceiramento.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        
        JPanel painelBotoesEmparceiramento = new JPanel();
        painelBotoesEmparceiramento.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        JButton botaoVoltar = new JButton("Anterior");
        rodadaLabel = new JLabel("Rodada 1");
        JButton botaoProx = new JButton("Próximo");
        painelBotoesEmparceiramento.add(botaoVoltar);
        painelBotoesEmparceiramento.add(rodadaLabel);
        painelBotoesEmparceiramento.add(botaoProx);
        
        confrontosAtuais = new JList<>(model);
        painelEmparceiramento.add(new JScrollPane(confrontosAtuais));
        painelEmparceiramento.add(painelBotoesEmparceiramento);
        
        JPanel parteDeCima = new JPanel();
        parteDeCima.setLayout(new BorderLayout());
        
        JPanel painelConfigConfronto = new JPanel();
        painelConfigConfronto.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        painelConfigConfronto.add(new JLabel("Resultado do confronto"));
        painelConfigConfronto.add(resultadoConfronto);
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ConfirmarResultado(this));
        painelConfigConfronto.add(btnConfirmar);
        
        painelPrincipal.add(painelEmparceiramento);
        painelPrincipal.add(painelConfigConfronto, BorderLayout.EAST);
        janela.add(painelPrincipal);
        
    }
    
    private void carregarRodada(){
        DefaultListModel<Confronto> model = (DefaultListModel<Confronto>)confrontosAtuais.getModel();
        List<Confronto> confrontos;
        confrontos = torneio.getInfoRodada(rodadaAtual);
        
        if(confrontos == null) return; //PROVISÓRIO
        
        for(Confronto c : confrontos){
            model.addElement(c);
        }
    }
    
    public void setResultado(){
        int selectedIndex = confrontosAtuais.getSelectedIndex();
        
        Confronto confronto;
        if(selectedIndex == -1){
            JOptionPane.showMessageDialog(janela, "Selecione um confronto.");
            return;
        }
        DefaultListModel<Confronto> model = (DefaultListModel<Confronto>)confrontosAtuais.getModel();
        confronto = model.get(selectedIndex);
        
        int indexResultado = resultadoConfronto.getSelectedIndex();
        
        confronto.setResultado(indexResultado);
        janela.pack();
    }
}
