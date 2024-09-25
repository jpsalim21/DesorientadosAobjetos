/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Janelas;

import Torneios.Torneio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JTorneio {
    private final JFrame janela;
    private String tipoT;
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    public JTorneio(Torneio torneio){
        janela = new JFrame();
        janela.setSize(new Dimension(WIDTH, HEIGHT));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLayout(new BorderLayout());
        
        desenhaPareamento();
        
        janela.pack();
        
    }
    public final void desenhaPareamento(){
        JPanel principal = new JPanel();
        
        principal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        principal.setBorder(BorderFactory.createTitledBorder(tipoT));
        principal.setLayout(new BorderLayout());
        
        JPanel pareamento = new JPanel();
        JPanel pareaAux = new JPanel();
        
        pareamento.setBorder(BorderFactory.createTitledBorder("Pareamento"));
        pareamento.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        
        JLabel x1 = new JLabel("Time a VS time b");
        JLabel x2 = new JLabel("Time a VS time c");
        JLabel x3 = new JLabel("Time a VS time d");
        
        JLabel res1 = new JLabel("1 x 0");
        JLabel res2 = new JLabel("1 x 1");
        JLabel res3 = new JLabel("0 x 1");
        
        pareaAux.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        pareaAux.add(x1);
        pareaAux.add(res1);
        pareaAux.add(x2);
        pareaAux.add(res2);
        pareaAux.add(x3);
        pareaAux.add(res3);
        
        JPanel classfi = new JPanel();
        
        classfi.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        classfi.setBorder(BorderFactory.createTitledBorder("Classificação"));
        classfi.setLayout(new BorderLayout());
        JLabel test = new JLabel("test pra classificação");
        classfi.add(test);
        
        pareamento.add(pareaAux);
        principal.add(pareamento,BorderLayout.WEST);
        principal.add(classfi,BorderLayout.CENTER);
        
        janela.add(principal);
    }
}
