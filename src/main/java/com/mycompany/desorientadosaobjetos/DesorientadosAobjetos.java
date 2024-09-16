/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.desorientadosaobjetos;
import Eventos.GerenciaUsuarios;
import Janelas.*;
import Torneios.Torneio;


/**
 *
 * @author Thales
 */

public class DesorientadosAobjetos {


    //Favor incrementar o contador de horas usadas nesse codigo: 11:30.
    public static void main(String[] args) {
        new GerenciaUsuarios();
//        Janela2 a = new Janela2();
//        a.desenha();

        new JCriacaoEdicaoTorneio(new Torneio("Torneio Teste"));
    }
}
