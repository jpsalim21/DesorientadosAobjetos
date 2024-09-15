/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Janelas.Janela2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anderson
 */
public class ExcluiUsuario implements ActionListener{
     private final Janela2 tela;
     
     public ExcluiUsuario(Janela2 tela){
        this.tela = tela;
    }
     @Override
    public void actionPerformed(ActionEvent e){
        tela.removeUsuario();

    }
}
