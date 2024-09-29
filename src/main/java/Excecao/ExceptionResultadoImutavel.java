/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Excecao;

public class ExceptionResultadoImutavel extends Exception{
    public ExceptionResultadoImutavel(){
        super("Resultado não pode ser alterado");
    }
}
