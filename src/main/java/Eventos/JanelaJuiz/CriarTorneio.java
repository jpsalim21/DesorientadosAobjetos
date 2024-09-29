/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JanelaJuiz;

import Janelas.JanelaJuizNew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarTorneio implements ActionListener{
    private final JanelaJuizNew janela;
    public CriarTorneio(JanelaJuizNew janela){
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        janela.criarTorneio();
    }
}
