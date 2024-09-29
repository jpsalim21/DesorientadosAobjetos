/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JanelaJuiz;

import Janelas.JanelaJuizNew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluiJuiz implements ActionListener{
    private JanelaJuizNew j;
    public ExcluiJuiz(JanelaJuizNew j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.excluirConta();
    }
    
}
