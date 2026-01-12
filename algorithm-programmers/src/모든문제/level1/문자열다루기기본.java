package 모든문제.level1;

import java.io.*;

public class 문자열다루기기본 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        boolean isNumber = isValidNumericString(sentence);
        bufferedWriter.write(String.valueOf(isNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isValidNumericString(String sentence) {
        if (sentence.length() != 4 && sentence.length() != 6) return false;

        for (char element : sentence.toCharArray()) {
            if (!Character.isDigit(element)) return false;
        }

        return true;
    }
}
