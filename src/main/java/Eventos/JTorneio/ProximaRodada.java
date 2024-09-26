/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos.JTorneio;
import Janelas.JTorneio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProximaRodada implements ActionListener{
    private final JTorneio janela;

    public ProximaRodada(JTorneio janela) {
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela.mudaRodada(1);
    }
    
    
}
