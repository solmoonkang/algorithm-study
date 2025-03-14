package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 텀프로젝트 {

    /**
     * DFS를 사용하는 이유
     * 한 학생은 단 한 명만 선택하므로 그래프에서 각 노드의 out-degree가 1인 형태이다.
     * 방문한 학생을 추적하면서 사이클을 감지할 수 있다.
     * 사이클을 이루는 학생들을 체크하여 팀원으로 포함하고, 팀을 이루지 못한 학생들을 구할 수 있다.
     */
    private static int N;               // 학생 수
    private static int[] selected;      // 선택된 학생
    private static boolean[] visited;   // 방문 여부
    private static boolean[] finished;  // 탐색 완료 여부
    private static int count;           // 팀에 속한 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(bufferedReader.readLine());
            selected = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                selected[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) DFS(i);
            }

            bufferedWriter.write((N - count) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node) {
        // 현재 노드를 방문 처리한다.
        visited[node] = true;

        // 다음 노드로 선택한 학생을 고른다.
        int nextNode = selected[node];

        // 아직 방문하지 않은 학생이면 DFS로 탐색한다.
        if (!visited[nextNode]) {
            DFS(nextNode);

        // 방문은 했지만, 탐색이 끝나지 않은 경우로 사이클이 발생한 경우이다.
        } else if (!finished[nextNode]) {
            int tempNode = nextNode;

            // 사이클을 이루는 학생 수를 카운트한다.
            while (tempNode != node) {
                count++;
                tempNode = selected[tempNode];
            }
            // 마지막 노드를 포함시키기 위해 카운트를 증가시킨다.
            count++;
        }

        // DFS 탐색 완료를 표시한다.
        finished[node] = true;
    }
}
