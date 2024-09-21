/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.JanelaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
