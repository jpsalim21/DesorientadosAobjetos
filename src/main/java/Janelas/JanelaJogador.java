/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Janelas;

import Singleton.GerenciaUsuarios;
import Eventos.Interface.Confirmar;
import Eventos.Interface.Retornar;
import Eventos.JanelaJogador.ExcluiJogador;
import Eventos.Listener;
import Torneios.Torneio;
import Usuarios.Jogador;
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

public class JanelaJogador implements InterfaceJanela {

    private final JFrame janela;
    protected final int WIDTH = 1920;
    protected final int HEIGHT = 1080;
    protected final int V_GAP = 10;
    protected final int H_GAP = 5;
    protected final Jogador jogadorLogado;
    protected JList<Torneio> torneiosEntrados;

    public JanelaJogador(Jogador j) {
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.addWindowListener(new Listener());

        jogadorLogado = j;
        desenhaTela();
        carregarTorneios();
    }

    private void carregarTorneios() {
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>) torneiosEntrados.getModel();
        List<Torneio> torneios;
        torneios = GerenciaUsuarios.getSingleton().getTorneios(jogadorLogado.getTorneios());

        for (Torneio t : torneios) {
            model.addElement(t);

        }
    }

    private void desenhaTela() {
        DefaultListModel<Torneio> model = new DefaultListModel<>();

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Tela do jogador"));
        painelPrincipal.setLayout(new BorderLayout());

        JPanel painelInformacoes = new JPanel();
        JPanel painelInformacoesAux = new JPanel();
        painelInformacoes.setBorder(BorderFactory.createTitledBorder("Suas informações"));
        painelInformacoes.setPreferredSize(new Dimension(WIDTH / 8, HEIGHT));

        JLabel nome = new JLabel("Nome: " + jogadorLogado.getNome());
        JLabel vitorias = new JLabel("Vitórias: " + jogadorLogado.getVitorias());
        JLabel empates = new JLabel("Empates: " + jogadorLogado.getEmpates());
        JLabel derrotas = new JLabel("Derrotas: " + jogadorLogado.getDerrotas());

        painelInformacoesAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        painelInformacoesAux.add(nome);
        painelInformacoesAux.add(vitorias);
        painelInformacoesAux.add(empates);
        painelInformacoesAux.add(derrotas);

        JPanel painelTorneios = new JPanel();
        painelTorneios.setBorder(BorderFactory.createTitledBorder("Seus torneios"));
        JPanel torneiosList = new JPanel();
        painelTorneios.setLayout(new BorderLayout());
        JPanel botoesPainelTorneios = new JPanel();
        torneiosEntrados = new JList<>(model);
        JScrollPane painelScrollTorneios = new JScrollPane(torneiosEntrados);
        painelScrollTorneios.setPreferredSize(new Dimension(WIDTH * 4 / 8, HEIGHT * 2 / 5));
        torneiosList.add(painelScrollTorneios, BorderLayout.CENTER);

        JButton btnAcessar = new JButton("Acessar Torneio");
        JButton btnExclui = new JButton("Excluir a conta");
        JButton btnDeslogar = new JButton("Deslogar da Conta");

        btnAcessar.addActionListener(new Confirmar(this));
        btnExclui.addActionListener(new ExcluiJogador(this));
        btnDeslogar.addActionListener(new Retornar(this));

        botoesPainelTorneios.add(btnAcessar);
        botoesPainelTorneios.add(btnExclui);
        botoesPainelTorneios.add(btnDeslogar);

        painelTorneios.add(torneiosList, BorderLayout.NORTH);
        painelTorneios.add(botoesPainelTorneios, BorderLayout.SOUTH);

        painelInformacoes.add(painelInformacoesAux, BorderLayout.NORTH);

        painelPrincipal.add(painelInformacoes, BorderLayout.WEST);
        painelPrincipal.add(painelTorneios, BorderLayout.CENTER);
        janela.add(painelPrincipal);
        janela.pack();
    }

    @Override
    public void confirmar() {
        int selectedIndex = torneiosEntrados.getSelectedIndex();

        Torneio torneio;
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(janela, "Selecione um torneio.");
            return;
        }
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>) torneiosEntrados.getModel();
        torneio = model.get(selectedIndex);
        JTorneioJogador janelaTorneio = new JTorneioJogador(torneio);
    }

    @Override
    public void retornar() {
        JanelaInicial janelas = new JanelaInicial();
        janelas.desenha();
        janela.dispose();
    }

    public void excluiJogador() {
        int response = JOptionPane.showConfirmDialog(janela, "Você deseja continuar?", "Excluir conta", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            GerenciaUsuarios.getSingleton().remove(jogadorLogado.getID());
            janela.dispose();
        }
    }
}
