/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;
import Eventos.AdicionaJogador;
import Eventos.DeslogaJuiz;
import Eventos.EditarTorneio;
import Eventos.RemoveJogador;
import Torneios.Torneio;
import Usuarios.Jogador;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import Persistencias.*;
import Torneios.JogadorParticipante;
/**
 *
 * @author Thales
 */

public class AdmJuizJanela{
    
    //dei uma alterada e coloquei as funções em quase tudo
    private final JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    private JTextField Nome;
    private JTextField Torneio;
    
    private List<Torneio> torneios;
    private final List<Jogador> jogadores;
    
    public AdmJuizJanela(){
        Persistencia tor = new TorneiosPersistencia();
        torneios = tor.findAll();
        Persistencia jog = new JogadorPersistencia();
        jogadores = jog.findAll();
        tela = new JFrame("Tela Adm e Juiz");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        //tela.setResizable(false);

        colocaResto();
        desenhaLista();
        tela.pack();
    }
    
    private void desenhaLista(){
        JPanel painel = new JPanel();
        
        painel.setBorder(BorderFactory.createTitledBorder("Torneios"));
        painel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        painel.setLayout(new BorderLayout());
        
        torneios = new ArrayList<>();
        painel.setPreferredSize(new Dimension(550,HEIGHT));
        painel.add(new JScrollPane((Component) torneios), BorderLayout.CENTER);
        tela.getContentPane().add(painel,BorderLayout.WEST);
    }
    
    private void colocaResto(){
        
        JPanel forms = new JPanel();
        JPanel resto = new JPanel();
        JPanel resto2 = new JPanel();
        JPanel botoes = new JPanel();
        
        forms.setPreferredSize(new Dimension(WIDTH,HEIGHT*2));
        forms.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
       
        JButton btnComeça = new JButton("Começar Torneio"); //vai ficar de enfeite
        JButton btnEdita = new JButton("Editar Torneio"); //chama a janela e da
        JButton btnSai = new JButton("Sair");
        JButton botao2 = new JButton("Adicionar Jogador");
        JButton botao3 = new JButton("Remover Jogador");
//        JButton botao2 = new JButton("Adicionar Juiz");
//        JButton botao3 = new JButton("Remover Juiz");
//          minha ideia aqui é passar o tipo  (juiz ou adm e dai deixa esses botões visiveis pro adm)       
    btnEdita.addActionListener(new EditarTorneio(this));
    botao2.addActionListener(new AdicionaJogador(this));
    botao3.addActionListener(new RemoveJogador(this));
    btnSai.addActionListener(new DeslogaJuiz(this));
        
        botoes.add(btnComeça);
        botoes.add(btnEdita);
        botoes.add(botao2);
        botoes.add(botao3);
        botoes.add(btnSai);
       
        forms.add(new JLabel("Nome do torneio:"));
        Torneio =new JTextField(20);
        forms.add(Torneio);
        
        forms.add(new JLabel("Participante:"));
        Nome = new JTextField(20); 
        forms.add(Nome);
        
        forms.add(botoes);
        
        resto2.add(forms);
        
        resto.add(resto2, BorderLayout.EAST);
        tela.getContentPane().add(resto);
        
    }

//Isso aqui cai em desuso com os botões da JCriacao    
//    public void AddPlayer(){
//        String nomeJogador = Nome.getText();
//        String nomeTorneio = Torneio.getText();
//         if (nomeJogador.isEmpty() || nomeTorneio.isEmpty()) {
//        JOptionPane.showMessageDialog(tela, "Nome do jogador ou do torneio não pode estar vazio.");
//        return;
//    }
//         
//         Jogador jogador = null;
//    for (Jogador j : jogadores) {
//        if (j.getNome().equals(nomeJogador)) {
//            jogador = j;
//            break;
//        }
//    }
//
//    if (jogador == null) {
//        JOptionPane.showMessageDialog(tela, "Jogador não encontrado.");
//        return;
//    }
//
//    Torneio torneio = null;
//    for (Torneio t : torneios) {
//        if (t.getNome().equals(nomeTorneio)) {
//            torneio = t;
//            break;
//        }
//    }
//
//    if (torneio == null) {
//        JOptionPane.showMessageDialog(tela, "Torneio não encontrado.");
//        return;
//    }
//
//    torneio.adicionarParticipante(jogador);
//    JOptionPane.showMessageDialog(tela, "Jogador adicionado ao torneio com sucesso.");
//    }
//    
//    public void RemoveJogador(){
//         String nomeJogador = Nome.getText();
//        String nomeTorneio = Torneio.getText();
//        
//        Torneio torneio = null;
//    for (Torneio t : torneios) {
//        if (t.getNome().equals(nomeTorneio)) {
//            torneio = t;
//            break;
//        }
//    }
//
//    if (torneio == null) {
//        JOptionPane.showMessageDialog(tela, "Torneio não encontrado.");
//        return;
//    }
//    
//        List<JogadorParticipante> aux = torneio.getParticipantes();
//      
//        for(JogadorParticipante a : aux){
//            if(a.getUsuario().getNome().equals(nomeJogador)){
//                torneio.removerParticipante(a);
//            }
//        }
//    }
    
    public void Edita(){
        String nomeTorneio = Torneio.getText();
              Torneio torneio = null;
    for (Torneio t : torneios) {
        if (t.getNome().equals(nomeTorneio)) {
            torneio = t;
            break;
        }
    }
        JCriacaoEdicaoTorneio aux = new JCriacaoEdicaoTorneio(torneio);
    }
    
     public void Desloga(){
        JanelaUsuario janelas = new JanelaUsuario(); 
        tela.dispose();
    }
}
