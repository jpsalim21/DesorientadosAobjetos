/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.JCriacaoEdicaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionaJogador implements ActionListener{
    private final JCriacaoEdicaoTorneio janela;

    public AdicionaJogador(JCriacaoEdicaoTorneio janela) {
        this.janela = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        janela.AdcionaJogador();
    }
    
}
