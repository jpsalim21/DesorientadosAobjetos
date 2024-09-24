/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;
import Eventos.AcessaJogador;
import Eventos.Desloga;
import Eventos.GerenciaUsuarios;
import Excecao.ExcecaoDeSenha;
import Eventos.DeslogaUsuário;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import Usuarios.Jogador;
import Usuarios.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;

public class JanelaUsuario {
    
    private JFrame janela;
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    private Jogador jogadorLogado;
    private JList<Torneio> torneiosEntrados;
    
    public JanelaUsuario(){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        //Provisório
        try{
            jogadorLogado = new Jogador("Joaquim", "A1b@cdef");
        } catch(ExcecaoDeSenha e){
            System.out.println("Senha inválida");
        }
        jogadorLogado.addDerrotas();
        jogadorLogado.addEmpates();
        jogadorLogado.addVitorias();
        jogadorLogado.addVitorias();
        jogadorLogado.addVitorias();
        Torneio novoTorneio = new TorneioSuico("Torneio de Xadrez", 5);
        Torneio torneio2 = new TorneioSuico("Torneio de MK11", 10);
        torneio2.adicionarParticipante(jogadorLogado);
        novoTorneio.adicionarParticipante(jogadorLogado);
        
        desenhaTela();
        carregarTorneios();
    }
    
    private void carregarTorneios(){
        DefaultListModel<Torneio> model = (DefaultListModel<Torneio>)torneiosEntrados.getModel();
        List<Torneio> torneios;
        torneios = GerenciaUsuarios.getSingleton().getTorneios(jogadorLogado.getTorneios());
        
        for(Torneio t : torneios){
            model.addElement(t);
            
        }
    }
    
     public void dispose() {
        if (janela != null) {
            janela.dispose();
        }
    }
    
    private void desenhaTela(){
        DefaultListModel<Torneio> model = new DefaultListModel<>();
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Tela do jogador"));
        painelPrincipal.setLayout(new BorderLayout());
        
        JPanel painelInformacoes = new JPanel();
        JPanel painelInformacoesAux = new JPanel();
        painelInformacoes.setBorder(BorderFactory.createTitledBorder("Suas informações"));
        painelInformacoes.setPreferredSize(new Dimension(WIDTH/8, HEIGHT));
        
//        JLabel nome = new JLabel("Nome: " + usuarioLogado.getNome());
//        JLabel vitorias = new JLabel("Vitórias: " + jogadorLogado.getVitorias());
//        JLabel empates = new JLabel("Empates: " + jogadorLogado.getEmpates());
//        JLabel derrotas = new JLabel("Derrotas: " + jogadorLogado.getDerrotas());
        
        painelInformacoesAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
//        painelInformacoesAux.add(nome);
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
        
        btnAcessar.addActionListener(new AcessaJogador(this)); 
        btnDeslogar.addActionListener(new Desloga(this));
        
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
    
//    public void AcessaJogador(){
//        //faz a nova janela
//        String tipoT = JOptionPane.showInputDialog("Informe qual torneio deseja acessar:");
//        //chama a nova janela com essa string de torneio
//        JTorneio torneio = new JTorneio(tipoT);
//        janela.dispose();
//    }
       public void Desloga(){
        Janela2 janelas = new Janela2(); 
        janelas.desenha();
        janela.dispose();
    } 
}
