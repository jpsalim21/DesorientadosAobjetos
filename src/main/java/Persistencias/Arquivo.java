/*
 * João Pedro Miranda Salim 202335033
 * Mateus Lopes Felício 202365555C
 * Thales Gomes Batista 202365557C
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
