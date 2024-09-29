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
