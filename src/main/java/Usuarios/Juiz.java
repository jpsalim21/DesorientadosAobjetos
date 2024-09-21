/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Usuarios;

import Excecao.*;
import java.util.List;

public class Juiz extends Usuario {

    public Juiz(String nome, String senha)  throws ExcecaoDeSenha{
        super(nome, senha);
        tipo = TipoUsuario.JUIZ;
    }
    
}
