/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.InterfaceJanela;

public class Confirmar implements ActionListener{
    private final InterfaceJanela janela;
    public Confirmar(InterfaceJanela janela){
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        janela.confirmar();
    }
}
