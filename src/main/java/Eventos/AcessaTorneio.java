/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.JanelaJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessaTorneio implements ActionListener{
     private final JanelaJogador tela;

    public AcessaTorneio(JanelaJogador tela){
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       tela.AcessaTorneio();
    }
    
}
