package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.*;

public class 보석도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int jewelsNumber = Integer.parseInt(stringTokenizer.nextToken());
        int bagsNumber = Integer.parseInt(stringTokenizer.nextToken());

        int[][] jewelryInformation = new int[jewelsNumber][2];
        for (int i = 0; i < jewelsNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jewelryInformation[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            jewelryInformation[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] maxBagWeight = new int[bagsNumber];
        for (int i = 0; i < bagsNumber; i++) {
            maxBagWeight[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int maxPrice = getMaxPriceGemsCanBeStolen(jewelryInformation, maxBagWeight);
        bufferedWriter.write(String.valueOf(maxPrice));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxPriceGemsCanBeStolen(int[][] jewelryInformation, int[] maxBagWeight) {
        // 가방의 무게에 맞춰 보석을 선택하기 위해 보석을 무게 기준으로 정렬한다. 가방의 최대 무게와 비교하기 위해 보석을 무게 순으로 정렬하는 것이 효율적이다.
        Arrays.sort(jewelryInformation, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(maxBagWeight);

        // 최대 가격 순으로 정렬하기 위해 기본적으로 오름차순 정렬되는 우선순위 큐를 역순으로 처리해 내림차순 정렬이 되도록 한다.
        PriorityQueue<Integer> priceHeap = new PriorityQueue<>(Collections.reverseOrder());

        int jewelryIndex = 0;
        int jewelryPriceSum = 0;

        for (int bagWeight : maxBagWeight) {
            while (jewelryIndex < jewelryInformation.length && jewelryInformation[jewelryIndex][0] <= bagWeight) {
                priceHeap.offer(jewelryInformation[jewelryIndex][1]);
                jewelryIndex++;
            }

            if (!priceHeap.isEmpty()) jewelryPriceSum += priceHeap.poll();
        }

        return jewelryPriceSum;
    }
}
