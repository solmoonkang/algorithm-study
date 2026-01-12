package 모든문제.level1;

import java.io.*;
import java.util.Arrays;

public class 공원 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        int matSize = findLargestMatSize(mats, park);
        bufferedWriter.write(String.valueOf(matSize));
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 깔 수 있는 가장 큰 돗자리의 한 변 길이를 반환하는 것이 문제의 핵심 요구사항이므로, 큰 것부터 시도해서 성공하면 즉시 끝내는 탐욕적인 전략이 가장 빠르고 효율적이다.
    private static int findLargestMatSize(int[] mats, String[][] park) {
        // 가장 큰 돗자리의 크기부터 접근하기 위해 오름차순 정렬
        Arrays.sort(mats);

        int R = park.length;        // 행의 수
        int C = park[0].length;     // 열의 수

        // 누적 합 배열 생성, unplaceable[r][c] = (0, 0)부터 (r, c)까지 깔 수 없는 칸(즉, "-1"이 아닌 칸)의 개수
        int[][] unplaceable = buildPrefixSumArray(park, R, C);

        // 그리디 알고리즘 탐색으로 가장 큰 돗자리부터 순서대로 검증
        for (int i = mats.length - 1; i >= 0; i--) {
            // 현재 검사할 돗자리 크기
            int matSize = mats[i];

            // 깔 수 있는 첫 번째 크기를 찾으면 그것이 가장 큰 크기
            if (isPlaceMat(unplaceable, R, C, matSize)) return matSize;
        }

        // 모든 돗자리를 깔 수 없는 경우
        return -1;
    }

    private static int[][] buildPrefixSumArray(String[][] park, int R, int C) {
        // unplaceable[r][c]는 (0, 0)부터 (r-1, c-1)까지의 합을 저장, 배열 크기는 (R+1) x (C+1)로 정의
        int[][] sum = new int[R + 1][C + 1];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // 돗자리를 깔 수 없는 칸은 1, 깔 수 있는 칸은 0으로 초기화
                int value = park[r][c].equals("-1") ? 0 : 1;
                // 2차원 누적 합, sum[r][c] = value + sum[r][c + 1] + sum[r + 1][c] - sum[r][c]
                sum[r + 1][c + 1] = value + sum[r][c + 1] + sum[r + 1][c] - sum[r][c];
            }
        }

        return sum;
    }

    private static boolean isPlaceMat(int[][] sum, int R, int C, int matSize) {
        // 공원에서 matSize x matSize 영역을 만들 수 없는 경우 바로 false 반환
        if (R < matSize || C < matSize) return false;

        // 맵의 모든 가능한 (matSize x matSize) 시작점 (r, c)을 순회, rEnd는 돗자리의 오른쪽 아래 모서리 행 인덱스
        for (int rEnd = matSize; rEnd <= R; rEnd++) {
            for (int cEnd = matSize; cEnd <= C; cEnd++) {
                // matSize x matSize 영역의 왼쪽 위 모서리 좌표 (rStart, cStart)
                int rStart = rEnd - matSize;
                int cStart = cEnd - matSize;

                // 2차원 누적 합 공식으로 영역 내 1의 개수(깔 수 없는 칸)를 O(1)로 계산, sum(D) - sum(B) - sum(C) + sum(A)
                int blockedCount = sum[rEnd][cEnd] - sum[rStart][cEnd] - sum[rEnd][cStart] + sum[rStart][cStart];
                // 영역 내에 깔 수 없는 칸이 0개라면 (모두 "-1"이라면), 돗자리를 깔 수 있으므로 true 반환
                if (blockedCount == 0) return true;
            }
        }

        // 모든 영역을 검사했지만 깔 수 있는 곳이 없어 false 반환
        return false;
    }
}
