package baekjoon.단계문제.문자열;

import java.io.*;

public class 단어길이재기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write(String.valueOf(bufferedReader.readLine().length()));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
