package programmers.기출문제.Dev_Matching_웹백엔드개발자_2021;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬테두리회전하기 {

    // TODO: 배열을 회전시키는 부분이 다소 어려웠다. 다시 한 번 풀어보면서 감을 잡아보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int rows = Integer.parseInt(stringTokenizer.nextToken());
        int columns = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] queries = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                queries[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] rawRectangleBoard = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rawRectangleBoard[i][j] = i * columns + (j + 1);
            }
        }

        int[] minAfterRotationNumbers = getMinAfterRotations(queries, rawRectangleBoard);
        bufferedWriter.write(Arrays.toString(minAfterRotationNumbers));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getMinAfterRotations(int[][] queries, int[][] rawRectangleBoard) {
        int[] minAfterRotationNumbers = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            minAfterRotationNumbers[i] = rotateRectangle(rawRectangleBoard, x1, y1, x2, y2);
        }

        return minAfterRotationNumbers;
    }

    private static int rotateRectangle(int[][] rawRectangleBoard, int x1, int y1, int x2, int y2) {
        // 추출한 테두리 요소들을 저장하기 위한 배열로, 상단과 하단에서 각각 (y2 - y1 + 1)요소를 가져오고, 우측과 좌측에서 각각 (x2 - x1 - 1)요소를 가져온다.
        // 상단과 하단 그리고 좌측과 우측의 전체 크기에서 각 코너의 중복된 요소를 제거하기 위해 전체 크기 - 4로 설정한다.
        int[] borderElements = new int[(x2 - x1 + 1) * 2 + (y2 - y1 + 1) * 2 - 4];
        int elementIndex = 0;

        // 테두리 요소 추출하는 방법은 다음과 같다.
        // 상단 테두리: x1행의 y1열부터 y2열까지의 요소를 가져옴으로써 상단 테두리의 모든 요소를 추출한다.
        for (int j = y1; j <= y2; j++) borderElements[elementIndex++] = rawRectangleBoard[x1][j];
        // 우측 테두리: y2열의 x1 + 1행부터 x2행까지의 요소를 가져옴으로써 우측 테두리의 모든 요소를 추출한다.
        for (int i = x1 + 1; i <= x2; i++) borderElements[elementIndex++] = rawRectangleBoard[i][y2];
        // 하단 테두리: x2행의 y2 - 1열부터 y1열까지의 요소를 가져옴으로써 하단 테두리의 모든 요소를 추출한다.
        for (int j = y2 - 1; j >= y1; j--) borderElements[elementIndex++] = rawRectangleBoard[x2][j];
        // 좌측 테두리: y1열의 x2 - 1행부터 x1행까지의 요소를 가져옴으로써 좌측 테두리의 모든 요소를 추출한다.
        for (int i = x2 - 1; i > x1; i--) borderElements[elementIndex++] = rawRectangleBoard[i][y1];

        // 추출한 테두리 요소들을 오른쪽으로 회전시키기 위한 과정이다.
        // 추출한 테두리 요소들에 저장된 값을 lastValue 변수에 할당한다. 해당 값은 회전 후 배열의 첫 번째 위치로 삽입된다.
        int lastValue = borderElements[borderElements.length - 1];
        // 배열의 마지막에서 첫 번째까지 이동하면서 현재 인덱스의 요소를 바로 앞 인덱스의 요소로 덮어씌운다.
        for (int i = borderElements.length - 1; i > 0; i--) borderElements[i] = borderElements[i - 1];
        // 저장해 두었던 lastValue를 배열의 첫 번째 위치에 삽입하여 추출한 테두리 요소들을 오른쪽으로 한 칸 회전시킨다.
        borderElements[0] = lastValue;

        elementIndex = 0;
        for (int j = y1; j <= y2; j++) rawRectangleBoard[x1][j] = borderElements[elementIndex++];
        for (int i = x1 + 1; i <= x2; i++) rawRectangleBoard[i][y2] = borderElements[elementIndex++];
        for (int j = y2 - 1; j >= y1; j--) rawRectangleBoard[x2][j] = borderElements[elementIndex++];
        for (int i = x2 - 1; i > x1; i--) rawRectangleBoard[i][y1] = borderElements[elementIndex++];

        return Arrays.stream(borderElements).min().orElse(Integer.MAX_VALUE);
    }
}
