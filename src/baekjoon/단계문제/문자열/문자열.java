package baekjoon.단계문제.문자열;

import java.io.*;

public class 문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String alphabet = bufferedReader.readLine();
            bufferedWriter.write(alphabet.charAt(0) + "" + alphabet.charAt(alphabet.length() - 1));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
