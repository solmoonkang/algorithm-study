package 알고리즘고득점KIT.복습문제.깊이_너비우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 네트워크 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] computers = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                computers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        bufferedReader.close();

        int networkCount = findNetworkNumber(N, computers);
        bufferedWriter.write(String.valueOf(networkCount));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findNetworkNumber(int N, int[][] computers) {
        boolean[] visited = new boolean[N];
        int networkCount = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                networkCount++;
                generateNetwork(N, computers, visited, i);
            }
        }

        return networkCount;
    }

    private static void generateNetwork(int N, int[][] computers, boolean[] visited, int startNode) {
        if (visited[startNode]) return;
        visited[startNode] = true;

        for (int nextNode = 0; nextNode < N; nextNode++) {
            if (computers[startNode][nextNode] == 1 && !visited[nextNode]) {
                generateNetwork(N, computers, visited, nextNode);
            }
        }
    }
}
