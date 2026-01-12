package 알고리즘분류.문자열;

import java.io.*;

public class 모음의개수 {

    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String alphabetTerm = bufferedReader.readLine();

        int vowelsNumber = 0;
        for (int i = 0; i < alphabetTerm.length(); i++) {
            char currentAlphabet = alphabetTerm.charAt(i);

            for (char vowel : VOWELS) {
                if (currentAlphabet == vowel) vowelsNumber++;
            }
        }

        bufferedWriter.write(String.valueOf(vowelsNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
