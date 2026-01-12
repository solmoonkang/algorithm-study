package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] isRemoved = new boolean[N + 1];
        int[] sequences = new int[N - 1];

        for (int i = 2; i <= N; i++) {
            sequences[i - 2] = i;
        }

        int count = 0;

        while (true) {
            int P = 0;
            for (int i = 0; i < sequences.length; i++) {
                // 아직 지워지지 않은 수 중 가장 작은 수를 찾는다.
                if (!isRemoved[i]) {
                    P = sequences[i];
                    break;
                }
            }

            for (int i = 0; i < sequences.length; i++) {
                // 현재 찾은 수 P의 배수들을 지운다.
                if (!isRemoved[i] && sequences[i] % P == 0) {
                    isRemoved[i] = true;
                    count++;

                    if (count == K) {
                        bufferedWriter.write(String.valueOf(sequences[i]));
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedReader.close();
                        return;
                    }
                }
            }
        }
    }
}
