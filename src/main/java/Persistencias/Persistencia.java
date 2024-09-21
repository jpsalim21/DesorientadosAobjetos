/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Persistencias;

import java.util.List;

public interface Persistencia<T> {
    
    String DIRECTORY = "data";
    public void save(List<T> itens);
    public List<T> findAll();
    
}
