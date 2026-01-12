package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        int[] roadLengths = new int[N - 1];
        int[] fuelPrices = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int length = 0; length < N - 1; length++)
            roadLengths[length] = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int price = 0; price < N; price++) fuelPrices[price] = Integer.parseInt(stringTokenizer.nextToken());

        int minTravelCost = findMinimumTravelCost(roadLengths, fuelPrices);
        bufferedWriter.write(String.valueOf(minTravelCost));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMinimumTravelCost(int[] roadLength, int[] fuelPrices) {
        int totalFuelCost = 0;
        int currentPrice = fuelPrices[0];

        for (int i = 0; i < N - 1; i++) {
            int distance = roadLength[i];

            if (currentPrice > fuelPrices[i + 1]) currentPrice = fuelPrices[i + 1];
            totalFuelCost += distance * currentPrice;
        }

        return totalFuelCost;
    }
}
