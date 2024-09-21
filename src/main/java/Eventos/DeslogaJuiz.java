/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.AdmJuizJanela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeslogaJuiz implements ActionListener{
    private final AdmJuizJanela tela;
    public DeslogaJuiz(AdmJuizJanela tela){
        this.tela = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       tela.Desloga();
    }
    
}
