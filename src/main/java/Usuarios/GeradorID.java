/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Usuarios;

import Eventos.GerenciaUsuarios;
import java.util.List;
import Torneios.*;
/**
 *
 * @author mateu
 */
public class GeradorID {
    private static GeradorID singleton;
    private static int pID;
    private static int tID;

    private GeradorID() {
        //carregar os IDS ja gerados anteriormente e atribui ao ID para continuar a geração
        GerenciaUsuarios gerenciador = GerenciaUsuarios.getSingleton();
        pID = getLastUser(gerenciador.getUsers());
        tID = getLastTournament(gerenciador.getAllTournaments());
    }
    
    public static GeradorID getSingleton(){
        if(singleton == null)
            singleton = new GeradorID();
        return singleton;
    }
    
    public int generatePlayerID(){
        pID++;
        return pID;
    }
    
    public int generateTournamentID(){
        tID++;
        return tID;
    }
    
    private int getLastUser(List<Usuario> user){
        int lastID = 0;
        if(user.isEmpty())
            return 0;
        for(Usuario u: user){
            if(u.getID() > lastID)
                lastID = u.getID();
        }
        return lastID;
    }
    
    private int getLastTournament(List<TorneioSuico> torneios){
        int lastID = 0;
        if(torneios.isEmpty())
            return 0;
        for(TorneioSuico t: torneios){
            if(t.getId() > lastID)
                lastID = t.getId();
        }
        return lastID;
    }
}
