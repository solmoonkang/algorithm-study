package 모든문제.level1;

import java.io.*;
import java.util.*;

public class 둘만의암호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String sentence = stringTokenizer.nextToken();
        String skip = stringTokenizer.nextToken();
        int index = Integer.parseInt(stringTokenizer.nextToken());

        String password = encryptAggravate(sentence, skip, index);
        bufferedWriter.write(password);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String encryptAggravate(String sentence, String skip, int index) {
        // sentence의 각 문자의 index만큼 뒤에 존재하는 알파벳 단, skip에 포함된 문자라면 건너뛰고, z를 넘어간다면 다시 a로 순환
        StringBuilder password = new StringBuilder();

        // sentence의 각 문자를 순회
        for (int i = 0; i < sentence.length(); i++) {
            char currentAlphabet = sentence.charAt(i);
            // index만큼 이동했는지 카운트할 변수
            int count = 0;

            // index만큼의 횟수를 채울 때까지 반복
            while (count < index) {
                // 현재 알파벳을 다음 알파벳으로 1칸 이동
                currentAlphabet++;

                // z를 넘어갈 경우 a로 순환
                if (currentAlphabet > 'z') currentAlphabet = 'a';

                // skip 문자열에 현재 알파벳이 포함되어 있다면 count를 증가시키지 않고 건너뜀
                if (skip.contains(String.valueOf(currentAlphabet))) continue;

                // skip 문자가 아니라면 index 카운트를 1 증가
                count++;
            }

            password.append(currentAlphabet);
        }

        return password.toString();
    }
}
