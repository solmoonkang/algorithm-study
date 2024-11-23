package baekjoon.알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {

    private static int computerNumber, connectionNumber;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        computerNumber = Integer.parseInt(bufferedReader.readLine());
        connectionNumber = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[computerNumber + 1];
        arrayLists = new List[computerNumber + 1];
        for (int i = 1; i <= computerNumber; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectionNumber; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[node1].add(node2);
            arrayLists[node2].add(node1);
        }

        int infectedWormVirusComputerNumber = DFS(1);

        bufferedWriter.write(String.valueOf(infectedWormVirusComputerNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int DFS(int start) {
        visited[start] = true;

        int infectedNumber = 0;

        for (int neighbor : arrayLists[start]) {
            // 현재 탐색하고 있는 이웃 노드가 아직 방문되지 않았는지를 확인한다.
            // infectedNumber에 1을 더하는 것은 현재 방문한 노드를 감연된 노드로 카운트한다.
            if (!visited[neighbor]) infectedNumber += 1 + DFS(neighbor);
        }

        return infectedNumber;
    }
}
