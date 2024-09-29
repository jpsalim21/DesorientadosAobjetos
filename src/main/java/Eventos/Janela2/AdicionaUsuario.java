/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.Janela2;

import java.awt.event.ActionListener;
import Janelas.*;
import java.awt.event.ActionEvent;

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
