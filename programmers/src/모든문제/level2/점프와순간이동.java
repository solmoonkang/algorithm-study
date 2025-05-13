package 모든문제.level2;

import java.io.*;

public class 점프와순간이동 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int batteryUsage = getLowerBatteryUsage(N);
        bufferedWriter.write(String.valueOf(batteryUsage));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 문제 풀이 전략
     * - 정방향으로 0 -> N으로 시뮬레이션하면 언제 점프할지, 언제 순간이동할지 결정이 어려워 탐색량이 많아진다.
     * - 역으로 N -> 0으로 줄이는 방식으로 접근한다면, 배터리 소모가 되지 않는 순간이동으로 최대한 하고, 홀수일 때만 점프를 하면 된다.
     * - 즉, N을 2진수로 표현했을 때의 1의 개수가 곧 배터리 사용량이 된다.
     */
    private static int getLowerBatteryUsage(int N) {
        int usage = 0;

        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N -= 1;
                usage++;
            }

        }

        return usage;
        // return Integer.bitCount(N);
    }
}
