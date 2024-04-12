package 연습문제풀이.algorithm.깊이우선탐색;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 스택을활용한깊이우선탐색 {

    /**
     * 반복 구현 (Stack 활용):
     *  - 반복 구현에서는 스택 데이터 구조를 사용하여 방문할 정점을 추적한다.
     * 1. 알고리즘은 임의의 정점에서 시작하여 방문한 것으로 표시하고 스택에 푸시한다.
     * 2. 스택에서 맨 위 정점을 가져온다.
     * 3. 방문하지 않은 인접 정점을 방문하여 방문한 것으로 표시하고 스택으로 푸시한다.
     * 4. 스택이 비워질 때까지 해당 프로세스를 반복한다.
     */

    private static List<Integer>[] adjacency;

    private static boolean[] visited;

    public static void depthFirstSearch(int V) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(V);
        visited[V] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.println("방문 정점 = " + vertex + " ");

            for (int neigbor : adjacency[vertex]) {
                if (!visited[neigbor]) {
                    stack.push(neigbor);
                    visited[neigbor] = true;
                }
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
