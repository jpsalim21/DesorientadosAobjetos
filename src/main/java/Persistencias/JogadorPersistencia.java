/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;
import Usuarios.Jogador;
import java.io.File;
import java.util.*;
/**
 *
 * @author mateu
 */
public class JogadorPersistencia implements Persistencia<Jogador>{
    
    private static final String PATH = DIRECTORY+ File.separator +"jogadores.json";
    
    @Override
    public void save(List<Jogador> jogadores){
        
    }
    
    @Override
    public List<Jogador> findAll(){
        List<Jogador> jogadores = new ArrayList<>();
       return jogadores; 
    }
}
