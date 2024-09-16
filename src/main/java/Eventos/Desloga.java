/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Janelas.JanelaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anderson
 */
public class Desloga implements ActionListener{
     private final JanelaUsuario tela;
    
    public Desloga(JanelaUsuario tela){
        this.tela = tela;
    }
            
    @Override
    public void actionPerformed(ActionEvent e){
        tela.Desloga();
    }
}
