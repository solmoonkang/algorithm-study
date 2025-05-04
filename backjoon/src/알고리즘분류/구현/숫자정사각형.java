package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 숫자정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int maxSide = 1;
        // 직사각형의 세로 길이가 N, 가로 길이가 M이니까, 세로로 N칸보다 큰 정사각형은 안되고, 가로로 M칸보다 큰 정사각형도 안되므로, 한 변의 최대한 커질 수 있는 길이는 min(N, M)이다.
        int maxLength = Math.min(N, M);

        /*
          정사각형 한 변의 길이 L 정하기
          - 정사각형이 될 수 있는 크기, 즉 한 변의 길이 L은 1부터 Math.min(N, M)까지 바꿔 가며 생각할 수 있다.

          L x L 정사각형을 놓을 수 있는 위치
          - 그리드의 왼쪽 위 꼭짓점을 (i, j)라고 할 때, i는 0부터 N-L까지, j는 0부터 M-L까지 움직일 수 있다.
         */
        for (int L = 2; L <= maxLength; L++) {
            // LxL짜리 정사각형을 놓을 때, 왼쪽 위 모서리(i, j)를 (0, 0)부터 (N-L, M-L)까지 움직여 보면 크기가 L짜리 정사각형을 그릴 수 있다.
            for (int i = 0; i + L <= N; i++) {
                for (int j = 0; j + L <= M; j++) {
                    char c = grid[i][j];

                    if (grid[i][j + L - 1] == c && grid[i + L - 1][j] == c && grid[i + L - 1][j + L - 1] == c) {
                        maxSide = Math.max(maxSide, L);
                    }
                }
            }
        }

        int maxSquareSize = maxSide * maxSide;
        bufferedWriter.write(String.valueOf(maxSquareSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
