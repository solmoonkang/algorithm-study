package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기 {

    private static final List<Integer> arrayLists = new ArrayList<>();

    private static int N;
    private static boolean[] visited;       // DFS 탐색 중 방문 여부를 기록한다.
    private static boolean[] finished;      // 더 이상 탐색할 필요가 없는 즉, DFS 탐색이 끝났음을 표시한다.
    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        // 문제에서 주어진 첫 번째 줄의 숫자들이 1부터 시작하기 때문에 0-based index보다는 1-based index를 사용하는 게 코드의 직관성을 높일 수 있다.
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        graph = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = Integer.parseInt(bufferedReader.readLine());

        // 모든 노드에서 DFS를 수행한다.
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // DFS 탐색 중 다시 방문하면 사이클이 발생하므로 사이클을 저장하는 용도로 사용한다.
                List<Integer> cycleList = new ArrayList<>();
                DFS(i, cycleList);
            }
        }

        Collections.sort(arrayLists);
        bufferedWriter.write(arrayLists.size() + "\n");

        for (int number : arrayLists) bufferedWriter.write(number + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start, List<Integer> cycleList) {
        if (visited[start]) {
            // 이미 방문했고, 아직 사이클 검사가 끝나지 않은 경우만 사이클로 인정한다.
            if (!finished[start]) {
                int index = cycleList.indexOf(start);
                // 사이클에 해당하는 부분만 추가한다.
                arrayLists.addAll(cycleList.subList(index, cycleList.size()));
            }

            return;
        }

        visited[start] = true;          // 방문 체크
        cycleList.add(start);           // 현재 경로에 추가
        DFS(graph[start], cycleList);   // 다음 노드 방문
        finished[start] = true;         // 탐색 완료된 노드 표시
    }
}
