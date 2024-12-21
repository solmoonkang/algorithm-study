package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 사다리조작 {

    private static final String UNFEASIBLE = "-1";

    private static int N, M, H;
    private static boolean[][] horizontalLines;
    private static int minHorizontalLines = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        horizontalLines = new boolean[H + 1][N];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            horizontalLines[A][B] = true;
        }

        addHorizontalLines(0, 0);
        bufferedWriter.write(isHorizontalLinesExceedLimit() ? UNFEASIBLE : String.valueOf(minHorizontalLines));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void addHorizontalLines(int startRow, int depth) {
        if (depth > 3) return;                  // 3개 초과 시 종료
        if (findMinimumHorizontalLines()) {
            minHorizontalLines = Math.min(minHorizontalLines, depth);
            return;
        }

        for (int a = 1; a <= H; a++) {
            for (int b = 1; b < N; b++) {
                // 가로선 추가 조건 확인
                if (!horizontalLines[a][b] && !horizontalLines[a][b - 1] && !horizontalLines[a][b + 1]) {
                    horizontalLines[a][b] = true;       // 가로선 추가
                    addHorizontalLines(a, depth + 1);   // 다음 깊이로 진행
                    horizontalLines[a][b] = false;      // 백트래킹
                }
            }
        }
    }

    private static boolean findMinimumHorizontalLines() {
        for (int i = 0; i < N; i++) {
            int currentLine = i;

            for (int j = 1; j <= H; j++) {
                if (horizontalLines[j][currentLine]) currentLine++;                                 // 오른쪽으로 이동
                else if (currentLine > 0 && horizontalLines[j][currentLine - 1]) currentLine--;     // 왼쪽으로 이동
            }

            if (currentLine != i) return false;     // 자기 자신으로 돌아오지 않으면 FALSE
        }

        return true;                                // 모든 세로선이 자기 자신으로 돌아오면 TRUE
    }

    private static boolean isHorizontalLinesExceedLimit() {
        return minHorizontalLines > 3;
    }
}
