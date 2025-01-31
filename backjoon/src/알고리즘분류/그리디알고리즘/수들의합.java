package 알고리즘분류.그리디알고리즘;

import java.io.*;

public class 수들의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(bufferedReader.readLine());

        long N = 0;
        long total = 0;

        while (total <= S) {
            N++;
            total += N;
        }

        bufferedWriter.write(String.valueOf(N - 1));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
