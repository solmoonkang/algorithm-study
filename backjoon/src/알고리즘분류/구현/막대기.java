package 알고리즘분류.구현;

import java.io.*;

public class 막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sticksHeight = new int[N];
        for (int i = 0; i < N; i++) sticksHeight[i] = Integer.parseInt(bufferedReader.readLine());

        int maxStickHeight = Integer.MIN_VALUE;
        int sticksNumber = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (sticksHeight[i] > maxStickHeight) {
                maxStickHeight = sticksHeight[i];
                sticksNumber++;
            }
        }

        bufferedWriter.write(String.valueOf(sticksNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
