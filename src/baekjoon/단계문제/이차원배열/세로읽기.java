package baekjoon.단계문제.이차원배열;

import java.io.*;

public class 세로읽기 {

    private static final int N = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = new String[N];

        for (int i = 0; i < words.length; i++) {
            words[i] = bufferedReader.readLine();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < N; j++) {
                if (i < words[j].length()) stringBuilder.append(words[j].charAt(i));
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
