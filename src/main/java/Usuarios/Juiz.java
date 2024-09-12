/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.util.List;

/**
 *
 * @author ice
 */
public class Juiz extends Usuario {

    public Juiz(String nome, Senha senha) {
        super(nome, senha);
        tipo = TipoUsuario.JUIZ;
    }
    
}
