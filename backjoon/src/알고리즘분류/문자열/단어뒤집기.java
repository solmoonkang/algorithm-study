package 알고리즘분류.문자열;

import java.io.*;

public class 단어뒤집기 {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String sentence = bufferedReader.readLine();
            reverseSentence(sentence);
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void reverseSentence(String sentence) {
        String[] spaceSplitSentence = sentence.split(" ");

        for (String currentSentence : spaceSplitSentence) {
            for (int j = currentSentence.length() - 1; j >= 0; j--) {
                stringBuilder.append(currentSentence.charAt(j));
            }
            stringBuilder.append(" ");
        }

        stringBuilder.append("\n");
    }
}
