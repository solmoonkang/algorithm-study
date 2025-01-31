package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    private static final int FRIENDSHIP_EXISTS = 1;
    private static final int FRIENDSHIP_NOT_EXISTS = 0;

    private static List<List<Integer>> friendshipGraph;
    private static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        friendshipGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) friendshipGraph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            friendshipGraph.get(parentNode).add(childNode);
            friendshipGraph.get(childNode).add(parentNode);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            DFS(i, visited, 0);
            if (found) break;
        }

        bufferedWriter.write(found ? String.valueOf(FRIENDSHIP_EXISTS) : String.valueOf(FRIENDSHIP_NOT_EXISTS));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int currentNode, boolean[] visited, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }

        visited[currentNode] = true;

        for (int friend : friendshipGraph.get(currentNode)) {
            if (!visited[friend]) DFS(friend, visited, depth + 1);
        }

        visited[currentNode] = false;
    }
}
