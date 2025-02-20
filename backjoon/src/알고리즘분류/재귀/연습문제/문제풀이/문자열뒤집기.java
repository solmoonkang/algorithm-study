package 알고리즘분류.재귀.연습문제.문제풀이;

import java.io.*;

public class 문자열뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        StringBuilder reverseBuilder = new StringBuilder();

        generateReverseWord(word, reverseBuilder);

        bufferedWriter.write(reverseBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateReverseWord(String word, StringBuilder reverseBuilder) {
        if (word.isEmpty()) return;
        // 문자열의 마지막 문자를 가져온다.
        reverseBuilder.append(word.charAt(word.length() - 1));
        // 재귀 함수(마지막 문자를 제외한 문자열, StringBuilder) 방식으로 재귀 호출을 진행한다.
        generateReverseWord(word.substring(0, word.length() - 1), reverseBuilder);
    }
}
