/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Torneios.Confronto;
import Torneios.Torneio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JTorneio {
    private final JFrame janela;
    private String tipoT;
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private Torneio torneio;
    private JList<Confronto> confrontosRodadaAtual;
    private int rodadaAtual = 0;
    
    
    public JTorneio(Torneio torneio){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        this.torneio = torneio;
        
        desenhaPareamento();
        carregarRodada();
        
        janela.pack();
        
    }
    public final void desenhaPareamento(){
        DefaultListModel<Confronto> model = new DefaultListModel<>();
        
        JPanel principal = new JPanel();
        
        principal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        principal.setBorder(BorderFactory.createTitledBorder(tipoT));
        principal.setLayout(new BorderLayout());
        
        JPanel pareamento = new JPanel();
        pareamento.setBorder(BorderFactory.createTitledBorder("Pareamento"));
        pareamento.setLayout(new BorderLayout());
        pareamento.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        
        confrontosRodadaAtual = new JList<>(model);
        JScrollPane painelScroll = new JScrollPane(confrontosRodadaAtual);
        pareamento.add(painelScroll, BorderLayout.CENTER);
        
        JPanel pareamentoBotoes = new JPanel();
        pareamentoBotoes.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        JButton anterior = new JButton("Anterior");
        JButton proxima = new JButton("Proxima");
        pareamentoBotoes.add(anterior);
        pareamentoBotoes.add(proxima);
        
        pareamento.add(pareamentoBotoes, BorderLayout.SOUTH);
        
//        JPanel pareaAux = new JPanel();
//        pareaAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        
//        JLabel x1 = new JLabel("Time a VS time b");
//        JLabel x2 = new JLabel("Time a VS time c");
//        JLabel x3 = new JLabel("Time a VS time d");
//        
//        JLabel res1 = new JLabel("1 x 0");
//        JLabel res2 = new JLabel("1 x 1");
//        JLabel res3 = new JLabel("0 x 1");
//        
//        pareaAux.add(x1);
//        pareaAux.add(res1);
//        pareaAux.add(x2);
//        pareaAux.add(res2);
//        pareaAux.add(x3);
//        pareaAux.add(res3);
        
        JPanel classfi = new JPanel();
        
        classfi.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        classfi.setBorder(BorderFactory.createTitledBorder("Classificação"));
        classfi.setLayout(new BorderLayout());
        JLabel test = new JLabel("test pra classificação");
        classfi.add(test);
        
        principal.add(pareamento,BorderLayout.WEST);
        principal.add(classfi,BorderLayout.CENTER);
        
        janela.add(principal);
    }
    private void carregarRodada(){
        DefaultListModel<Confronto> model = (DefaultListModel<Confronto>)confrontosRodadaAtual.getModel();
        List<Confronto> confrontos;
        confrontos = torneio.getInfoRodada(rodadaAtual);
        
        if(confrontos == null) return; //PROVISÓRIO
        
        for(Confronto c : confrontos){
            model.addElement(c);
        }
    }
    public void mudaRodada(int soma){
        rodadaAtual += soma;
        if(rodadaAtual < 0){
            rodadaAtual = 0;
        }
        carregarRodada();
    }
}
