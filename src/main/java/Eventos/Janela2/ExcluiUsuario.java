/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Janela2;

import Janelas.Janela2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
