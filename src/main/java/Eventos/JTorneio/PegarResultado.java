/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JTorneio;

import Janelas.JTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PegarResultado implements ActionListener{
    private JTorneio j;
    public PegarResultado(JTorneio j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.calcularResultado();
    }
    
}
