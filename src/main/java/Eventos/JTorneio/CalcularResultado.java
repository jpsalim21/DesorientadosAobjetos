/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos.JTorneio;

import Janelas.JTorneioJuiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
public class CalcularResultado implements ActionListener{
    private JTorneioJuiz j;
    public CalcularResultado(JTorneioJuiz j){
        this.j = j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        j.calcularResultado();
    }
    
}
