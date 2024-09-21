/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Usuarios;

import Excecao.*;

public class Admin extends Juiz {

    public Admin(String nome, String senha)  throws ExcecaoDeSenha{
        super(nome, senha);
        tipo = TipoUsuario.ADMIN;
    }
    void criarTorneio(){
        
    }
}
