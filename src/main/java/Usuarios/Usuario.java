/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import java.util.*;
import java.util.regex.Pattern;
import Excecao.*;
import java.util.regex.Matcher;
/**
 *
 * @author Thales
 */
public abstract class Usuario {
    private final String nome;
    private String senha;
    protected List<Integer> torneio = new ArrayList<>();
    private static final String senhaRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static Pattern padrao;
    //ALERT: Pode não ser tão importante assim no final. 
    //APAGAR
    public enum TipoUsuario{
        JOGADOR,
        JUIZ,
        ADMIN
    }
    protected TipoUsuario tipo;
    
    public Usuario(String nome, String senha) throws ExcecaoDeSenha{
        padrao = Pattern.compile(senhaRegex);
        setSenha(senha);
        this.nome = nome;
    }
    
    public boolean validaSenha(String senha){
        Matcher pareador = padrao.matcher(senha);
        System.out.println(pareador.matches());
        return pareador.matches();
    }
    
    private void setSenha(String senha)throws ExcecaoDeSenha{
        if(!validaSenha(senha))
            throw new ExcecaoDeSenha();
        
        this.senha = senha;
    }
    
    public void addTorneio(int indiceTorneio){
        this.torneio.add(indiceTorneio);
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    //faz sentido assim?
    public List<Integer> getTorneios() {
        return torneio;
    }
    public TipoUsuario getTipoUsuario(){
        return tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.senha, other.getSenha());
    }
    
}
