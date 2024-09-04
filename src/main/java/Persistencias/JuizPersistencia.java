/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Usuarios.Admin;
import Usuarios.Jogador;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Usuarios.Juiz;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 *
 * @author mateu
 */
public class JuizPersistencia implements Persistencia<Juiz>{
    private static final String PATH = DIRECTORY+ File.separator +"Juizes.json";
    
    @Override
    public void save(List<Juiz> juizes){
        Gson gson = new Gson();
        String json = gson.toJson(juizes);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }
    
    @Override
    public List<Juiz> findAll(){
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<Juiz> juizes = new ArrayList<>();
        
        if(!json.trim().equals(" ")){
            Type tipoLista = new TypeToken<List<Juiz>>(){}.getType();
            juizes = gson.fromJson(json, tipoLista);
            
            if(juizes == null)
                juizes = new ArrayList<>();
        }
       return juizes; 
    }
}
