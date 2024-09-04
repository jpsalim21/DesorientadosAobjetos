/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Usuarios.Juiz;
/**
 *
 * @author mateu
 */
public class JuizPersistencia implements Persistencia<Juiz>{
    private static final String PATH = DIRECTORY+ File.separator +"Juizes.json";
    
    @Override
    public void save(List<Juiz> juizes){
        
    }
    
    @Override
    public List<Juiz> findAll(){
        List<Juiz> juizes = new ArrayList<>();
       return juizes; 
    }
}
