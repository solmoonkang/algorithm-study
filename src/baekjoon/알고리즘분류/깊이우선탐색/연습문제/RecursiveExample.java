package baekjoon.알고리즘분류.깊이우선탐색.연습문제;

import java.util.ArrayList;

public class RecursiveExample {

    public void DFS(int start, boolean[] visited, ArrayList<Integer>[] arrayLists, ArrayList<Integer> procedure) {
        // 방문 배열이 true면 return
        if (visited[start]) return;

        // v 노드에 방문했으므로, 해당 방문배열을 true로 바꿔주고 탐색순서 리스트에 추가해줌
        visited[start] = true;
        procedure.add(start);

        // 해당 노드의 ArrayList(인접노드)를 모두 돌며 방문배열이 false인 경우에
        for (int node : arrayLists[start]) {
            // 해당 노드에 대해서 DFS를 다시 실행한다.
            if (!visited[node]) DFS(node, visited, arrayLists, procedure);
        }
    }
}
