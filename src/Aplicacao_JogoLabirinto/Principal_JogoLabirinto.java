package Aplicacao_JogoLabirinto;

import JogoLabirinto.*;
import java.awt.Point;
import java.util.List;

public class Principal_JogoLabirinto {

    public static void main(String[] args) {
        int [][] labirinto1 = new int[][]{
            {1,1,1,1,1},
            {2,0,0,0,3},
            {1,1,1,1,1}
        };
        
        int [][] labirinto2 = new int[][]{
            {1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0},
            {1,0,1,0,1,1,0,1,0},
            {1,0,0,0,0,0,1,0,3},
            {1,2,1,0,1,0,0,1,1}
        };
        
        Point start = new Point(4,1);
        
        // 2. Resolver o labirinto
        List<Point> caminhoEncontrado = CobraResolvedora.resolveLab(labirinto2, start);
        
        // 3. Imprimir as coordenadas
        if(caminhoEncontrado.isEmpty()) {
            System.out.println("Labirinto sem solução!");
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

            // Imprimir formato 3: Setas (para visualização sequencial)
            System.out.print("\nPercurso: \n");
            for(int i = 0; i < caminhoEncontrado.size(); i++) {
                Point atual = caminhoEncontrado.get(i);
                System.out.print("(" + atual.x + "," + atual.y + ")");

                if(i < caminhoEncontrado.size() - 1) {
                    Point prox = caminhoEncontrado.get(i+1);
                    // Determinar direção do movimento
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
