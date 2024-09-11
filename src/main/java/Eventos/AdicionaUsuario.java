/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import java.awt.event.ActionListener;
import Janelas.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author mateu
 */
public class AdicionaUsuario implements ActionListener{
    private final Janela2 tela;
    
    public AdicionaUsuario(Janela2 tela){
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        tela.addUsuario();
    }
}
