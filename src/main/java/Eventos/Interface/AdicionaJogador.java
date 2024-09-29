/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Interface;

import Janelas.InterfaceCriacaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
