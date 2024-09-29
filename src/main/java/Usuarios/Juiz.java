/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
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
            GerenciaUsuarios.getSingleton().getTorneioByID(i).removerParticipante(ID);
        }
    }
}
