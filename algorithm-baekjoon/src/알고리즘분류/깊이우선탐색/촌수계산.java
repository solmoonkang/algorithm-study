package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;
    private static int degreeOfKinship = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int person1 = Integer.parseInt(stringTokenizer.nextToken());
        int person2 = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        M = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentPerson = Integer.parseInt(stringTokenizer.nextToken());
            int childPerson = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[parentPerson].add(childPerson);
            arrayLists[childPerson].add(parentPerson);
        }

        DFS(person1, person2, 0);

        bufferedWriter.write(String.valueOf(degreeOfKinship));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int current, int target, int count) {
        if (current == target) {
            degreeOfKinship = count;
            return;
        }

        visited[current] = true;

        for (int next : arrayLists[current]) {
            if (!visited[next]) {
                DFS(next, target, count + 1);
                if (degreeOfKinship != -1) return;
            }
        }

        visited[current] = false;
    }
}
