package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 촌수계산 {

    private static final int NO_KINSHIP_RELATIONSHIP = -1;

    private static boolean[] visited;
    private static List<List<Integer>> parentChildKinshipDegreeList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int kinshipDegreePerson1 = Integer.parseInt(stringTokenizer.nextToken());
        int kinshipDegreePerson2 = Integer.parseInt(stringTokenizer.nextToken());

        int M = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        parentChildKinshipDegreeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) parentChildKinshipDegreeList.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            parentChildKinshipDegreeList.get(parentNode).add(childNode);
            parentChildKinshipDegreeList.get(childNode).add(parentNode);
        }

        int kinshipDegree = BFS(kinshipDegreePerson1, kinshipDegreePerson2);
        bufferedWriter.write(String.valueOf(kinshipDegree));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startNode, int targetNode) {
        Deque<int[]> searchDeque = new LinkedList<>();
        // 촌수는 두 사람(노드) 사이 관계의 깊이를 나타낸다. 따라서 BFS를 사용할 때, 각 노드를 방문할 때 그 노드까지의 깊이(촌수)를 함께 추적해야 한다.
        searchDeque.offerLast(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int currentNode = current[0];
            int kinshipDegree = current[1];

            if (currentNode == targetNode) return kinshipDegree;

            for (int neighborNode : parentChildKinshipDegreeList.get(currentNode)) {
                if (!visited[neighborNode]) {
                    visited[neighborNode] = true;
                    // 노드를 꺼내면서 그 노드까지의 깊이를 참조하여, 자식 노드에 대해 깊이를 1 증가시켜서 큐에 추가한다.
                    searchDeque.offerLast(new int[]{neighborNode, kinshipDegree + 1});
                }
            }
        }

        return NO_KINSHIP_RELATIONSHIP;
    }
}
