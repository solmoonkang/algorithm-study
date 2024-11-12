package baekjoon.알고리즘분류.너비우선탐색.연습문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public void BFS(int start, boolean[] visited, ArrayList<Integer>[] arrayLists, ArrayList<Integer> procedure) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            procedure.add(current);
            visited[current] = true;

            for (int i = 0; i < arrayLists[current].size(); i++) {
                int node = arrayLists[current].get(i);
                if (!visited[node]) queue.offer(node);
            }
        }
    }
}
