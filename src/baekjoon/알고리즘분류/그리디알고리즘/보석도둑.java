package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보석도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] jewelryInformation = new int[N][2];
        int[] bagCapacities = new int[K];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jewelryInformation[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            jewelryInformation[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bagCapacities[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(jewelryInformation, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(bagCapacities);

        int jewelryTotalPrice = getJewelryTotalPrice(jewelryInformation, bagCapacities);
        bufferedWriter.write(String.valueOf(jewelryTotalPrice));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getJewelryTotalPrice(int[][] jewelryInformation, int[] bagCapacities) {
        int totalJewelryPrice = 0;

        int bagIndex = 0;
        for (int[] jewelry : jewelryInformation) {
            int weight = jewelry[0], value = jewelry[1];

            while (bagIndex < bagCapacities.length && bagCapacities[bagIndex] < weight) bagIndex++;

            if (bagIndex < bagCapacities.length) {
                totalJewelryPrice += value;
                bagIndex++;
            }
        }

        return totalJewelryPrice;
    }
}
