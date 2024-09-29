/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JanelaJuiz;

import Janelas.JanelaJuizNew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirTorneio implements ActionListener{
    private JanelaJuizNew j;
    public ExcluirTorneio(JanelaJuizNew j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.excluirTorneio();
    }
    
}
