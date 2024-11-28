package baekjoon.알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    private static int N;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;
    private static int[] unRootedTree;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        arrayLists = new List[N + 1];
        unRootedTree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[parentNode].add(childNode);
            arrayLists[childNode].add(parentNode);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            bufferedWriter.write(unRootedTree[i] + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int neighbor : arrayLists[start]) {
            if (!visited[neighbor]) {
                unRootedTree[neighbor] = start;
                DFS(neighbor);
            }
        }
    }
}
