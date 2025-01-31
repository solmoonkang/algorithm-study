package 알고리즘분류.문자열.복습문제;

import java.io.*;

public class 팰린드롬수 {

    private static final String IS_PALINDROME = "yes";
    private static final String IS_NOT_PALINDROME = "no";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String number = bufferedReader.readLine();
            if (number.equals("0")) break;

            bufferedWriter.write(isPalindromeNumber(number) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String isPalindromeNumber(String number) {
        int left = 0;
        int right = number.length() - 1;

        while (left < right) {
            if (number.charAt(left) == number.charAt(right)) {
                left++;
                right--;
            } else {
                return IS_NOT_PALINDROME;
            }
        }

        return IS_PALINDROME;
    }
}
