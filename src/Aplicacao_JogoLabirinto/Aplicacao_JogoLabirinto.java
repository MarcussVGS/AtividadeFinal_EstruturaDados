package Aplicacao_JogoLabirinto;
//@author Marcus Machine

import JogoLabirinto.*;
import java.util.Stack;

public class Aplicacao_JogoLabirinto {
    public static void main(String[] args) {
        
        Cobra cb = new Cobra ();
        Coordenada coord = new Coordenada();
        
        int [][] labirinto = new int[][]{
            {1,1,1,1,1},
            {2,0,0,0,3},
            {1,1,1,1,1}
        };
        
        System.out.println("Teste de acesso");
        cb.verificarValor(1, 0, labirinto);
        
        System.out.println("\nPasso frente");
//Atributos, qual linha, qual coluna, qual matrix, quem(cobra)
//        cb.passoDireitaTeste(1, 0, labirinto, cb);
        
        cb.incurso( 1, 0, labirinto);
        
        
        
//        cb.Passo(new Coordenada(0, 3) );
//        cb.Passo(new Coordenada(1, 3) );
//        cb.Passo(new Coordenada(2, 3) );
//        
//        String dados = cb.imprimirCaminho();
//        System.out.println(dados);
//        
//        Coordenada coord = cb.topo();
//        System.out.println(coord);
//        
//        int tam = cb.tamanho();
//        System.out.println(tam);

    }
    
}
