package baekjoon.알고리즘분류.다이나믹프로그래밍.연습문제;

import java.io.*;

public class 최장공통부분수열 {

    /**
     * 문제 설명
     * 두 문자열이 주어졌을 때, 두 문자열의 최장 공통 부분 수열의 길이를 구하세요.
     */

    /**
     * 입력
     * str1 = "abcde"
     * str2 = "ace"
     * <p>
     * str1 = "abc"
     * str2 = "abc"
     * <p>
     * 출력
     * 3
     * 3
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        int LCS = getLongestCommonSubsequenceLengthTabulation(input1, input2);

        bufferedWriter.write(LCS + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getLongestCommonSubsequenceLengthTabulation(String input1, String input2) {
        int M = input1.length();
        int N = input2.length();

        int[][] dynamicArray = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) dynamicArray[i][j] = dynamicArray[i - 1][j - 1] + 1;
                else dynamicArray[i][j] = Math.max(dynamicArray[i - 1][j], dynamicArray[i][j - 1]);
            }
        }

        return dynamicArray[M][N];
    }
}
