/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
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
