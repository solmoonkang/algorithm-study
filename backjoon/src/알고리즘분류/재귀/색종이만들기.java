package 알고리즘분류.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이만들기 {

    private static int whiteConfettiCount = 0;
    private static int blueConfettiCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        divideAndCountSameColorConfetti(papers, 0, 0, N);
        bufferedWriter.write(whiteConfettiCount + "\n" + blueConfettiCount);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 현재 영역이 같은 색인지를 확인하고, 같으면 해당 색의 카운트를 증가시킨다. 같지 않다면 영역을 4개로 나누어 재귀적으로 호출한다.
    private static void divideAndCountSameColorConfetti(int[][] papers, int x, int y, int size) {
        if (isSameColorConfetti(papers, x, y, size)) {
            if (papers[x][y] == 0) whiteConfettiCount++;
            else blueConfettiCount++;
            return;
        }

        int newSize = size / 2;

        // 같은 색이 아니라면 I, II, III, IV 영역 4개로 나눈다.
        divideAndCountSameColorConfetti(papers, x, y, newSize);
        divideAndCountSameColorConfetti(papers, x, y + newSize, newSize);
        divideAndCountSameColorConfetti(papers, x + newSize, y, newSize);
        divideAndCountSameColorConfetti(papers, x + newSize, y + newSize, newSize);
    }

    // 주어진 영역의 색을 체크하여 모두 같은지를 확인한다.
    private static boolean isSameColorConfetti(int[][] papers, int x, int y, int size) {
        int color = papers[x][y];

        // 반복문을 통해 현재 영역의 모든 색을 검사하고, 하나라도 다르면 FALSE를 반환한다.
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (papers[i][j] != color) return false;
            }
        }

        // 모든 색이 같다면 TRUE를 반환한다.
        return true;
    }
}
