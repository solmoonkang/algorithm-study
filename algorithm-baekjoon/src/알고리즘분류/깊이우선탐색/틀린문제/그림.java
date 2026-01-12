package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 그림 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int height, width;
    private static boolean[][] visited;
    private static int[][] drawingPapers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());

        drawingPapers = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < width; j++) {
                drawingPapers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        List<Integer> paintingList = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 현재 정점이 방문되지 않았고, 1인 경우에만 DFS를 시작한다. 즉, 새로운 그림을 찾기 위한 조건이다.
                if (!visited[i][j] && drawingPapers[i][j] == 1) {
                    // 배열의 크기가 1인 이유는 넓이를 저장하기 위해서이다. 배열은 참조 타입이므로, DFS 내에서 배열의 값을 변경하면 호출한 곳에서도 그 값이 변경된다.
                    int[] painting = {0};
                    DFS(i, j, painting);
                    paintingList.add(painting[0]);
                }
            }
        }

        paintingList.sort(Comparator.reverseOrder());
        bufferedWriter.write(paintingList.size() + "\n" + paintingList.get(0));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int startX, int startY, int[] painting) {
        visited[startX][startY] = true;
        // DFS 탐색 중에 현재 그림의 넓이를 계산하기 위해서 사용된다.
        // DFS가 호출될 때마다 현재 정점이 1일 경우, 해당 정점을 포함시키기 위해 painting[0]의 값을 증가시킨다.
        // DFS가 인접한 모든 1인 정점을 재귀적으로 탐색하면서, 각 정점을 방문할 때마다 넓이가 증가하게 된다. 결국 DFS가 종료될 때, painting[0]에는 해당 그림의 넓이가 저장된다.
        painting[0]++;

        for (int[] direction : DIRECTIONS) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            // 탐색 중 인접 정점이 방문되지 않았고, 1인 경우에만 DFS를 재귀적으로 호출하여 그림의 넓이를 확장한다는 조건이다.
            if (nx >= 0 && nx < height && ny >= 0 && ny < width && !visited[nx][ny] && drawingPapers[nx][ny] == 1) {
                DFS(nx, ny, painting);
            }
        }
    }
}
