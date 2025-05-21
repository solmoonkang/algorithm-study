package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 프로세스 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] priorities = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) priorities[i] = Integer.parseInt(stringTokenizer.nextToken());

        int location = Integer.parseInt(bufferedReader.readLine());

        int processNumber = getExecuteProcessNumberWithStream(priorities, location);
        bufferedWriter.write(String.valueOf(processNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private record Process(int index, int priority) {}

    private static int getExecuteProcessNumberWithForEach(int[] priorities, int location) {
        Deque<Process> priorityQueue = new ArrayDeque<>();

        for (int index = 0; index < priorities.length; index++) {
            priorityQueue.offerLast(new Process(index, priorities[index]));
        }

        int order = 0;

        while (!priorityQueue.isEmpty()) {
            Process currentProcess = priorityQueue.pollFirst();

            boolean hasHigher = false;

            for (Process process : priorityQueue) {
                if (process.priority() > currentProcess.priority()) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                priorityQueue.offerLast(currentProcess);
            } else {
                order++;
                if (currentProcess.index() == location) return order;
            }
        }

        return 0;
    }

    private static int getExecuteProcessNumberWithStream(int[] priorities, int location) {
        Deque<Process> priorityQueue = new ArrayDeque<>();

        for (int index = 0; index < priorities.length; index++) {
            priorityQueue.offerLast(new Process(index, priorities[index]));
        }

        int order = 0;

        while (!priorityQueue.isEmpty()) {
            Process currentProcess = priorityQueue.pollFirst();

            if (priorityQueue.stream().anyMatch(process -> process.priority > currentProcess.priority)) {
                priorityQueue.offerLast(currentProcess);
            } else {
                order++;
                if (currentProcess.index == location) return order;
            }
        }

        return 0;
    }
}
