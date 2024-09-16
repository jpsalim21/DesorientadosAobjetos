/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Torneios.*;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author ice
 */
public class TorneioPersistencia implements Persistencia<TorneioSuico>{
    private static final String PATH = DIRECTORY+ File.separator +"torneio_suiço.json";
    
    @Override
    public void save(List<TorneioSuico> suico){
        Gson gson = new Gson();
        String json = gson.toJson(suico);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }
    
    @Override
    public List<TorneioSuico> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<TorneioSuico> suico = new ArrayList<>();
        if (!json.trim().equals("")) {
            Type tipoLista = new TypeToken<List<TorneioSuico>>() {
            }.getType();
            suico = gson.fromJson(json, tipoLista);

            if (suico == null) {
                suico = new ArrayList<>();
            }
        }

        return suico;
    }
}
