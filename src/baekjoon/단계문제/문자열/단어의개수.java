package baekjoon.단계문제.문자열;

import java.io.*;

public class 단어의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine().trim();

        if (input.isEmpty()) bufferedWriter.write("0");
        else bufferedWriter.write(String.valueOf(input.split(" ").length));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
