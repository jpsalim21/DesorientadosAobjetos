/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JTorneio;

import Janelas.JTorneioJuiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcularResultado implements ActionListener{
    private JTorneioJuiz j;
    public CalcularResultado(JTorneioJuiz j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.calcularResultado();
    }
    
}
