/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos.JanelaJuiz;

import Janelas.JanelaJuizNew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
public class ExcluirTorneio implements ActionListener{
    private JanelaJuizNew j;
    public ExcluirTorneio(JanelaJuizNew j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.excluirTorneio();
    }
    
}
