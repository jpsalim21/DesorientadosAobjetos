/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Janelas.AdmJuizJanela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thales
 */
public class DeslogaJuiz implements ActionListener{
    private final AdmJuizJanela tela;
    public DeslogaJuiz(AdmJuizJanela tela){
        this.tela = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       tela.Desloga();
    }
    
}
