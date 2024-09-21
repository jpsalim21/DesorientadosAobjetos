/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Excecao;

public class ExcecaoUsuarioJaExistente extends Exception{
    public ExcecaoUsuarioJaExistente(){
        super("Usuário já existe");
    }
}
