package baekjoon.알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 진법변환_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        String baseBNumber = Integer.toString(N, B).toUpperCase();
        bufferedWriter.write(baseBNumber);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
