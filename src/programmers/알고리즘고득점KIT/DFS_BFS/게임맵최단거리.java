package programmers.알고리즘고득점KIT.DFS_BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 게임맵최단거리 {

    private boolean[][] visited;
    private Deque<int[]> deque = new LinkedList<>();

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {
        return BFS(maps, 0, 0);
    }

    private int BFS(int[][] maps, int startX, int startY) {
        int N = maps.length;
        int M = maps[0].length;

        deque.offerLast(new int[]{0, 0, 1});

        visited = new boolean[N][M];
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == N - 1 && y == M - 1) return distance;

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        deque.offerLast(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        게임맵최단거리 shortestPath = new 게임맵최단거리();

        int[][] map1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println("shortestPath = " + shortestPath.solution(map1));

        int[][] map2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println("shortestPath = " + shortestPath.solution(map2));
    }
}
