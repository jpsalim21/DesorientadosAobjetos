/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Janelas.JCriacaoEdicaoTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thales
 */
public class AdicionaJogador implements ActionListener{
    private final JCriacaoEdicaoTorneio janela;

    public AdicionaJogador(JCriacaoEdicaoTorneio janela) {
        this.janela = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        janela.AdcionaJogador();
    }
    
}
