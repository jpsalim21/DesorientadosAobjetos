/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.JanelaJuiz;

import Janelas.JanelaJuiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluiJuiz implements ActionListener{
    private JanelaJuiz j;
    public ExcluiJuiz(JanelaJuiz j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.excluirConta();
    }
    
}
