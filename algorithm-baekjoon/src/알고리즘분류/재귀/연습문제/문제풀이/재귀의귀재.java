package 알고리즘분류.재귀.연습문제.문제풀이;

import java.io.*;

public class 재귀의귀재 {

    private static final String IS_PALINDROME = "1";
    private static final String IS_NOT_PALINDROME = "0";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String word = bufferedReader.readLine();
            boolean isPalindrome = isPalindrome(word, 0, word.length() - 1);
            bufferedWriter.write(isPalindrome ? IS_PALINDROME : IS_NOT_PALINDROME);
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isPalindrome(String word, int left, int right) {
        // 문자가 같거나 하나만 남았다면 종료한다.
        if (left >= right) return true;
        // 문자가 다르면 팰린드롬이 아니다.
        if (word.charAt(left) != word.charAt(right)) return false;

        return isPalindrome(word, left + 1, right - 1);
    }
}
