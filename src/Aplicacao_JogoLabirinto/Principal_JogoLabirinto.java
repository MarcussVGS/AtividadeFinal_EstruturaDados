package Aplicacao_JogoLabirinto;

import JogoLabirinto.*;
import Labirinto.*;
import java.awt.Point;

public class Principal_JogoLabirinto {

    public static void main(String[] args) {
//      escolhe um dos labirintos para usar
        int [][] lab = Labirintos.labirinto2;
        
//      tem que verificar o ponto exato de inicio caso a caso
        Point start = new Point(4,1);
        
//      apenas do labirinto a ser explorado e seu ponto de inicio
        CobraResolvedora.printResolucao(lab, start);
    }
    
}
