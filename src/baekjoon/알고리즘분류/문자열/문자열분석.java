package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 문자열분석 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence;
        while ((sentence = bufferedReader.readLine()) != null) {
            int lowerCase = 0, upperCase = 0, number = 0, emptySpace = 0;

            for (char c : sentence.toCharArray()) {
                if (Character.isLowerCase(c)) lowerCase++;
                if (Character.isUpperCase(c)) upperCase++;
                if (Character.isDigit(c)) number++;
                if (c == ' ') emptySpace++;
            }

            bufferedWriter.write(lowerCase + " " + upperCase + " " + number + " " + emptySpace + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
