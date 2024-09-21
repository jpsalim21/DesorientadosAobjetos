/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Torneios.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class TorneiosPersistencia implements Persistencia<Torneio>{
    private static final String PATH = DIRECTORY+ File.separator +"torneios.json";
    
    @Override
    public void save(List<Torneio> torneios){
        Gson gson = new Gson();
        String json = gson.toJson(torneios);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }
    
    @Override
    public List<Torneio> findAll(){
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<Torneio> torneio = new ArrayList<>();
        
        if(!json.trim().equals(" ")){
            Type tipoLista = new TypeToken<List<Torneio>>(){}.getType();
            torneio = gson.fromJson(json, tipoLista);
            
            if(torneio == null)
                torneio = new ArrayList<>();
        }
       return torneio; 
    }
}
