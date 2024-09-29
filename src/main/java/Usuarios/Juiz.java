/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Usuarios;

import Eventos.GerenciaUsuarios;
import Excecao.*;

public class Juiz extends Usuario {

    public Juiz(String nome, String senha)  throws ExcecaoDeSenha{
        super(nome, senha);
        tipo = TipoUsuario.JUIZ;
    }
    
    @Override
    public void remover(){
        for(int i : torneio){
            GerenciaUsuarios.getSingleton().getTorneioByID(i).removerJuiz();
        }
    }
}
