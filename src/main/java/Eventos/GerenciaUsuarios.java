/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Usuarios.*;
import Janelas.Janela2;
import Persistencias.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

/**
 *
 * @author mateu
 */
public class GerenciaUsuarios implements WindowListener{
    private final Janela2 tela;

    public GerenciaUsuarios(Janela2 tela) {
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
        Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
        Persistencia<Admin> admPersistencia = new AdminPersistencia();
        List<Jogador> l1 = jogPersistencia.findAll();
        List<Juiz> l2 = juiPersistencia.findAll();
        List<Admin> l3 = admPersistencia.findAll();
        tela.carregaUsuarios(l1, l2, l3);
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        Persistencia<Jogador> jogPersistencia = new JogadorPersistencia();
        Persistencia<Juiz> juiPersistencia = new JuizPersistencia();
        Persistencia<Admin> admPersistencia = new AdminPersistencia();
        jogPersistencia.save(tela.listaJogadores());
        //juiPersistencia.save();
        //admPersistencia.save();
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
