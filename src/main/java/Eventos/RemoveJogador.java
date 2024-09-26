/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.JCriacaoEdicaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveJogador implements ActionListener{
    
    private final JCriacaoEdicaoTorneio janela;
    
    public RemoveJogador(JCriacaoEdicaoTorneio janela){
        this.janela = janela;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela.RemoveJogador();
    }
}
