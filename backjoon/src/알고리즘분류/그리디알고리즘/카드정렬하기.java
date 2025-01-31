package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.PriorityQueue;

public class 카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) minimumHeap.add(Integer.parseInt(bufferedReader.readLine()));

        int totalComparisons = 0;
        while (minimumHeap.size() > 1) {
            int firstSmallestCardBundle = minimumHeap.poll(), secondSmallestCardBundle = minimumHeap.poll();
            int mergedCardBundle = firstSmallestCardBundle + secondSmallestCardBundle;

            totalComparisons += mergedCardBundle;
            minimumHeap.add(mergedCardBundle);
        }

        bufferedWriter.write(String.valueOf(totalComparisons));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
