package 모든문제.level1;

import java.io.*;

public class 자연수뒤집어배열로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(bufferedReader.readLine());

        int[] reverseDigits = reverseDigitsToArray(N);
        for (int digit : reverseDigits) bufferedWriter.write(digit + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] reverseDigitsToArray(long N) {
        String number = String.valueOf(N);
        int[] reverseDigits = new int[number.length()];

        StringBuilder stringBuilder = new StringBuilder(number);
        String reverseNumber = stringBuilder.reverse().toString();

        for (int i = 0; i < number.length(); i++) {
            reverseDigits[i] = reverseNumber.charAt(i) - '0';
        }

        return reverseDigits;
    }
}
