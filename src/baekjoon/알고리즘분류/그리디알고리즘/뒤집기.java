package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;

public class 뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        // 연속된 그룹 수를 세기 위한 변수
        int requiredActionNumber = 0;
        // 첫 번째 문자 저장
        char previousCharacter = S.charAt(0);

        for (int i = 1; i < S.length(); i++) {
            char currentCharacter = S.charAt(i);
            if (currentCharacter != previousCharacter) {
                requiredActionNumber++;
                previousCharacter = currentCharacter;
            }
        }

        // 마지막 그룹을 포함해야 하므로 requiredActionNumber++
        requiredActionNumber++;
        // 0과 1의 그룹 수를 카운트
        int minRequiredActionNumber = requiredActionNumber / 2;
        bufferedWriter.write(String.valueOf(minRequiredActionNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
