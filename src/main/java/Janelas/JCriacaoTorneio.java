/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Janelas;

import Singleton.GerenciaUsuarios;
import Eventos.Interface.Confirmar;
import Eventos.Interface.Retornar;
import Eventos.Listener;
import Excecao.ExcessaoUsuarioNaoEncontrado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JCriacaoTorneio implements InterfaceJanela{
    private final JFrame janela;
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    String[] torneios = {"Suíço","Mata-mata"};
    JComboBox tipoTorneio = new JComboBox(torneios);
    
    public JCriacaoTorneio(){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        janela.addWindowListener(new Listener());
        
        desenhaTela();
        janela.pack();
    }
    
    private void desenhaTela(){
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Qual torneio deseja criar?"));
        
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(0, 2, H_GAP, V_GAP));
        
        JLabel torneioLabel = new JLabel("Tipo do torneio:");

        painelFormulario.add(torneioLabel);
        painelFormulario.add(tipoTorneio);
        
        JPanel painelBtn = new JPanel();
        painelBtn.setLayout(new GridLayout(1, 0, H_GAP, V_GAP));
        
        JButton btnVoltar = new JButton("Voltar");
        JButton btnConfirmar = new JButton("Prosseguir");
        
        btnVoltar.addActionListener(new Retornar(this));
        btnConfirmar.addActionListener(new Confirmar(this));
        
        painelBtn.add(btnVoltar);
        painelBtn.add(btnConfirmar);
        
        painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        painelPrincipal.add(painelBtn, BorderLayout.SOUTH);
        
        janela.add(painelPrincipal);
    }

    @Override
    public void confirmar() {
        JCriacaoTorneioSuico novaJanela = new JCriacaoTorneioSuico();
        janela.dispose();
    }

    @Override
    public void retornar() {
        try{
            GerenciaUsuarios.getSingleton().fazLogin();
        } catch(ExcessaoUsuarioNaoEncontrado e){
            JOptionPane.showMessageDialog(janela, "Algo deu errado, reinicie o programa!");
            return;
        }
        janela.dispose();
    }
    
}
