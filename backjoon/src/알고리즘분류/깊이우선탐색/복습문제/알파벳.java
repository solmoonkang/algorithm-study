package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {

    private static int R, C;
    private static boolean[] visited;
    private static char[][] arrayLists;
    private static int maxNumberCells = 0;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new char[R][C];

        for (int i = 0; i < R; i++) {
            String words = bufferedReader.readLine();
            arrayLists[i] = words.toCharArray();
        }

        visited = new boolean[26];

        // 배열의 인덱스는 0부터 시작하므로 1행 1열이 (0, 0)으로 시작해야 한다.
        // count는 현재 경로에서 지나온 칸 수를 나타내므로 말이 처음 있는 시작 위치를 포함하여 이미 지나온 칸 수를 세기 위한 초기값으로 1을 설정한다.
        DFS(0, 0, 1);

        bufferedWriter.write(String.valueOf(maxNumberCells));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, int count) {
        // 현재까지 지나온 최대 칸 수를 업데이트하는 역할을 한다.
        maxNumberCells = Math.max(maxNumberCells, count);
        visited[arrayLists[x][y] - 'A'] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[arrayLists[nx][ny] - 'A']) DFS(nx, ny, count + 1);
            }
        }

        visited[arrayLists[x][y]] = false;
    }
}
