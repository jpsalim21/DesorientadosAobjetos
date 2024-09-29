/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
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
