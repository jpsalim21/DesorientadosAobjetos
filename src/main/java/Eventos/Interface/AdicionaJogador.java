/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.Interface;

import Janelas.InterfaceCriacaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
public class AdicionaJogador implements ActionListener{
    private InterfaceCriacaoTorneio i;
    public AdicionaJogador(InterfaceCriacaoTorneio i){
        this.i = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i.adicionarJogador();
    }
    
    
}
