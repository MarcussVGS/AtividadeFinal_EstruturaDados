package JogoLabirinto;

import java.awt.Point;
import java.util.*;

public class CobraResolvedora {
    private static final int[] movimentoX = {1, -1, 0, 0}; //olhando pra direita e pra esquerda
    private static final int[] movimentoY = {0, 0,  1, -1}; //olhando pra cima e pra baixo

    private static List<Point> resolveLab(int[][] lab, Point inicio) {
        Queue<Point> filaExploracao = new LinkedList<>(); // Lista de campos a serem explocarados
        Map<Point, Point> mapaCaminho = new HashMap<>(); // Para reconstruir o caminho
//           /\      /\    
 // liga��o filho -> pai
        boolean[][] visitado = new boolean[lab.length][lab[0].length]; // Mapa/matriz de visitas
        
//      inicializa as "listas"
        filaExploracao.add(inicio);
        visitado[inicio.x][inicio.y] = true; //marca cin visitado a primeira pos
        mapaCaminho.put(inicio, null); // inicio n tem pai por ser o primeiro

//        continua verificando ate acabar os campos 
        while (!filaExploracao.isEmpty()) {
            Point pontoAtual = filaExploracao.poll();
//          verifica��o do campo atual
            System.out.println("posi��o atual: " + (pontoAtual.x+1) +"," + (pontoAtual.y+1) );
            
//      se o ponto atul a ser verificado foi a saida, inicia o metodod e montar caminho
            if (lab[pontoAtual.x][pontoAtual.y] == 3) {
                System.out.println("");
                return montarCaminho(mapaCaminho, pontoAtual);
            }
//      se n�o, parte para verificar todas as posi��es ao redor do ponto atual
            for (int i = 0; i < 4; i++) {
                int proxX = pontoAtual.x + movimentoX[i];
                int proxY = pontoAtual.y + movimentoY[i];
//          se a posi��o for valida ele l� as possibilidades apartir daquela posi��o
//          e adiciona as validas para fazer a verifica��o e assim por diante
                if (posValida(lab, proxX, proxY, visitado)) {
                    Point proxPonto = new Point(proxX, proxY);
                    filaExploracao.add(proxPonto);
                    visitado[proxX][proxY] = true;
                    mapaCaminho.put(proxPonto, pontoAtual);
//              verifica��o da leitura do campo
                System.out.println("posi��o lida: " + (proxPonto.x+1) +"," + (proxPonto.y+1) );
                }
            }
        }
        return Collections.emptyList(); // Sem caminho
    }

    private static boolean posValida(int[][] maze, int x, int y, boolean[][] visited) {
        return x >= 0 && x < maze.length && //n pode ser menor que zero ou maior que o tamanho da linha
               y >= 0 && y < maze[0].length && //n pode ser menor que zero ou maior que o tamanho da coluna
               maze[x][y] != 1 //n�o pode ser 1 (parede)
               && !visited[x][y]; //verifica se ja foi visitado na matriz de visitas
    }

    private static List<Point> montarCaminho(Map<Point, Point> mapaCaminho, Point posFinal) {
//      cria a lista que vai receber o percurso
        LinkedList<Point> caminho = new LinkedList<>();
        Point atual = posFinal;
//      ciclo qu vai pegar as informa��es e colocalas na ordem para exibir
        while (atual != null) {
            caminho.addFirst(atual);
            atual = mapaCaminho.get(atual);
        }
        return caminho;
    }
    
    public static void printResolucao (int [][] labirinto, Point inicio){
//      lista populada pelo resolu��o
        List<Point> caminhoEncontrado = CobraResolvedora.resolveLab(labirinto, inicio);
        
//      valida se o caminho esta populado, se vazio retorna sem solu��o
        if(caminhoEncontrado.isEmpty()) {
            System.out.println("Labirinto sem solu�?o!");
        } else {
            System.out.println("Caminho encontrado (" + caminhoEncontrado.size() + " passos):");

            System.out.print("Coordenadas: ");
            for(Point p : caminhoEncontrado) {
                System.out.print("(" + p.x + "," + p.y + ") ");
            }

            System.out.println("\n\nDetalhamento:");
//          ciclo de repeti��o que imprimi as linhas e colunas mapeadas
            for(int i = 0; i < caminhoEncontrado.size(); i++) {
                Point ponto = caminhoEncontrado.get(i);
                System.out.println((i+1) + ". Linha: " + (ponto.x + 1) + " | Coluna: " + (ponto.y + 1));
            }

            System.out.print("\nPercurso: \n");
//          ciclo de repeti��o que imprimi as corodenadas e a dire��o do passo dado
            for(int i = 0; i < caminhoEncontrado.size(); i++) {
                Point atual = caminhoEncontrado.get(i);
                System.out.print("(" + atual.x + "," + atual.y + ")");

                if(i < caminhoEncontrado.size() - 1) {
                    Point prox = caminhoEncontrado.get(i+1);
                    // Determinar dire�?o do movimento
                    if(prox.x > atual.x) System.out.print(".B -");      //B - baixo
                    else if(prox.x < atual.x) System.out.print(".C -"); //C - cima
                    else if(prox.y > atual.y) System.out.print(".D -"); //D - direita
                    else System.out.print(".E -");                      //E - esquerda
                } 
                if(i > 0 && i % 4 == 0) System.out.println();
            }
        }
    }
}
