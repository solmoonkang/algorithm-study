package 알고리즘분류.구현;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(bufferedReader.readLine());

        while (test-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[] priorities = new int[N];

            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                priorities[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int printOrder = getPrintOrder(N, M, priorities);
            bufferedWriter.write(printOrder + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getPrintOrder(int documentNumber, int targetIndex, int[] priorities) {
        Deque<int[]> searchDeque = new LinkedList<>();

        for (int i = 0; i < documentNumber; i++) {
            searchDeque.offerLast(new int[]{i, priorities[i]});
        }

        int order = 0;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int currentIndex = current[0];
            int currentPriority = current[1];

            boolean hasHigher = false;

            for (int[] item : searchDeque) {
                if (item[1] > currentPriority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                searchDeque.offerLast(current);
            } else {
                order++;
                if (currentIndex == targetIndex) return order;
            }
        }

        return -1;
    }
}
