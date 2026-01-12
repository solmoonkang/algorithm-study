package 모든문제.level2.복습문제;

import java.io.*;

public class 점프와순간이동 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int batteryUsage = findMinBatteryUsage(N);
        bufferedWriter.write(String.valueOf(batteryUsage));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMinBatteryUsage(int N) {
        // 한 번에 K칸을 앞으로 점프하거나, (현재까지 온 거라) x 2에 해당하는 위치로 순간이동을 할 수 있다.
        // 순간이동을 하면 건전지 사용량이 줄지 않지만, 점프하면 K만큼의 건전지 사용량이 소모된다.
        // 거리가 N만큼 떨어진 장소로 이동해야 하며, 점프로 이동하는 횟수를 최소로 할 때 N만큼 이동하기 위해 사용해야 하는 건전지 사용량의 최솟값을 구해야 한다.
        int usage = 0;

        while (N > 0) {
            if (N % 2 == 1) {
                N--;
                usage++;
            }
            N /= 2;
        }

        return usage;
    }
}
