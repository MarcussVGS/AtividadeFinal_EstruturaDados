package JogoLabirinto;

import java.awt.Point;
import java.util.*;

public class CobraResolvedora {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0,  1, -1};

    public static List<Point> solveMazeBFS(int[][] maze, Point start) {
        Queue<Point> queue = new LinkedList<>();
        Map<Point, Point> parentMap = new HashMap<>(); // Para reconstruir o caminho
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        queue.add(start);
        visited[start.x][start.y] = true;
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            if (maze[current.x][current.y] == 3) {
                return reconstructPath(parentMap, current);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                
                if (isValid(maze, nextX, nextY, visited)) {
                    Point next = new Point(nextX, nextY);
                    queue.add(next);
                    visited[nextX][nextY] = true;
                    parentMap.put(next, current);
                }
            }
        }
        return Collections.emptyList(); // Sem caminho
    }

    private static boolean isValid(int[][] maze, int x, int y, boolean[][] visited) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length &&
               maze[x][y] != 1 && !visited[x][y];
    }

    private static List<Point> reconstructPath(Map<Point, Point> parentMap, Point end) {
        LinkedList<Point> path = new LinkedList<>();
        Point current = end;
        while (current != null) {
            path.addFirst(current);
            current = parentMap.get(current);
        }
        return path;
    }
}
