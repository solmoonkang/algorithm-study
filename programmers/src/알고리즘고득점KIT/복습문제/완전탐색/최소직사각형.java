package 알고리즘고득점KIT.복습문제.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 최소직사각형 {

    /**
     * 문제 해결을 위한 필수 연산은 모든 명함의 길이 쌍을 한 번씩 확인하여 최댓값을 구하는 것이다.
     * 필수 연산을 가장 적은 횟수로 수행할 수 있는 방법을 고민한다.
     * - 명함 하나를 확인하기 위해 다른 명함 정보를 반복적으로 참조할 필요가 없다고 판단되면 -> 단일 반복문(O(N))
     * - 모든 명함 쌍의 조합을 확인해야 한다고 판단되면 -> 이중 반복문(O(N^2))
     * sizes의 길이는 1 이상 10,000 이하로 최대 10^8회 미만의 연산을 수행하기 위해서는 O(N)은 매우 안전하게 통과되지만, O(N^2)는 아슬아슬하게 통과하거나 TLE가 발생할 수 있다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] sizes = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                sizes[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        bufferedReader.close();

        int wallet = findMinSizeWallet(sizes);
        bufferedWriter.write(String.valueOf(wallet));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMinSizeWallet(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int maxSize = Math.max(size[0], size[1]);
            int minSize = Math.min(size[0], size[1]);

            if (maxSize > maxW) maxW = maxSize;
            if (minSize > maxH) maxH = minSize;
        }

        return maxW * maxH;
    }
}
