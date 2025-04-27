package Aplicacao_JogoLabirinto;
//@author Marcus Machine

import JogoLabirinto.*;
import java.util.Stack;

public class Aplicacao_JogoLabirinto {
    public static void main(String[] args) {
        
        Cobra cb = new Cobra ();
        
        
        cb.Caminho(new Coordenada(0, 3) );
        cb.Caminho(new Coordenada(1, 3) );
        cb.Caminho(new Coordenada(2, 3) );
        
        String dados = cb.imprimirCaminho();
        System.out.println(dados);
        
        Coordenada coord = cb.topo();
        System.out.println(coord);
        
        int tam = cb.tamanho();
        System.out.println(tam);

    



    }
    
}
