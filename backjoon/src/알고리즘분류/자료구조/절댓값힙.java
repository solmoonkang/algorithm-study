package 알고리즘분류.자료구조;

import java.io.*;
import java.util.PriorityQueue;

public class 절댓값힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> absoluteValueHeap = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) return a - b;     // 절댓값이 같으면 원래 수의 부호로 정렬
                    return absA - absB;                 // 절댓값을 기준으로 정렬
                }
        );
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) {
                if (absoluteValueHeap.isEmpty()) stringBuilder.append("0").append("\n");
                else stringBuilder.append(absoluteValueHeap.poll()).append("\n");
            } else {
                absoluteValueHeap.add(number);
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
