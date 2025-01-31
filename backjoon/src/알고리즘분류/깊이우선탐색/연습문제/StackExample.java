package 알고리즘분류.깊이우선탐색.연습문제;

import java.util.ArrayList;
import java.util.Stack;

public class StackExample {

    public void DFS(int start, boolean[] visited, ArrayList<Integer>[] arrayLists, ArrayList<Integer> procedure) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;
            procedure.add(current);

            // 해당 노드의 인접 리스트를 검사하며, visited가 false인 경우에만 stack.push( )
            for (int i : arrayLists[current]) {
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }
    }
}
