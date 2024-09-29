/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
 */
package Persistencias;

import java.util.List;

public interface Persistencia<T> {
    
    String DIRECTORY = "data";
    public void save(List<T> itens);
    public List<T> findAll();
    
}
