/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;


import Eventos.DeslogaTorneio;
import Eventos.GerenciaUsuarios;
import Torneios.Confronto;
import Torneios.Torneio;
import Usuarios.Jogador;
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
     protected final Jogador jogadorLogado;
    

    public JTorneio(Torneio torneio, Usuarios.Jogador jogadorLogado){

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
        this.jogadorLogado = jogadorLogado;
        
    }
    public final void desenhaPareamento(){
        DefaultListModel<Confronto> model = new DefaultListModel<>();
        
        JPanel principal = new JPanel();
        
        //principal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        principal.setBorder(BorderFactory.createTitledBorder(tipoT));
        principal.setLayout(new BorderLayout());
        
        JPanel pareamento = new JPanel();
        pareamento.setBorder(BorderFactory.createTitledBorder("Pareamento"));
        //pareamento.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));

        pareamento.setLayout(new BorderLayout());
        pareamento.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        
        confrontosRodadaAtual = new JList<>(model);
        JScrollPane painelScroll = new JScrollPane(confrontosRodadaAtual);
        painelScroll.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        pareamento.add(painelScroll, BorderLayout.CENTER);
        
        JPanel pareamentoBotoes = new JPanel();
        pareamentoBotoes.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        JButton anterior = new JButton("Anterior");
        JLabel rodadaLabel = new JLabel("Rodada 1");
        JButton proxima = new JButton("Proxima");
        pareamentoBotoes.add(anterior);
        pareamentoBotoes.add(rodadaLabel);
        pareamentoBotoes.add(proxima);
        
        pareamento.add(pareamentoBotoes, BorderLayout.SOUTH);
        
        JPanel classfi = new JPanel();
        JPanel botoes =  new JPanel();
        
        JButton btnSai = new JButton("Deslogar");
        btnSai.addActionListener(new DeslogaTorneio(this));
        
        botoes.add(btnSai);
        //classfi.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));

        classfi.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        classfi.setBorder(BorderFactory.createTitledBorder("Classificação"));
        classfi.setLayout(new BorderLayout());
        JLabel test = new JLabel("test pra classificação");
        classfi.add(test);
        
        principal.add(pareamento,BorderLayout.WEST);
        principal.add(classfi,BorderLayout.CENTER);
        principal.add(botoes, BorderLayout.SOUTH);
        
        janela.add(principal);
    }

    
          public void Desloga(){
        JanelaJogador janelas = new JanelaJogador(jogadorLogado); 
        janela.dispose();
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
