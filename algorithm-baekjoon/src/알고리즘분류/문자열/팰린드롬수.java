package 알고리즘분류.문자열;

import java.io.*;

public class 팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String palindromeNumber = bufferedReader.readLine();

            if (palindromeNumber.equals("0")) break;
            bufferedWriter.write(isPalindrome(palindromeNumber) ? "yes\n" : "no\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isPalindrome(String palindromeNumber) {
        int left = 0;
        int right = palindromeNumber.length() - 1;

        while (left < right) {
            // 왼쪽의 값과 오른쪽의 값이 서로 다르면 팰린드롬이 아니므로 FALSE를 반환한다.
            if (palindromeNumber.charAt(left) != palindromeNumber.charAt(right)) return false;

            // 왼쪽의 값과 오른쪽의 값이 서로 동일하면 왼쪽과 오른쪽의 인덱스를 조정한다.
            left++;
            right--;
        }

        // while문이 종료되었다면 팰린드롬이므로 TRUE를 반환한다.
        return true;
    }
}
