package 모든문제.level2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 타겟넘버 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int target = Integer.parseInt(bufferedReader.readLine());

        int targetNumberWays = generateTargetNumber(numbers, target);
        bufferedWriter.write(String.valueOf(targetNumberWays));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateTargetNumber(int[] numbers, int target) {
        int dfs = DFS(numbers, 0, 0, target);
        int bfs = BFS(numbers, target);

        return dfs;
    }

    private static int DFS(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) return sum == target ? 1 : 0;

        int plus = DFS(numbers, index + 1, sum + numbers[index], target);
        int minus = DFS(numbers, index + 1, sum - numbers[index], target);

        return plus + minus;
    }

    private static int BFS(int[] numbers, int target) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{0, 0});

        int count = 0;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int index = current[0];
            int sum = current[1];

            if (index == numbers.length) {
                if (sum == target) count++;
            } else {
                searchDeque.offerLast(new int[]{index + 1, sum + numbers[index]});
                searchDeque.offerLast(new int[]{index + 1, sum - numbers[index]});
            }
        }

        return count;
    }
}
