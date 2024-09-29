/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.Interface.Anterior;
import Eventos.Interface.Proximo;
import Torneios.Confronto;
import Eventos.Interface.Retornar;
import Eventos.JTorneio.PegarResultado;
import Excecao.ExceptionAcabou;
import Excecao.ExceptionResultadoImutavel;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import Excecao.NaoPodeEmparceirarException;
import Torneios.JogadorParticipante;
import Torneios.Torneio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JTorneio implements InterfaceAnteriorProx{
    private final JFrame janela;
    private String tipoT;
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private Torneio torneio;
    private JList<Confronto> partidasRodada;
    private int rodadaAtual = 0;
    private JLabel rodadaLabel;
    
    
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
        principal.setBorder(BorderFactory.createTitledBorder(tipoT));
        principal.setLayout(new BorderLayout());
        
        JPanel pareamento = new JPanel();
        pareamento.setBorder(BorderFactory.createTitledBorder("Pareamento"));
        
        partidasRodada = new JList<>(model);
        JScrollPane painelScroll = new JScrollPane(partidasRodada);
        painelScroll.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        
        JPanel pareamentoBotoes = new JPanel();
        pareamentoBotoes.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));

        JButton anterior = new JButton("Anterior");
        rodadaLabel = new JLabel("Rodada 1");
        JButton proxima = new JButton("Proxima");
        JButton resultado = new JButton("Resultado da rodada");
        
        pareamentoBotoes.add(anterior);
        pareamentoBotoes.add(rodadaLabel);
        pareamentoBotoes.add(proxima);
        pareamentoBotoes.add(resultado);
        
        anterior.addActionListener(new Anterior(this));
        proxima.addActionListener(new Proximo(this));
        
        resultado.addActionListener(new PegarResultado(this));
        
        pareamento.add(pareamentoBotoes, BorderLayout.SOUTH);
        pareamento.add(painelScroll, BorderLayout.CENTER);
        
        
        JPanel classfi = new JPanel();
        classfi.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        classfi.setBorder(BorderFactory.createTitledBorder("Classificação"));
        classfi.setLayout(new BorderLayout());
        JLabel test = new JLabel("test pra classificação");
        classfi.add(test);
        
        principal.add(pareamento,BorderLayout.WEST);
        principal.add(classfi,BorderLayout.CENTER);
        
        janela.add(principal);
    }
    private void carregarRodada(){
        DefaultListModel<Confronto> model = (DefaultListModel<Confronto>)partidasRodada.getModel();
        model.clear();
        List<Confronto> confrontos;
        confrontos = torneio.getRodadaInfo(rodadaAtual);
        
        if(confrontos == null) return; //PROVISÓRIO
        
        for(Confronto c : confrontos){
            model.addElement(c);
        }
    }

    @Override
    public void anterior() {
        rodadaAtual -= 1;
        if(rodadaAtual < 0){
            rodadaAtual = 0;
            JOptionPane.showMessageDialog(janela, "Não existe rodada anterior a essa");
            return;
        }
        rodadaLabel.setText("Rodada " + String.valueOf(rodadaAtual + 1));
        carregarRodada();
    }

    @Override
    public void proximo() {
        rodadaAtual += 1;
        if(rodadaAtual >= torneio.getMaxRodadas()){
            rodadaAtual = torneio.getMaxRodadas() - 1;
            JOptionPane.showMessageDialog(janela, "Ainda não existe próxima rodada");
            return;
        }
        rodadaLabel.setText("Rodada " + String.valueOf(rodadaAtual + 1));
        carregarRodada();
    }
    
    public void calcularResultado(){
        List<JogadorParticipante> jogadores = torneio.getClassInfo(rodadaAtual + 1);
        
        if(jogadores == null){
            return;
        }
        JanelaClassificacao j = new JanelaClassificacao(jogadores);
    }
}
