/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
 package Janelas;

import Singleton.GerenciaUsuarios;
import Eventos.Interface.Confirmar;
import Eventos.Interface.Retornar;
import Eventos.JanelaJuiz.CriarTorneio;
import Eventos.JanelaJuiz.ExcluiJuiz;
import Eventos.JanelaJuiz.ExcluirTorneio;
import Eventos.Listener;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import Usuarios.Juiz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JanelaJuiz implements InterfaceJanela{
    private final JFrame janela;
    protected final int WIDTH = 1920;
    protected final int HEIGHT = 1080;
    protected final int V_GAP = 10;
    protected final int H_GAP = 5;
    protected final Juiz juiz;
    protected JList<Torneio> torneiosEntrados;
    
    public JanelaJuiz(Juiz juiz){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.addWindowListener(new Listener());
        
        this.juiz = juiz;
        
        desenhaTela();
        carregaTorneios();
        janela.pack();
    }
    
    private void desenhaTela(){
        DefaultListModel<Torneio> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Tela do juiz"));
        painelPrincipal.setLayout(new BorderLayout());
        
        JPanel painelInformacoes = new JPanel();
        JPanel painelInformacoesAux = new JPanel();
        painelInformacoes.setBorder(BorderFactory.createTitledBorder("Suas informações"));
        painelInformacoes.setPreferredSize(new Dimension(WIDTH/8, HEIGHT));
        
        painelInformacoesAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        
        JPanel painelTorneios = new JPanel();
        painelTorneios.setBorder(BorderFactory.createTitledBorder("Seus torneios"));
        JPanel torneiosList = new JPanel();
        painelTorneios.setLayout(new BorderLayout());
        JPanel botoesPainelTorneios = new JPanel();
        torneiosEntrados = new JList<>(model);
        JScrollPane painelScrollTorneios = new JScrollPane(torneiosEntrados);
        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 4/8, HEIGHT*2/5));
        torneiosList.add(painelScrollTorneios, BorderLayout.CENTER);
        
        JButton btnAcessar = new JButton("Acessar Torneio");
        btnAcessar.addActionListener(new Confirmar(this));
        
        JButton btnCriar = new JButton("Criar Torneio");
        btnCriar.addActionListener(new CriarTorneio(this));
        
        JButton btnExcluirConta = new JButton("Excluir conta");
        btnExcluirConta.addActionListener(new ExcluiJuiz(this));
        
        JButton btnExcluirTorneio = new JButton("Excluir torneio");
        btnExcluirTorneio.addActionListener(new ExcluirTorneio(this));
        
        JButton btnDeslogar = new JButton("Deslogar da Conta");
        btnDeslogar.addActionListener(new Retornar(this));
        
        botoesPainelTorneios.add(btnAcessar);
        botoesPainelTorneios.add(btnCriar);
        botoesPainelTorneios.add(btnExcluirTorneio);
        botoesPainelTorneios.add(btnDeslogar);
        botoesPainelTorneios.add(btnExcluirConta);
        
        painelTorneios.add(torneiosList, BorderLayout.NORTH);
        painelTorneios.add(botoesPainelTorneios, BorderLayout.SOUTH);
        
        painelInformacoes.add(painelInformacoesAux, BorderLayout.NORTH);
        
        painelPrincipal.add(painelInformacoes, BorderLayout.WEST);
        painelPrincipal.add(painelTorneios, BorderLayout.CENTER);
        janela.add(painelPrincipal);
    }
    
    private void carregaTorneios(){
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>)torneiosEntrados.getModel();
        model.clear();
        List<Torneio> torneiosAdicionar = GerenciaUsuarios.getSingleton().getTorneios(
                GerenciaUsuarios.getSingleton().getUsuario().getTorneios());
        
        for(Torneio t : torneiosAdicionar){
            model.addElement(t);
        }
    }

    @Override
    public void confirmar() {
        int selectedIndex = torneiosEntrados.getSelectedIndex();
        
        Torneio torneio;
        if(selectedIndex == -1){
            JOptionPane.showMessageDialog(janela, "Selecione um torneio.");
            return;
        }
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>)torneiosEntrados.getModel();
        torneio = model.get(selectedIndex);
        JTorneioJuiz j = new JTorneioJuiz(torneio);
    }

    @Override
    public void retornar() {
        JanelaInicial janelas = new JanelaInicial();
        janelas.desenha();
        janela.dispose();
    }
    public void criarTorneio(){
        JCriacaoTorneio janelaNova = new JCriacaoTorneio();
        janela.dispose();
    }
    public void excluirConta() {
        int response = JOptionPane.showConfirmDialog(janela, "Você deseja continuar?", "Excluir conta", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            GerenciaUsuarios.getSingleton().remove(juiz.getID());
            janela.dispose();
        }
    }
    
    public void excluirTorneio(){
        int selectedIndex = torneiosEntrados.getSelectedIndex();
        
        Torneio torneio;
        if(selectedIndex == -1){
            JOptionPane.showMessageDialog(janela, "Selecione um torneio.");
            return;
        }
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>)torneiosEntrados.getModel();
        torneio = model.get(selectedIndex);
        
        GerenciaUsuarios.getSingleton().removerTorneio((TorneioSuico)torneio);
        carregaTorneios();
        janela.pack();
    }
}
