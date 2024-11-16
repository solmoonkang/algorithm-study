package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 일이삼더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int countWay = countWayToSumUsing123(N);
            bufferedWriter.write(countWay + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int countWayToSumUsing123(int target) {
        int[] dynamicArray = new int[target + 1];
        dynamicArray[0] = 1;

        for (int i = 1; i <= target; i++) {
            if (i - 1 >= 0) dynamicArray[i] += dynamicArray[i - 1];
            if (i - 2 >= 0) dynamicArray[i] += dynamicArray[i - 2];
            if (i - 3 >= 0) dynamicArray[i] += dynamicArray[i - 3];
        }

        return dynamicArray[target];
    }
}
