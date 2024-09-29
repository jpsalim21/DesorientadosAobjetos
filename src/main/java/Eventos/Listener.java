/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Listener implements WindowListener{
    
    @Override
    public void windowOpened(WindowEvent e) {
        GerenciaUsuarios.getSingleton().carregaUsuarios();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        GerenciaUsuarios.getSingleton().chamaPersistencia();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
       
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
    }

    @Override
    public void windowActivated(WindowEvent e) {
       
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       
    }
    
}
