/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos.Interface;

import Janelas.InterfaceAnteriorProx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
public class Proximo implements ActionListener{
    private InterfaceAnteriorProx i;
    public Proximo(InterfaceAnteriorProx i){
        this.i = i;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        i.proximo();
    }
    
}
