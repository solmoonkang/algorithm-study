package programmers.알고리즘고득점KIT.DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 아이템줍기 {

    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // TODO: 테스트 케이스 실패, 아래쪽과 위쪽 + 왼쪽과 오른쪽 테두리를 리스트에 넣는 방식에 대해 이해가 부족하다. 다시 한 번 풀어보자.
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[51][51];
        List<int[]> perimeter = new ArrayList<>();

        for (int[] rect : rectangle) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            for (int x = x1; x < x2; x++) {
                perimeter.add(new int[]{x, y1});
                perimeter.add(new int[]{x, y2});
            }

            for (int y = y1; y < y2; y++) {
                perimeter.add(new int[]{x1, y});
                perimeter.add(new int[]{x2, y});
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == itemX && y == itemY) return distance;

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 1 && nx < 51 && ny >= 1 && ny < 51 && !visited[nx][ny] && isOnPerimeter(nx, ny, perimeter)) {
                    visited[nx][ny] = true;
                    deque.offerLast(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1;
    }

    private boolean isOnPerimeter(int x, int y, List<int[]> perimeter) {
        for (int[] point : perimeter) {
            if (point[0] == x && point[1] == y) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        아이템줍기 selectItem = new 아이템줍기();

        int[][] rectangles1 = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };
        int characterX1 = 1;
        int characterY1 = 3;
        int itemX1 = 7;
        int itemY1 = 8;
        System.out.println("selectItem = " + selectItem.solution(rectangles1, characterX1, characterY1, itemX1, itemY1));

        int[][] rectangles2 = {
                {1, 1, 8, 4},
                {2, 2, 4, 9},
                {3, 6, 9, 8},
                {6, 3, 7, 7}
        };
        int characterX2 = 9;
        int characterY2 = 7;
        int itemX2 = 6;
        int itemY2 = 1;
        System.out.println("selectItem = " + selectItem.solution(rectangles2, characterX2, characterY2, itemX2, itemY2));

        int[][] rectangles3 = {
                {1, 1, 5, 7}
        };
        int characterX3 = 1;
        int characterY3 = 1;
        int itemX3 = 4;
        int itemY3 = 7;
        System.out.println("selectItem = " + selectItem.solution(rectangles3, characterX3, characterY3, itemX3, itemY3));

        int[][] rectangles4 = {
                {2, 1, 7, 5},
                {6, 4, 10, 10}
        };
        int characterX4 = 3;
        int characterY4 = 1;
        int itemX4 = 7;
        int itemY4 = 10;
        System.out.println("selectItem = " + selectItem.solution(rectangles4, characterX4, characterY4, itemX4, itemY4));

        int[][] rectangles5 = {
                {2, 2, 5, 5},
                {1, 3, 6, 4},
                {3, 1, 4, 6}
        };
        int characterX5 = 1;
        int characterY5 = 4;
        int itemX5 = 6;
        int itemY5 = 3;
        System.out.println("selectItem = " + selectItem.solution(rectangles5, characterX5, characterY5, itemX5, itemY5));
    }
}
