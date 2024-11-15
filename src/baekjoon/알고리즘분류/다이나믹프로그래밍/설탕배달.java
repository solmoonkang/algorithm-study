package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 설탕배달 {

    static final int BAG_3KG = 3;
    static final int BAG_5KG = 5;

    static int[] dynamic;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int bagNumberToTabulation = getLeastBagsNeededTabulation(N);

        dynamic = new int[N + 1];
        int bagNumberToMemoization = getLeastBagsNeededMemoization(N);

        bufferedWriter.write("Tabulation: " + bagNumberToTabulation + "\n");
        bufferedWriter.write("Memoization: " + bagNumberToMemoization);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getLeastBagsNeededTabulation(int weight) {
        int[] dynamicArray = new int[weight + 1];

        for (int i = 1; i <= weight; i++) {
            dynamicArray[i] = Integer.MAX_VALUE;
            if (i >= 5 && dynamicArray[i - 5] != Integer.MAX_VALUE) {
                dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i - 5] + 1);
            }

            if (i >= 3 && dynamicArray[i - 3] != Integer.MAX_VALUE) {
                dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i - 3] + 1);
            }
        }

        return dynamic[weight] == Integer.MAX_VALUE ? -1 : dynamic[weight];
    }

    public static int getLeastBagsNeededMemoization(int weight) {
        if (weight < 0) return Integer.MAX_VALUE;
        if (weight == 0) return 0;

        if (dynamic[weight] != 0) return dynamic[weight];

        int bagsUsing5kg = getLeastBagsNeededMemoization(weight - BAG_5KG);
        int bagsUsing3kg = getLeastBagsNeededMemoization(weight - BAG_3KG);

        int minBags = Math.min(bagsUsing5kg, bagsUsing3kg);

        dynamic[weight] = (minBags == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minBags + 1;

        return dynamic[weight];
    }
}
