package 모든문제.level1;

import java.io.*;

public class 가운데글자가져오기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        String middle = getMiddleSentence(sentence);
        bufferedWriter.write(middle);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getMiddleSentence(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();

        int middleIndex = sentence.length() / 2;
        if (sentence.length() % 2 == 0)
            stringBuilder.append(sentence.charAt(middleIndex - 1)).append(sentence.charAt(middleIndex));
        else stringBuilder.append(sentence.charAt(middleIndex));

        return stringBuilder.toString();
    }

    private static String anotherSolution(String sentence) {
        return sentence.substring((sentence.length() - 1) / 2, sentence.length() / 2 + 1);
    }
}
