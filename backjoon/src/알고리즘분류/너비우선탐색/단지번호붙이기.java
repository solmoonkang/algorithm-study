package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static Deque<int[]> deque = new LinkedList<>();
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        arrayLists = new int[N][N];

        for (int i = 0; i < N; i++) {
            String complex = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                arrayLists[i][j] = complex.charAt(j) - '0';
            }
        }

        List<Integer> complexLists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrayLists[i][j] == 1 && !visited[i][j]) {
                    int complex = BFS(i, j);
                    complexLists.add(complex);
                }
            }
        }

        Collections.sort(complexLists);

        bufferedWriter.write(complexLists.size() + "\n");

        for (int complex : complexLists) {
            bufferedWriter.write(complex + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start, int end) {
        deque.offerLast(new int[]{start, end});
        visited[start][end] = true;

        int complex = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                complex++;

                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && arrayLists[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return complex;
    }
}
