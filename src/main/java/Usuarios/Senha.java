/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import Excecao.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author mateu
 */
public class Senha {
    private String senha;
    //confirmar validade desse ReGex
    //formato digito, lowercase, uppercase, caracter especial, sem espaço, minimo de tamanho 8
    private String senhaRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private Pattern padrao = Pattern.compile(senhaRegex);
    
    public Senha(String senha) throws ExcecaoDeSenha{
        setSenha(senha);
    }
    
    public boolean validaSenha(String senha){
        Matcher pareador = padrao.matcher(senha);
        return pareador.matches();
    }
    
    private void setSenha(String senha)throws ExcecaoDeSenha{
        
    }
}
