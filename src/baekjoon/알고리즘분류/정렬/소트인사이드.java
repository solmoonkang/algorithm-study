package baekjoon.알고리즘분류.정렬;

import java.io.*;
import java.util.Arrays;

public class 소트인사이드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] inputs = bufferedReader.readLine().toCharArray();

        Arrays.sort(inputs);

        bufferedWriter.write(new StringBuilder(new String(inputs)).reverse().toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
