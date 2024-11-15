package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 일로만들기 {

    static int[] dynamic;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int leastCountToTabulation = findLeastOperationsToOneTabulation(N);

        dynamic = new int[N + 1];
        int leastCountToMemoization = findLeastOperationsToOneMemoization(N);

        bufferedWriter.write("Tabulation: " + leastCountToTabulation + "\n");
        bufferedWriter.write("Memoization: " + leastCountToMemoization);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int findLeastOperationsToOneTabulation(int number) {
        int[] dynamicArray = new int[number + 1];

        dynamicArray[1] = 0;

        for (int i = 2; i <= number; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + 1;

            if (i % 2 == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i / 2] + 1);
            if (i % 3 == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i / 3] + 1);
        }

        return dynamicArray[number];
    }

    public static int findLeastOperationsToOneMemoization(int number) {
        if (number == 1) return 0;
        if (dynamic[number] != 0) return dynamic[number];

        int leastCount = findLeastOperationsToOneMemoization(number - 1) + 1;

        if (number % 2 == 0) leastCount = Math.min(leastCount, findLeastOperationsToOneMemoization(number / 2) + 1);
        if (number % 3 == 0) leastCount = Math.min(leastCount, findLeastOperationsToOneMemoization(number / 3) + 1);

        dynamic[number] = leastCount;
        return leastCount;
    }
}
