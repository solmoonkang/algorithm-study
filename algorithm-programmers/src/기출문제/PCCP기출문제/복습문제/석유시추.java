package 기출문제.PCCP기출문제.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 석유시추 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] landWithOil;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        landWithOil = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                landWithOil[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] oilSizes = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && landWithOil[i][j] == 1) {
                    int oilSize = DFS(i, j);

                    for (int k = 0; k < M; k++) {
                        if (visited[i][k]) oilSizes[k] += oilSize;
                    }
                }
            }
        }

        int maxOilNumber = 0;
        for (int oil : oilSizes) maxOilNumber = Math.max(maxOilNumber, oil);
        bufferedWriter.write(String.valueOf(maxOilNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /*
     * 석유 덩어리처럼 연결된 구조를 탐색할 때, DFS는 빠르게 하나의 덩어리를 완전히 탐색할 수 있다. 따라서 연결된 셀을 찾는 것으로 DFS가 적합하다.
     * 스택 구조를 사용하는 DFS는 깊은 연결을 탐색하는 데 유리하며, 석유가 연결된 형태로 분포되어 있을 때 잘 처리할 수 있다.
     */
    private static int DFS(int x, int y) {
        visited[x][y] = true;
        // 현재 탐색 중인 셀(석유가 있는)을 포함하기 위해서 현재 셀에서 DFS를 시작할 때, 셀 자체도 덩어리에 포함되도록 초기 크기를 1로 설정한다.
        int oilSize = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && landWithOil[nx][ny] == 1) {
                oilSize += DFS(nx, ny);
            }
        }

        return oilSize;
    }
}
