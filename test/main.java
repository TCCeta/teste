
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patri
 */
public class main {

    public static void main(String[] args) {
        
        String caminho = "C:\\Users\\103782\\Documents\\NetBeansProjects\\TCCetahaha\\web\\imagens\\fundos\\doodles.png";
        
        System.out.println(caminho.indexOf("."));
        
        String[] tipo = caminho.split(".");
        
        System.out.println(tipo[0]);

    }
    
    public static void what(Object obj){
        
        System.out.println(obj instanceof String);
        
    }
}
