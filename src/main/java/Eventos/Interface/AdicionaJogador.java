/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos.Interface;

import Janelas.InterfaceCriacaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC12643
 */
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
