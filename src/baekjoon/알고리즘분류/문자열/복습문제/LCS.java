package baekjoon.알고리즘분류.문자열.복습문제;

import java.io.*;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String wordA = bufferedReader.readLine();
        String wordB = bufferedReader.readLine();

        int LCSLength = calculateLongestCommonSubsequenceLength(wordA, wordB);
        bufferedWriter.write(String.valueOf(LCSLength));
        bufferedWriter.newLine();

        String LCS = findLongestCommonSubsequence(wordA, wordB);
        bufferedWriter.write(LCS);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateLongestCommonSubsequenceLength(String wordA, String wordB) {
        int lengthA = wordA.length();
        int lengthB = wordB.length();

        int[][] dp = new int[lengthA + 1][lengthB + 1];

        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[lengthA][lengthB];
    }

    private static String findLongestCommonSubsequence(String wordA, String wordB) {
        int lengthA = wordA.length();
        int lengthB = wordB.length();

        int[][] dp = new int[lengthA + 1][lengthB + 1];

        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int i = lengthA, j = lengthB;

        while (i > 0 && j > 0) {
            if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) {
                stringBuilder.append(wordA.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
