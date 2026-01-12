package 알고리즘분류.문자열;

import java.io.*;

public class 단어뒤집기_2 {

    private static StringBuilder sentence = new StringBuilder();
    private static StringBuilder currentWord = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        boolean inTag = false;

        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);

            if (currentChar == '<') {
                if (!currentWord.isEmpty()) {
                    sentence.append(currentWord.reverse());
                    currentWord.setLength(0);
                }
                inTag = true;
                sentence.append(currentChar);
            } else if (currentChar == '>') {
                inTag = false;
                sentence.append(currentChar);
            } else if (inTag) {
                sentence.append(currentChar);
            } else if (currentChar == ' ') {
                if (!currentWord.isEmpty()) {
                    sentence.append(currentWord.reverse());
                    currentWord.setLength(0);
                }
                sentence.append(' ');
            } else {
                currentWord.append(currentChar);
            }
        }

        if (!currentWord.isEmpty()) sentence.append(currentWord.reverse());
        bufferedWriter.write(sentence.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
