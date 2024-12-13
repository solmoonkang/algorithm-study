package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 그대로출력하기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word;
        StringBuilder stringBuilder = new StringBuilder();

        while ((word = bufferedReader.readLine()) != null) {
            stringBuilder.append(word).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
