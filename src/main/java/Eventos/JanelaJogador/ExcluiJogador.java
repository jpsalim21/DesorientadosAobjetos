/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.JanelaJogador;

import Janelas.JanelaJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluiJogador  implements ActionListener{
    private final JanelaJogador janela;

    public ExcluiJogador(JanelaJogador janela) {
        this.janela = janela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        janela.excluiJogador();
    }
    
}
