/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Janelas.JanelaJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thales
 */
public class AcessaTorneio implements ActionListener{
     private final JanelaJogador tela;

    public AcessaTorneio(JanelaJogador tela){
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       tela.AcessaTorneio();
    }
    
}
