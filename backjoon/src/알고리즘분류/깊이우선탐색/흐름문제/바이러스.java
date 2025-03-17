package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {

    private static int computerNumber, networkConnection;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static int wormVirus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        computerNumber = Integer.parseInt(bufferedReader.readLine());
        networkConnection = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[computerNumber + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= computerNumber; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < networkConnection; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(parentNode).add(childNode);
            // 문제에서 네트워크 상에서 서로 연결되어 있다는 점으로 인해 단방향이 아닌 양방향으로 그래프를 구성한다.
            graph.get(childNode).add(parentNode);
        }

        DFS(1);

        bufferedWriter.write(String.valueOf(wormVirus));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int nextNode : graph.get(start)) {
            if (!visited[nextNode]) {
                // 기존은 DFS를 실행하고 그 이후에 wormVirus를 증가시켰지만, 이는 방문 후 스택이 돌아오는 시점에 카운트를 증가시키는 구조이다.
                // 따라서, 감염되는 순간 카운트가 증가되므로 정확한 값이 나올 수 있다. (DFS 탐색 순서에 관계없이 항상 올바른 값이 나온다.)
                wormVirus++;
                DFS(nextNode);
            }
        }
    }
}
