/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Torneios.Torneio;
import Torneios.TorneioSuico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC12643
 */
public class TorneioSuicoPersistencia implements Persistencia<TorneioSuico> {
    private static final String PATH = DIRECTORY+ File.separator +"torneiosSuicos.json";
    @Override
    public void save(List<TorneioSuico> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }

    @Override
    public List<TorneioSuico> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<TorneioSuico> torneio = new ArrayList<>();
        
        if(!json.trim().equals(" ")){
            Type tipoLista = new TypeToken<List<TorneioSuico>>(){}.getType();
            torneio = gson.fromJson(json, tipoLista);
            
            if(torneio == null)
                torneio = new ArrayList<>();
        }
       return torneio; 
    }
    
}
