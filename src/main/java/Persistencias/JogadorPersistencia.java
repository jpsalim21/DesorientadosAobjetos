/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencias;
import Usuarios.Jogador;
import java.io.File;
import java.util.*;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author mateu
 */
public class JogadorPersistencia implements Persistencia<Jogador>{
    
    private static final String PATH = DIRECTORY+ File.separator +"jogadores.json";
    
    @Override
    public void save(List<Jogador> jogadores){
        Gson gson = new Gson();
        String json = gson.toJson(jogadores);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }
    
    @Override
    public List<Jogador> findAll(){
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<Jogador> jogadores = new ArrayList<>();
        if(!json.trim().equals(" ")){
            Type tipoLista = new TypeToken<List<Jogador>>(){}.getType();
            jogadores = gson.fromJson(json, tipoLista);
            
            if(jogadores == null)
                jogadores = new ArrayList<>();
        }
            
        return jogadores; 
    }
}
