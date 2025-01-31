package 단계문제.재귀;

import java.io.*;

public class 재귀의귀재 {

    private static int recursiveCalls = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int isPalindromeCheck = isPalindrome(bufferedReader.readLine());
            bufferedWriter.write(isPalindromeCheck + " " + recursiveCalls + "\n");
            recursiveCalls = 0;
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int isPalindrome(String alphabet) {
        return recursion(alphabet, 0, alphabet.length() - 1);
    }

    private static int recursion(String alphabet, int left, int right) {
        recursiveCalls++;
        if (left >= right) return 1;
        else if (alphabet.charAt(left) != alphabet.charAt(right)) return 0;
        else return recursion(alphabet, left + 1, right - 1);
    }
}
