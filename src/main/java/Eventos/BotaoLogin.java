/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import Janelas.Janela2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoLogin implements ActionListener{
    private final Janela2 tela;
    
    public BotaoLogin(Janela2 tela){
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        tela.login();
    }
}
