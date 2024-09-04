/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Torneios.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateu
 */
public class TorneiosPersistencia implements Persistencia<Torneio>{
    private static final String PATH = DIRECTORY+ File.separator +"torneios.json";
    
    @Override
    public void save(List<Torneio> torneios){
        
    }
    
    @Override
    public List<Torneio> findAll(){
        List<Torneio> torneio = new ArrayList<>();
       return torneio; 
    }
}
