package baekjoon.단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 요세푸스문제0 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Integer> josephusDeque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            josephusDeque.offerLast(i);
        }

        bufferedWriter.write("<");

        while (josephusDeque.size() > 1) {
            // 현재 덱의 가장 앞에 있는 사람을 K-1번만큼 뒤로 이동시키는 작업이다.
            for (int i = 0; i < K - 1; i++) {
                int person = josephusDeque.pollFirst();
                josephusDeque.offerLast(person);
            }
            bufferedWriter.write(josephusDeque.pollFirst() + ", ");
        }

        bufferedWriter.write(josephusDeque.pollFirst() + ">");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
