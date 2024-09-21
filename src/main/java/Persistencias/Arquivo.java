/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Persistencias;

import java.io.*;

public class Arquivo {
    public static String le(String caminhoArq){
        StringBuilder conteudo = new StringBuilder();
        
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArq))){
            String linha;
            while((linha = leitor.readLine()) != null)
                conteudo.append(linha).append("\n");
        } catch (IOException e){
            e.printStackTrace();
        }
        return conteudo.toString();
    }
    
    public static void save(String camihoArq, String conteudo){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(camihoArq,false))){
            escritor.write(conteudo);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
