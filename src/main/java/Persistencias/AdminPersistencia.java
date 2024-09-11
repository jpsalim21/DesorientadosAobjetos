/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Usuarios.Admin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateu
 */
public class AdminPersistencia implements Persistencia<Admin>{
    private static final String PATH = DIRECTORY+ File.separator +"admins.json";
    
    @Override
    public void save(List<Admin> admins){
        Gson gson = new Gson();
        String json = gson.toJson(admins);
        
        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        Arquivo.save(PATH, json);
    }
    
    @Override
    public List<Admin> findAll(){
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);
        List<Admin> admins = new ArrayList<>();
        
        if(!json.trim().equals("")){
            Type tipoLista = new TypeToken<List<Admin>>(){}.getType();
            admins = gson.fromJson(json, tipoLista);
            
            if(admins == null)
                admins = new ArrayList<>();
        }
       return admins; 
    }
}
