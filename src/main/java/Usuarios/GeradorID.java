/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Usuarios;

import Eventos.GerenciaUsuarios;
import java.util.List;

/**
 *
 * @author mateu
 */
public class GeradorID {
    private static GeradorID singleton;
    private static int ID;

    public GeradorID() {
        //carregar os IDS ja gerados anteriormente e atribui ao ID para continuar a geração
        GerenciaUsuarios gerenciador = GerenciaUsuarios.getSingleton();
        ID = getLast(gerenciador.getUsers());
    }
    
    public static GeradorID getSingleton(){
        if(singleton == null)
            singleton = new GeradorID();
        return singleton;
    }
    
    public static int generateID(){
        ID++;
        return ID;
    }
    
    private int getLast(List<Usuario> user){
        int lastID = 0;
        if(user.isEmpty())
            return 0;
        for(Usuario u: user){
            if(u.getID() > lastID)
                lastID = u.getID();
        }
        return lastID;
    }
}
