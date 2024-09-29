/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
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
