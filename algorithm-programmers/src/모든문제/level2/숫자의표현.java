package 모든문제.level2;

import java.io.*;

public class 숫자의표현 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int expressWay = getNumberExpress(N);
        bufferedWriter.write(String.valueOf(expressWay));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * - 바깥 루프는 1부터 N까지, 안쪽 루프는 최악의 경우 N까지 돌아가며 sum을 계속 누적 계산한다.
     * - N이 10,000이라면 약 5천만 회 반복도리 수 있어 큰 입력에선 비효율적이다.
     * 때문에 시간 복잡도는 O(N^2)를 가지게 되어 비효율적인 방법이다.
     */
    private static int getNumberExpressWithBruteForce(int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            for (int j = i; j <= N; j++) {
                sum += j;
                if (sum == N) count++;
            }
        }

        return count;
    }

    /**
     * 개선된 방법으로 더 효율적으로 접근하기 위해 수학적 아이디어를 활용하면 된다.
     * - N을 연속된 자연수의 합으로 표현할 수 있다는 것은 곧 N = a + (a + 1) + (a + 2) + ... + (a + k - 1) 형태로 표현 가능한지를 보는 문제이다.
     * - 등차수열 합 공식을 적용한다면, N = (k * a) + (k * (k - 1) / 2)로 이를 정리하면, a = (N - (k * (k - 1)) / 2) / k가 된다.
     * - 등차수열의 합 공식은 합 = 개수 * (첫 항 + 마지막 항) / 2로 첫 항은 a, 마지막 항은 a + k - 1, 그리고 개수는 k이다.
     * <p>
     * - 여기서 a는 자연수여야 하므로, (N - (k * (k - 1)) / 2) / k == 0 인지를 확인하면 된다.
     * 떄문에 k * (k - 1) / 2 < N인 동안만 반복되므로 훨씬 적은 횟수로 해결되며 시간 복잡도는 O(√N)를 가진다.
     */
    private static int getNumberExpress(int N) {
        int count = 0;

        for (int k = 1; k * (k - 1) / 2 < N; k++) {
            if ((N - k * (k - 1) / 2) % k == 0) count++;
        }

        return count;
    }
}
