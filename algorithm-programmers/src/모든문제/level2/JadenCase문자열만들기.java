package 모든문제.level2;

import java.io.*;

public class JadenCase문자열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        String jadenCaseSentence = generateJadenCaseSentence(input);
        bufferedWriter.write(jadenCaseSentence);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String generateJadenCaseSentence(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] sentences = input.split(" ");

        for (String sentence : sentences) {
            if (Character.isLetter(sentence.charAt(0))) stringBuilder.append(Character.toUpperCase(sentence.charAt(0)));
            else stringBuilder.append(sentence.charAt(0));

            for (int i = 1; i < sentence.length(); i++) {
                stringBuilder.append(Character.toLowerCase(sentence.charAt(i)));
            }
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    private static String generateJadenCaseSentenceWithCharacter(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isStart = true;

        for (char alphabet : input.toCharArray()) {
            if (alphabet == ' ') {
                stringBuilder.append(alphabet);
                isStart = true;
            } else {
                if (isStart) {
                    stringBuilder.append(Character.toUpperCase(alphabet));
                    isStart = false;
                } else {
                    stringBuilder.append(Character.toLowerCase(alphabet));
                }
            }
        }

        return stringBuilder.toString();
    }
}
