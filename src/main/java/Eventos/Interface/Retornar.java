/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.Interface;

import Janelas.JanelaInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
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
