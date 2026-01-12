package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class 뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int countOnes = 0;
        int countZeros = 0;

        // 첫 문자가 1이면 T로 초기화한다.
        boolean inGroupOfOnes = S.charAt(0) == '1';

        // 첫 번째 문자를 기준으로 초기 카운트를 설정한다.
        if (inGroupOfOnes) countOnes++;
        else countZeros++;

        for (int i = 1; i < S.length(); i++) {
            char currentNumber = S.charAt(i);

            // 문자열이 1인 경우
            if (currentNumber == '1') {
                // 이전 그룹이 0이면 1의 그룹을 발견한 것이므로 카운트를 증가한다.
                if (!inGroupOfOnes) {
                    countOnes++;
                    inGroupOfOnes = true;
                }

            // 문자열이 0인 경우
            } else if (currentNumber == '0') {
                // 이전 그룹이 1이면 0의 그룹을 발견한 것이므로 카운트를 증가한다.
                if (inGroupOfOnes) {
                    countZeros++;
                    inGroupOfOnes = false;
                }
            }
        }

        int minCount = Math.min(countZeros, countOnes);
        bufferedWriter.write(String.valueOf(minCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
