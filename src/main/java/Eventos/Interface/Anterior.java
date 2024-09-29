/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.Interface;

import Janelas.InterfaceAnteriorProx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
public class Anterior implements ActionListener{
    private InterfaceAnteriorProx i;
    public Anterior(InterfaceAnteriorProx i){
        this.i = i;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        i.anterior();
    }
    
}
