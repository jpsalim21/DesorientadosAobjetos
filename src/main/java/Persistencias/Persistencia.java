package Persistencias;

import java.util.List;

/**
 *
 * @author mateu
 */
public interface Persistencia<T> {
    
    String DIRECTORY = "data";
    public void save(List<T> itens);
    public List<T> findAll();
    
}
