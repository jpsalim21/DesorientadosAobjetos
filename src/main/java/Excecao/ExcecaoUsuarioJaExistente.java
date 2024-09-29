/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Excecao;

public class ExcecaoUsuarioJaExistente extends Exception{
    public ExcecaoUsuarioJaExistente(){
        super("Usuário já existe");
    }
}
