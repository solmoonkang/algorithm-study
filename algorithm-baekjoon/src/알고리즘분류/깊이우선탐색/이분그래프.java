package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이분그래프 {

    private static int V, E;
    private static int[] colors;
    private static List<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            V = Integer.parseInt(stringTokenizer.nextToken());
            E = Integer.parseInt(stringTokenizer.nextToken());

            colors = new int[V + 1];
            arrayLists = new List[V + 1];

            for (int j = 1; j <= V; j++) {
                colors[j] = -1;
                arrayLists[j] = new ArrayList<>();
            }

            for (int k = 0; k < E; k++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int U = Integer.parseInt(stringTokenizer.nextToken());
                int V = Integer.parseInt(stringTokenizer.nextToken());

                arrayLists[U].add(V);
                arrayLists[V].add(U);
            }

            boolean isBipartite = true;

            for (int j = 1; j <= V; j++) {
                if (colors[j] == -1) {
                    if (!DFS(j, 0)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            bufferedWriter.write(isBipartite ? "YES\n" : "NO\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean DFS(int node, int color) {
        colors[node] = color;

        for (int neighbor : arrayLists[node]) {
            if (colors[neighbor] == -1) {
                if (!DFS(neighbor, 1 - color)) return false;
            } else if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }
}
