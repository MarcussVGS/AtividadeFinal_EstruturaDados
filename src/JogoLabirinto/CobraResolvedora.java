package JogoLabirinto;

import java.awt.Point;
import java.util.*;

public class CobraResolvedora {
    private static final int[] movimentoX = {1, -1, 0, 0}; //olhando pra direita e pra esquerda
    private static final int[] movimentoY = {0, 0,  1, -1}; //olhando pra cima e pra baixo

    public static List<Point> resolveLab(int[][] lab, Point inicio) {
        Queue<Point> filaExploracao = new LinkedList<>(); // Lista de campos a serem explocarados
        Map<Point, Point> mapaCaminho = new HashMap<>(); // Para reconstruir o caminho
//           /\      /\    
 // ligação filho -> pai
        boolean[][] visitado = new boolean[lab.length][lab[0].length]; // Mapa/matriz de visitas
        
//      inicializa as "listas"
        filaExploracao.add(inicio);
        visitado[inicio.x][inicio.y] = true; //marca cin visitado a primeira pos
        mapaCaminho.put(inicio, null); // inicio n tem pai por ser o primeiro

//        continua verificando ate acabar os campos 
        while (!filaExploracao.isEmpty()) {
            Point pontoAtual = filaExploracao.poll();
//          verificação do campo atual
            System.out.println("posição atual: " + (pontoAtual.x+1) +"," + (pontoAtual.y+1) );
            
//      se o ponto atul a ser verificado foi a saida, inicia o metodod e montar caminho
            if (lab[pontoAtual.x][pontoAtual.y] == 3) {
                System.out.println("");
                return montarCaminho(mapaCaminho, pontoAtual);
            }
//      se não, parte para verificar todas as posições ao redor do ponto atual
            for (int i = 0; i < 4; i++) {
                int proxX = pontoAtual.x + movimentoX[i];
                int proxY = pontoAtual.y + movimentoY[i];
//          se a posição for valida ele lê as possibilidades apartir daquela posição
//          e adiciona as validas para fazer a verificação e assim por diante
                if (posValida(lab, proxX, proxY, visitado)) {
                    Point proxPonto = new Point(proxX, proxY);
                    filaExploracao.add(proxPonto);
                    visitado[proxX][proxY] = true;
                    mapaCaminho.put(proxPonto, pontoAtual);
//              verificação da leitura do campo
                System.out.println("posição lida: " + (proxPonto.x+1) +"," + (proxPonto.y+1) );
                }
            }
        }
        return Collections.emptyList(); // Sem caminho
    }

    private static boolean posValida(int[][] maze, int x, int y, boolean[][] visited) {
        return x >= 0 && x < maze.length && //n pode ser menor que zero ou maior que o tamanho da linha
               y >= 0 && y < maze[0].length && //n pode ser menor que zero ou maior que o tamanho da coluna
               maze[x][y] != 1 //não pode ser 1 (parede)
               && !visited[x][y]; //verifica se ja foi visitado na matriz de visitas
    }

    private static List<Point> montarCaminho(Map<Point, Point> mapaCaminho, Point posFinal) {
        LinkedList<Point> caminho = new LinkedList<>();
        Point atual = posFinal;
        while (atual != null) {
            caminho.addFirst(atual);
            atual = mapaCaminho.get(atual);
        }
        return caminho;
    }
    
    
}
