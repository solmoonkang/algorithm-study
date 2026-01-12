package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 숫자변환하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int numberBFS = getNumberOfNumberConversionsWithBFS(X, Y, N);
        bufferedWriter.write("BFS = " + numberBFS);

        bufferedWriter.newLine();
        int numberDP = getNumberOfNumberConversionsWithDP(X, Y, N);
        bufferedWriter.write("DP = " + numberDP);

        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getNumberOfNumberConversionsWithBFS(int X, int Y, int N) {
        if (X == Y) return 0;

        Deque<int[]> searchDeque = new LinkedList<>();
        boolean[] visited = new boolean[Y + 1];

        searchDeque.add(new int[]{X, 0});
        visited[X] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int currentValue = current[0];
            int count = current[1];

            int nextValue1 = currentValue + N;
            if (nextValue1 == Y) return count + 1;
            if (nextValue1 < Y && !visited[nextValue1]) {
                visited[nextValue1] = true;
                searchDeque.offerLast(new int[]{nextValue1, count + 1});
            }

            int nextValue2 = currentValue * 2;
            if (nextValue2 == Y) return count + 1;
            if (nextValue2 < Y && !visited[nextValue2]) {
                visited[nextValue2] = true;
                searchDeque.offerLast(new int[]{nextValue2, count + 1});
            }

            int nextValue3 = currentValue * 3;
            if (nextValue3 == Y) return count + 1;
            if (nextValue3 < Y && !visited[nextValue3]) {
                visited[nextValue3] = true;
                searchDeque.offerLast(new int[]{nextValue3, count + 1});
            }
        }

        return -1;
    }

    private static int getNumberOfNumberConversionsWithDP(int X, int Y, int N) {
        if (X == Y) return 0;

        int[] DP = new int[Y + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[X] = 0;

        for (int i = X; i <= Y; i++) {
            if (DP[i] == Integer.MAX_VALUE) continue;
            if (i + N <= Y) DP[i + N] = Math.min(DP[i + N], DP[i] + 1);
            if (i * 2 <= Y) DP[i * 2] = Math.min(DP[i * 2], DP[i] + 1);
            if (i * 3 <= Y) DP[i * 3] = Math.min(DP[i * 3], DP[i] + 1);
        }

        return DP[Y] == Integer.MAX_VALUE ? -1 : DP[Y];
    }
}
