/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Janela2;

import Janelas.JanelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluiUsuario implements ActionListener{
     private final JanelaInicial tela;
     
     public ExcluiUsuario(JanelaInicial tela){
        this.tela = tela;
    }
     @Override
    public void actionPerformed(ActionEvent e){
        tela.removeUsuario();

    }
}
