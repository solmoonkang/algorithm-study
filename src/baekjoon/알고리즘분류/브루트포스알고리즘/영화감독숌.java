package baekjoon.알고리즘분류.브루트포스알고리즘;

import java.io.*;

public class 영화감독숌 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int movieTitle = 0;
        int number = 666;

        while (true) {
            if (String.valueOf(number).contains("666")) movieTitle++;

            if (movieTitle == N) {
                bufferedWriter.write(String.valueOf(number));
                break;
            }

            number++;
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
