package 모든문제.level2.복습문제;

import java.io.*;
import java.util.*;

public class 프로세스 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int processSize = Integer.parseInt(stringTokenizer.nextToken());
        int location = Integer.parseInt(stringTokenizer.nextToken());

        int[] priorities = new int[processSize];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < processSize; i++) priorities[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int processNumber = getProcessExecutionRank(priorities, location);
        bufferedWriter.write(String.valueOf(processNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getProcessExecutionRank(int[] priorities, int location) {
        int executionOrder = 0;

        Deque<Process> processQueue = new LinkedList<>();
        PriorityQueue<Integer> sortedPriorityProcess = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            processQueue.offerLast(new Process(priorities[i], i));
            sortedPriorityProcess.offer(priorities[i]);
        }

        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.peekFirst();
            int highestPriority = sortedPriorityProcess.peek();

            if (currentProcess.priority == highestPriority) {
                processQueue.pollFirst();
                sortedPriorityProcess.poll();
                executionOrder++;
                if (currentProcess.originalLocation == location) return executionOrder;
            } else {
                processQueue.pollFirst();
                processQueue.offerLast(currentProcess);
            }
        }

        return -1;
    }

    private record Process(
            int priority,
            int originalLocation
    ) {
    }
}
