package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 바이러스 {

    private static int computerNumber, connectionNumber;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;

    private static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        computerNumber = Integer.parseInt(bufferedReader.readLine());
        connectionNumber = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new List[computerNumber + 1];

        for (int i = 1; i <= computerNumber; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectionNumber; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int computer1 = Integer.parseInt(stringTokenizer.nextToken());
            int computer2 = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[computer1].add(computer2);
            arrayLists[computer2].add(computer1);
        }

        int wormVirus = BFS(1);

        bufferedWriter.write(String.valueOf(wormVirus));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        deque.offerLast(start);

        visited = new boolean[computerNumber + 1];
        visited[start] = true;

        int infectedCount = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int currentComputer = deque.pollFirst();
                infectedCount++;

                for (int neighbor : arrayLists[currentComputer]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        deque.offerLast(neighbor);
                    }
                }
            }
        }

        // 1번 컴퓨터는 제외하고 반환한다.
        return infectedCount - 1;
    }
}
