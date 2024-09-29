/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.JTorneio;

import Janelas.JTorneioJuiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarResultado implements ActionListener {
    private JTorneioJuiz j;
    public ConfirmarResultado(JTorneioJuiz j){
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        j.setResultado();
    }
}
