package baekjoon.알고리즘분류.자료구조;

import java.io.*;
import java.util.PriorityQueue;

public class 최대힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(bufferedReader.readLine());

            if (X == 0) {
                if (maxHeap.isEmpty()) stringBuilder.append("0").append("\n");
                else stringBuilder.append(maxHeap.poll()).append("\n");
            } else {
                maxHeap.add(X);
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
