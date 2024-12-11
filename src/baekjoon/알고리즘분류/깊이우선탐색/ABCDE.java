package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;
    private static boolean isExist = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N];
        arrayLists = new List[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int personA = Integer.parseInt(stringTokenizer.nextToken());
            int personB = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[personA].add(personB);
            arrayLists[personB].add(personA);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, 0, 0);
            if (isExist) break;
        }

        bufferedWriter.write(isExist ? "1" : "0");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int currentNode, int targetNode, int depth) {
        if (depth == 4) {
            isExist = true;
            return;
        }

        visited[currentNode] = true;

        for (int nextNode : arrayLists[currentNode]) {
            if (!visited[nextNode]) {
                DFS(nextNode, targetNode, depth + 1);
                if (isExist) return;
            }
        }

        visited[currentNode] = false;
    }
}
