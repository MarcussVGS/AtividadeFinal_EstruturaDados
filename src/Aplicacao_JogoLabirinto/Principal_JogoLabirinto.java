package Aplicacao_JogoLabirinto;

import JogoLabirinto.*;
import Labirinto.*;
import java.awt.Point;
import java.util.List;

public class Principal_JogoLabirinto {

    public static void main(String[] args) {
//      escolhe um dos labirintos para usar
        int [][] lab = Labirintos.labirinto1;
        
        Point start = new Point(4,1);
        
        // 2. Resolver o labirinto
        List<Point> caminhoEncontrado = CobraResolvedora.resolveLab(lab, start);
        
        // 3. Imprimir as coordenadas
        if(caminhoEncontrado.isEmpty()) {
            System.out.println("Labirinto sem soluç?o!");
        } else {
            System.out.println("Caminho encontrado (" + caminhoEncontrado.size() + " passos):");

            // Imprimir formato 1: Linha única
            System.out.print("Coordenadas: ");
            for(Point p : caminhoEncontrado) {
                System.out.print("(" + p.x + "," + p.y + ") ");
            }

            // Imprimir formato 2: Lista numerada
            System.out.println("\n\nDetalhamento:");
            for(int i = 0; i < caminhoEncontrado.size(); i++) {
                Point ponto = caminhoEncontrado.get(i);
                System.out.println((i+1) + ". Linha: " + (ponto.x + 1) + " | Coluna: " + (ponto.y + 1));
            }

            // Imprimir formato 3: Setas (para visualizaç?o sequencial)
            System.out.print("\nPercurso: \n");
            for(int i = 0; i < caminhoEncontrado.size(); i++) {
                Point atual = caminhoEncontrado.get(i);
                System.out.print("(" + atual.x + "," + atual.y + ")");

                if(i < caminhoEncontrado.size() - 1) {
                    Point prox = caminhoEncontrado.get(i+1);
                    // Determinar direç?o do movimento
                    if(prox.x > atual.x) System.out.print(".B -");
                    else if(prox.x < atual.x) System.out.print(".C -");
                    else if(prox.y > atual.y) System.out.print(".D -");
                    else System.out.print(".E -");
                } 
                if(i > 0 && i % 4 == 0) System.out.println();
            }
        }
    }
    
}
