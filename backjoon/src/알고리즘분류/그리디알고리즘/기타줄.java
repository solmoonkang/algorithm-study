package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 기타줄 {

    private static final int GUITAR_STRINGS = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] pricesAndIndividualPrices = new int[M][2];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            pricesAndIndividualPrices[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            pricesAndIndividualPrices[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minCostForGuitarStrings = getMinCostForGuitarStrings(N, pricesAndIndividualPrices);
        bufferedWriter.write(String.valueOf(minCostForGuitarStrings));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinCostForGuitarStrings(int N, int[][] pricesAndIndividualPrices) {
        int minPackagePrice = Integer.MAX_VALUE;
        int minIndividualPrice = Integer.MAX_VALUE;

        for (int[] pricesAndIndividualPrice : pricesAndIndividualPrices) {
            minPackagePrice = Math.min(minPackagePrice, pricesAndIndividualPrice[0]);
            minIndividualPrice = Math.min(minIndividualPrice, pricesAndIndividualPrice[1]);
        }

        int totalCost = 0;

        int packagesNeeded = N / GUITAR_STRINGS;
        int remainingStrings = N % GUITAR_STRINGS;

        totalCost += packagesNeeded * minPackagePrice;
        // 남은 줄을 낱개로 사는 경우와 패키지를 구매하는 경우의 비용을 비교한다. 만약 남은 줄이 4개일 때, 패키지 가격이 더 저렴하다면 패키지를 구매하는 것이 맞다.
        totalCost += Math.min(remainingStrings * minIndividualPrice, minPackagePrice);

        // 여분의 줄이 남을 경우를 고려하여 패키지를 추가로 구매할 수 있는 경우도 확인한다.
        if (remainingStrings > 0) totalCost = Math.min(totalCost, (packagesNeeded + 1) * minPackagePrice);

        return totalCost;
    }
}
