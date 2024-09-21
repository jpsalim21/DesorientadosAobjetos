/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Usuarios;
import Excecao.*;

public class Jogador extends Usuario {
    private int derrotas;
    private int empates;
    private int vitorias;
    
    public Jogador(String nome, String senha) throws ExcecaoDeSenha{
        super(nome, senha);
        tipo = TipoUsuario.JOGADOR;
    }
    
    public int getDerrotas() {
        return derrotas;
    }

    public void addDerrotas(){
        derrotas++;
    }
    
    public int getEmpates() {
        return empates;
    }

    public void addEmpates(){
        empates++;
    }
    
    public int getVitorias() {
        return vitorias;
    }
    
    public void addVitorias(){
        vitorias++;
    }
}
