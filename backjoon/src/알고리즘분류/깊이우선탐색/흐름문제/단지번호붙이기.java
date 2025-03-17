package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static boolean[][] visited;
    private static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        List<Integer> complexNumbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // graph[i][j] == '1' 체크를 두 번하는 이유는 main()에서는 DFS 호출을 제한하고, DFS 내부에서는 탐색 방향을 제한하기 위함이다.
                if (!visited[i][j] && graph[i][j] == '1') {
                    int count = DFS(i, j);
                    complexNumbers.add(count);
                }
            }
        }

        Collections.sort(complexNumbers);
        bufferedWriter.write(complexNumbers.size() + "\n");
        for (int number : complexNumbers) bufferedWriter.write(number + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        visited[x][y] = true;
        // 현재 단지에 포함된 집의 개수를 세는 변수이다. 즉, DFS가 실행되는 순간 이미 집이 하나 있다는 것을 의미한다. 때문에 0이 아닌 1로 초기화한다.
        int count = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                // 부모 DFS에서 count += DFS()로 값을 누적시켜 재귀적으로 값이 계속 합쳐져서 최종적으로 올바른 개수가 반환된다.
                if (graph[nx][ny] == '1') count += DFS(nx, ny);
            }
        }

        return count;
    }
}
