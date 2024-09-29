/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Interface;

import Janelas.JanelaInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Retornar implements ActionListener{
    private final JanelaInterface janela;
    public Retornar(JanelaInterface janela){
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        janela.retornar();
    }
}
