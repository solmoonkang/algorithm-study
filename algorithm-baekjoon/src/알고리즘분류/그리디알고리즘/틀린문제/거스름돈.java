package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;

public class 거스름돈 {

    private static final int TWO_ONE = 2;
    private static final int FIVE_ONE = 5;
    private static final String CAN_NOT_RETURN = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int minChange = Integer.MAX_VALUE;

        // 가능한 한 많은 5원짜리 동전을 먼저 쓰고, 나머지를 2원짜리로 채워서 정확히 떨어지는 조합을 찾도록 순회한다.
        // N / 5는 거스름돈 N을 5로 나눈 몫을 구한 것으로, 예를 들어 N이 14라면 14 / 5 = 2로 5원짜리 동전 최대 2개까지 써 볼 수 있다는 의미이다.
        for (int k = N / FIVE_ONE; k >= 0; k--) {
            // 5원짜리 k개를 썼을 때 남는 돈을 구한다.
            int remain = N - (k * FIVE_ONE);

            // 남는 돈이 2원짜리로 딱 맞게 채울 수 있는지 확인한다.
            if (remain % 2 == 0) {
                // 나누어 떨어진다면, 5원짜리 동전 k개와 남은 돈 / 2원을 더한 개수를 저장하고, 최소 개수를 구했으므로 break로 탈출한다.
                minChange = k + (remain / TWO_ONE);
                break;
            }
        }

        bufferedWriter.write(minChange == Integer.MAX_VALUE ? CAN_NOT_RETURN : String.valueOf(minChange));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
