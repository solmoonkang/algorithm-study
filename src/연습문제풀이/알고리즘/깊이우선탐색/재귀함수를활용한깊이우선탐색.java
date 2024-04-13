package 연습문제풀이.알고리즘.깊이우선탐색;

import java.util.ArrayList;
import java.util.List;

public class 재귀함수를활용한깊이우선탐색 {

    /**
     * 재귀 구현:
     * 현재 정점과 방문한 집합을 입력으로 사용하고, 아직 방문하지 않은 모든 인접 정점에 DFS를 적용한다.
     * 모든 정점을 방문하는 사례에서 재귀 구현은 유용하다.
     */

    private static List<Integer>[] adjacency;

    private static boolean[] visited;

    public static void depthFirstSearch(int V) {
        visited[V] = true;
        System.out.println("V = " + V + " ");

        for (int neighbor : adjacency[V]) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        adjacency = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjacency[i] = new ArrayList<>();
            visited[i] = false;
        }

        adjacency[0].add(1);
        adjacency[0].add(2);
        adjacency[1].add(2);
        adjacency[2].add(0);
        adjacency[2].add(3);
        adjacency[3].add(3);

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
            }
        }
    }
}
