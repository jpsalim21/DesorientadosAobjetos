/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import Excecao.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author mateu
 */

//TODO: possivelmente deletar essa classe/arquivo

public class Senha {
    private String senha;
    //confirmar validade desse ReGex
    //A1b@cdef
    //A1@bcdef
    //formato digito, lowercase, uppercase, caracter especial, sem espaço, minimo de tamanho 8
    private static final String senhaRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static Pattern padrao;
    
    public Senha(String senha) throws ExcecaoDeSenha{
        padrao = Pattern.compile(senhaRegex);
        setSenha(senha);
    }
    
    public boolean validaSenha(String senha){
        Matcher pareador = padrao.matcher(senha);
        return pareador.matches();
    }
    
    private void setSenha(String senha)throws ExcecaoDeSenha{
        if(!validaSenha(senha))
            throw new ExcecaoDeSenha();
        
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.senha == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Senha other = (Senha) obj;
        return Objects.equals(this.senha, other.getSenha());
    }
    
}
