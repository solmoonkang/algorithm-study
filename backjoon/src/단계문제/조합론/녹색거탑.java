package 단계문제.조합론;

import java.io.*;

public class 녹색거탑 {

    // TODO: DFS의 개념과 연습문제들을 충분히 풀어보고 다시 한 번 풀어보자.

    public static int count = 0;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            DFS(0, i);
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void DFS(int layer, int block) {
        if (layer == N - 1) {
            count++;
            return;
        }

        if (block - 1 >= 0) DFS(layer + 1, block - 1);
        DFS(layer + 1, block);
        if (block + 1 < N) DFS(layer + 1, block + 1);
    }
}
