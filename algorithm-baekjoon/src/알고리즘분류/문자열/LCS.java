package 알고리즘분류.문자열;

import java.io.*;

public class LCS {

    /**
     * 동적 계획법을 사용한 이유
     * <p>
     * LCS를 구할 때, 같은 부분 수열을 여러 번 계산하게 된다. DP를 사용하면 한 번 계산한 값을 저장해두고, 필요할 때 재사용함으로써 불필요한 계산을 줄인다.
     * 단순히 모든 부분 수열을 나열하여 비교하는 비효율적인 방법에 비해 훨씬 더 빠른 시간 복잡도를 갖는다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String wordX = bufferedReader.readLine();
        String wordY = bufferedReader.readLine();

        int LCSLength = findLongestCommonSubsequence(wordX, wordY);

        bufferedWriter.write(String.valueOf(LCSLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findLongestCommonSubsequence(String wordX, String wordY) {
        int lenX = wordX.length();
        int lenY = wordY.length();

        int[][] dynamicArray = new int[lenX + 1][lenY + 1];

        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                // wordX의 i번째 문자와 wordY의 j번째 문자가 같으면, 두 문자열의 LCS는 이전의 LCS에 1을 더한 것이 된다.
                // 즉, 두 문자를 포함한 LCS의 길이는 그 이전의 LCS 길이에 1을 더한 것이다.
                if (wordX.charAt(i - 1) == wordY.charAt(j - 1)) dynamicArray[i][j] = dynamicArray[i - 1][j - 1] + 1;

                // wordX의 i번째 문자와 wordY의 j번째 문자가 다르면, 두 경우를 비교하여 더 긴 LCS를 선택한다.
                // 즉, wordX의 i번째 문자를 포함하지 않거나 wordY의 j번째 문자를 포함하지 않는 두 경우 중 더 긴 LCS를 선택한다.
                else dynamicArray[i][j] = Math.max(dynamicArray[i - 1][j], dynamicArray[i][j - 1]);
            }
        }

        return dynamicArray[lenX][lenY];
    }
}
