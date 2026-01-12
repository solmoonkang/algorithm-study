package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 부족한금액계산하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int price = Integer.parseInt(stringTokenizer.nextToken());
        int money = Integer.parseInt(stringTokenizer.nextToken());
        int count = Integer.parseInt(stringTokenizer.nextToken());

        long amount = calculateInsufficientAmount(price, money, count);
        bufferedWriter.write(String.valueOf(amount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long calculateInsufficientAmount(int price, int money, int count) {
        long currentBalance = 0;
        for (int i = 1; i <= count; i++) currentBalance += (long) i * price;

        long insufficientAmount = currentBalance - money;
        if (insufficientAmount <= money) return 0;
        return Math.abs(insufficientAmount);
    }

    private static long anotherSolution(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
