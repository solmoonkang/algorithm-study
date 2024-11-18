package baekjoon.단계문제.심화;

import java.io.*;

public class 크로아티아알파벳 {

    private static String[] croatianAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        int alphabetCount = 0;

        int index = 0;
        while (index < word.length()) {
            boolean isCroatianAlphabetFound = false;

            for (String alphabet : croatianAlphabet) {
                if (word.startsWith(alphabet, index)) {
                    alphabetCount++;
                    index += alphabet.length();
                    isCroatianAlphabetFound = true;
                    break;
                }
            }

            if (!isCroatianAlphabetFound) {
                alphabetCount++;
                index++;
            }
        }

        bufferedWriter.write(String.valueOf(alphabetCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
