package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 텀프로젝트 {

    private static int N;
    private static boolean[] visited;
    private static boolean[] inTeam;
    private static int[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bufferedReader.readLine());

            visited = new boolean[N + 1];
            inTeam = new boolean[N + 1];
            arrayLists = new int[N + 1];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= N; j++) {
                arrayLists[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int student = 1; student <= N; student++) {
                if (!visited[student]) DFS(student);
            }

            int count = 0;
            for (int student = 1; student <= N; student++) {
                if (!inTeam[student]) count++;
            }

            bufferedWriter.write(count + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int student) {
        visited[student] = true;
        int nextStudent = arrayLists[student];

        if (!visited[nextStudent]) {
            DFS(nextStudent);
        } else {
            if (nextStudent == student) {
                inTeam[student] = true;
            } else {
                int currentStudent = nextStudent;

                while (currentStudent != student) {
                    inTeam[currentStudent] = true;
                    currentStudent = arrayLists[currentStudent];
                }

                inTeam[student] = true;
            }
        }
    }
}
