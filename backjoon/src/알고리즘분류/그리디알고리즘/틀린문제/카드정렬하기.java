package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.PriorityQueue;

public class 카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) priorityQueue.add(Integer.parseInt(bufferedReader.readLine()));

        int minCompareFrequency = 0;

        while (priorityQueue.size() > 1) {
            int firstElement = priorityQueue.poll();
            int secondElement = priorityQueue.poll();

            int combined = firstElement + secondElement;
            minCompareFrequency += combined;
            priorityQueue.add(combined);
        }

        bufferedWriter.write(String.valueOf(minCompareFrequency));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
