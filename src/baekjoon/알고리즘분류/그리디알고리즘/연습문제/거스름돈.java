package baekjoon.알고리즘분류.그리디알고리즘.연습문제;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 거스름돈 {

    private static final int PURCHASE_AMOUNT = 2730;
    private static final int PAID_AMOUNT = 5000;
    private static final int[] denominations = {1000, 500, 100, 50, 10};

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int change = PAID_AMOUNT - PURCHASE_AMOUNT;

        Arrays.sort(denominations);
        reverseArray();

        bufferedWriter.write("거스름돈 " + change + "원 ");

        for (int denomination : denominations) {
            if (change == 0) break;

            int count = change / denomination;
            change %= denomination;

            if (count > 0) bufferedWriter.write(denomination + "원: " + count + "개, ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void reverseArray() {
        int left = 0, right = denominations.length - 1;

        while (left < right) {
            int temp = denominations[left];
            denominations[left] = denominations[right];
            denominations[right] = temp;
            left++;
            right--;
        }
    }
}
