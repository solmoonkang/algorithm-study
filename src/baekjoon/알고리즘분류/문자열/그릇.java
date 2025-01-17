package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 그릇 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] bowls = bufferedReader.readLine().toCharArray();

        int bowlHeight = 10;
        for (int i = 1; i < bowls.length; i++) {
            if (bowls[i] == bowls[i - 1]) bowlHeight += 5;
            else bowlHeight += 10;
        }

        bufferedWriter.write(String.valueOf(bowlHeight));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
