package 단계문제.심화;

import java.io.*;

public class 팰린드롬인지확인하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        bufferedWriter.write(isPalindrome(word) ? "1" : "0");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isPalindrome(String word) {
        String reverseWord = String.valueOf(new StringBuilder(word).reverse());
        return word.equals(reverseWord);
    }
}
