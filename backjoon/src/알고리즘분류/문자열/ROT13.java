package 알고리즘분류.문자열;

import java.io.*;

public class ROT13 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        bufferedWriter.write(encryptWithROT13(word));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String encryptWithROT13(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            // 대문자 처리
            if (c >= 'A' && c <= 'Z') stringBuilder.append((char) ((c - 'A' + 13) % 26 + 'A'));
            // 소문자 처리
            else if (c >= 'a' && c <= 'z') stringBuilder.append((char) ((c - 'a' + 13) % 26 + 'a'));
            // 그 외 알파벳이 아닌 문자는 그대로 추가
            else stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
