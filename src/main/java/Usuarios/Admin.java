/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import Excecao.*;

/**
 *
 * @author ice
 */
public class Admin extends Juiz {

    public Admin(String nome, String senha)  throws ExcecaoDeSenha{
        super(nome, senha);
        tipo = TipoUsuario.ADMIN;
    }
    void criarTorneio(){
        
    }
}
