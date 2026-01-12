package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int citiesNumber = Integer.parseInt(bufferedReader.readLine());

        int[] neighborCitiesConnectRoad = new int[citiesNumber - 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < citiesNumber - 1; i++) {
            neighborCitiesConnectRoad[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] pricePerLiterGas = new int[citiesNumber];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < citiesNumber; i++) {
            pricePerLiterGas[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        long totalGasPrice = 0;
        long currentGasPrice = pricePerLiterGas[0];

        for (int i = 0; i < citiesNumber - 1; i++) {
            // 현재 최저 가격으로 업데이트한다.
            currentGasPrice = Math.min(currentGasPrice, pricePerLiterGas[i]);
            // 최저 가격으로 주유 비용을 계산한다.
            totalGasPrice += currentGasPrice * neighborCitiesConnectRoad[i];
        }

        bufferedWriter.write(String.valueOf(totalGasPrice));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
