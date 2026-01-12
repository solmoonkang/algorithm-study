package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        int LCSLength = longestCommonSubsequenceLength(word1, word2);
        bufferedWriter.write(String.valueOf(LCSLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // LCS는 두 수열에서 공통으로 나타나는 부분 수열 중에서 가장 긴 것을 의미한다. 부분 수열은 원래 수열에서 일부 문자를 삭제하더라도 순서가 유지되는 수열을 의미한다.
    private static int longestCommonSubsequenceLength(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 현재 두 문자열의 i-1번째 문자와 j-1번째 문자가 같은지를 확인한다.
                // 만약 같다면, LCS의 길이를 증가시킬 수 있다. 이유는 두 문자가 LCS의 일부로 포함될 수 있기 때문이다.
                // LCS의 길이는 이전까지의 LCS 길이(dp[i - 1][j - 1])에 1을 더한 값이 된다.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                // 두 문자가 다를 때 실행된다. 즉, 현재 문자를 LCS에 포함할 수 없는 경우이다.
                // 이때는 두 가지 경우를 비교하여 LCS의 길이를 결정한다.
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
