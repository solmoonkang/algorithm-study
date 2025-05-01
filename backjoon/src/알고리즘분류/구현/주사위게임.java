package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 주사위게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] dice = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            dice[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            dice[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            dice[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxPrize = getMaxPrize(dice);
        bufferedWriter.write(String.valueOf(maxPrize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxPrize(int[][] dice) {
        // 반복문을 돌면서 차례대로 나올 수 있는 최대 상금을 계산해서 변수에 저장한다.
        // 그렇게 저장된 변수에 있는 값을 반복문을 통해서 최대 상금을 구하고 반환한다.

        int maxPrize = 0;

        for (int[] roll : dice) {
            int A = roll[0], B = roll[1], C = roll[2];
            int prize = 0;

            // 같은 눈이 3개가 나왔을 경우: A와 B가 같고, B와 C가 같음
            if (A == B && B == C) {
                prize = 10000 + (A * 1000);
            }

            // 같은 눈이 2개가 나왔을 경우: A와 B가 같고 B와 C가 다름, B와 C가 같고 A가 다름, A와 C가 같고 B가 다름
            else if (A == B || B == C || A == C) {
                int sameEye = (A == B ? A : (C));
                prize = 1000 + (sameEye * 100);
            }

            // 모두 다른 눈이 나왔을 경우
            else {
                int maxEye = Math.max(A, Math.max(B, C));
                prize = maxEye * 100;
            }

            // 나오는 값에서 가장 큰 값만 반환한다.
            maxPrize = Math.max(maxPrize, prize);
        }

        return maxPrize;
    }
}
