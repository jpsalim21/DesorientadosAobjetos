/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.AdmJuizJanela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarTorneio implements ActionListener{
    private final AdmJuizJanela janela;
    public EditarTorneio(AdmJuizJanela janela) {
        this.janela = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        janela.Edita();
    }
    
}
