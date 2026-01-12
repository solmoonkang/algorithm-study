package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {

    private static int N;
    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayLists.add(new ArrayList<>());
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(stringTokenizer.nextToken());
            if (parent != -1) arrayLists.get(parent).add(i);
        }

        int removeNode = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N];
        DFS(removeNode);

        int leafCount = countLeafNodes();
        bufferedWriter.write(String.valueOf(leafCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int child : arrayLists.get(node)) {
            DFS(child);
        }
    }

    private static int countLeafNodes() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arrayLists.get(i).isEmpty()) count++;
        }

        return count;
    }
}
