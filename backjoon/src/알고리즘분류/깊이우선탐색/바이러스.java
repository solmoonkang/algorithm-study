package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {

    static int computerNumber, connectionNumber;
    static boolean[] visited;
    static List<Integer>[] arrayLists;

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
            int key = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[key].add(value);
            arrayLists[value].add(key);
        }

        int infectedNumber = DFS(1);

        bufferedWriter.write(String.valueOf(infectedNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int DFS(int start) {
        visited[start] = true;
        int infectedNumber = 0;

        for (int adjacency : arrayLists[start]) {
            if (!visited[adjacency]) infectedNumber += 1 + DFS(adjacency);
        }

        return infectedNumber;
    }
}
