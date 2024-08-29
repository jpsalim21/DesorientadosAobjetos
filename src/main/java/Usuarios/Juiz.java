/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.util.List;

/**
 *
 * @author ice
 */
public class Juiz extends Usuario {
    List<String> torneios; //FIXME: A lista é de torneios, mas vamos trocar depois

    public Juiz(String nome, String senha) {
        super(nome, senha);
    }
    
}
