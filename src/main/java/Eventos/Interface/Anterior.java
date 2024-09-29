/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Interface;

import Janelas.InterfaceAnteriorProx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
