/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Eventos.Janela2;

import java.awt.event.ActionListener;
import Janelas.*;
import java.awt.event.ActionEvent;

public class AdicionaUsuario implements ActionListener{
    private final JanelaInicial tela;
    
    public AdicionaUsuario(JanelaInicial tela){
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        tela.addUsuario();
    }
}
