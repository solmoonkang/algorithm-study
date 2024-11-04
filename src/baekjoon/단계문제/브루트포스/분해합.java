package baekjoon.단계문제.브루트포스;

import java.io.*;

public class 분해합 {

    /**
     * 자연수 M의 분해합은 M + S(M)이다. 여기서 S(M)은 M의 각 자리수를 더한 값이다.
     * N의 생성자를 찾기 위해서는 M을 N에 가까운 값에서 탐색해야 한다.
     * 자리수의 합이 최대 9 * d까지 증가할 수 있으므로, N의 생성자는 N - 9 * d 이하의 수에서 찾을 수 있다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        for (int M = Math.max(1, N - 9 * String.valueOf(N).length()); M < N; M++) {
            int sum = M;

            int temp = M;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                answer = M;
                break;
            }
        }

        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
