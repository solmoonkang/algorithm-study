package 모든문제.level1;

import java.io.*;

public class 문자열을정수로바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        int number = convertStringToInteger(sentence);
        bufferedWriter.write(String.valueOf(number));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int convertStringToInteger(String sentence) {
        return Integer.parseInt(sentence);
    }
}
