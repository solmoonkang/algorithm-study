package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class 단어뒤집기 {

    // TODO: 다시 한 번 더 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        // 현재 읽고 있는 단어를 저장한다.
        StringBuilder currentToken = new StringBuilder();
        // 최종 결과 문자열을 저장한다.
        StringBuilder reverseSentence = new StringBuilder();
        // 현재 문자가 태그 안에 있는지를 나타내는 플래그이다.
        boolean inTag = false;

        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);

            // < 문자를 발견하면
            if (currentChar == '<') {
                // 일반 문자가 있었다면,
                if (!currentToken.isEmpty()) {
                    // 이를 뒤집어서 최종 결과 문자열에 추가한다.
                    reverseSentence.append(currentToken.reverse());
                    currentToken.setLength(0);
                }
                // 햔재 문자가 태그 내부에 있음을 나타낸다.
                inTag = true;
                reverseSentence.append(currentChar);

            // > 문자를 발견하면
            } else if (currentChar == '>') {
                // 태그가 끝났음을 나타낸다.
                inTag = false;
                reverseSentence.append(currentChar);

            // 현재 문자가 태그 내부에 있다면
            } else if (inTag) {
                // 그 문자를 그대로 최종 결과 문자열에 추가한다.
                reverseSentence.append(currentChar);

            // 공백을 발견하면
            } else if (currentChar == ' ') {
                // 현재 문자열이 비어있지 않다면
                if (!currentToken.isEmpty()) {
                    // 이를 뒤집어서 최종 결과 문자열에 추가한다.
                    reverseSentence.append(currentToken.reverse());
                    currentToken.setLength(0);
                }
                // 공백을 결과 문자열에 추가한다.
                reverseSentence.append(' ');

            // 태그나 공백이 아니면
            } else {
                // 현재 문자를 현재 문자열에 추가한다.
                currentToken.append(currentChar);
            }
        }

        // 문자열을 모두 순회한 후에도 현재 문자열에 남아 있는 단어가 있다면 이를 뒤집어서 최종 결과 문자열에 추가한다.
        if (!currentToken.isEmpty()) reverseSentence.append(currentToken.reverse());
        bufferedWriter.write(reverseSentence.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
