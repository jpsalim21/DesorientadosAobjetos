/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import static Persistencias.Persistencia.DIRECTORY;
import Usuarios.Admin;
import java.io.File;
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
        
    }
    
    @Override
    public List<Admin> findAll(){
        List<Admin> admins = new ArrayList<>();
       return admins; 
    }
}
