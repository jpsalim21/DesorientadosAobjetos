/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Janelas;

import Eventos.GerenciaUsuarios;
import Eventos.Interface.Anterior;
import Eventos.Interface.Proximo;
import Eventos.JTorneio.CalcularResultado;
import Eventos.JTorneio.ConfirmarResultado;
import Eventos.JTorneio.Emparceirar;
import Eventos.Listener;
import Excecao.ExceptionAcabou;
import Excecao.ExceptionResultadoImutavel;
import Excecao.NaoPodeEmparceirarException;
import Torneios.Confronto;
import Torneios.JogadorParticipante;
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
import javax.swing.JScrollPane;

public class JTorneioJuiz implements InterfaceAnteriorProx{
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
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.setResizable(false);
        janela.addWindowListener(new Listener());
        this.torneio = torneio;
        
        desenhaTela();
        carregarRodada();
        janela.pack();
    }
    
     private void desenhaTela(){
        DefaultListModel<Confronto> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        //painelPrincipal.setLayout(new BorderLayout());
        //painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        JPanel painelEmparceiramento = new JPanel();
        painelEmparceiramento.setBorder(BorderFactory.createTitledBorder("Emparceiramento"));
        painelEmparceiramento.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        
        JPanel painelBotoesEmparceiramento = new JPanel();
        painelBotoesEmparceiramento.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        JButton botaoAnterior = new JButton("Anterior");
        rodadaLabel = new JLabel("Rodada 1");
        JButton botaoProx = new JButton("Próximo");
        painelBotoesEmparceiramento.add(botaoAnterior);
        painelBotoesEmparceiramento.add(rodadaLabel);
        painelBotoesEmparceiramento.add(botaoProx);
        
        botaoAnterior.addActionListener(new Anterior(this));
        botaoProx.addActionListener(new Proximo(this));
        
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
        JButton btnEmparceirar = new JButton("Emparceirar proxima rodada");
        painelConfigConfronto.add(btnEmparceirar);
        btnEmparceirar.addActionListener(new Emparceirar(this));
        JButton btnClassificacao = new JButton("Calcular resultados");
        painelConfigConfronto.add(btnClassificacao);
        btnClassificacao.addActionListener(new CalcularResultado(this));
        
        //painelConfigConfronto.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/4));
        
        painelPrincipal.add(painelEmparceiramento);
        painelPrincipal.add(painelConfigConfronto, BorderLayout.EAST);
        janela.add(painelPrincipal);
        
    }
    
    private void carregarRodada(){
        DefaultListModel<Confronto> model = (DefaultListModel<Confronto>)confrontosAtuais.getModel();
        model.clear();
        List<Confronto> confrontos;
        confrontos = torneio.getRodadaInfo(rodadaAtual);
        
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
        
        try {
            confronto.setResultado(indexResultado);
        } catch (ExceptionResultadoImutavel ex) {
            JOptionPane.showMessageDialog(janela, "Impossível alterar resultado de confrontos anteriores. Mude para a rodada atual");
            return;
        }
        janela.pack();
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
    
    public void emparceirar(){
        try {
            torneio.emparceirar();
        } catch (NaoPodeEmparceirarException ex) {
            JOptionPane.showMessageDialog(janela, "Calcule o resultado da rodada antes do próximo emparceiramento.");
            return;
        } catch (ExceptionAcabou e){
            JOptionPane.showMessageDialog(janela, "Torneio acabou. Não é possível adicionar uma rodada");
            return;
        }
        proximo();
    }
    
    public void calcularResultado(){
        System.out.println("Pegando resultado da rodada " + rodadaAtual);
        
        List<JogadorParticipante> jogadores = torneio.getClassInfo(rodadaAtual + 1);
        
        if(jogadores == null){
            return;
        }
        JanelaClassificacao j = new JanelaClassificacao(jogadores);
    }
}
