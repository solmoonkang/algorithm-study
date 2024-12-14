package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 친구네트워크 {

    // TODO: 대규모 네트워크에서 Union-Find 방식이 더 효율적이며 최적화된 방법이다. 해당 알고리즘에 대해서 학습 후 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder unionStringBuilder = new StringBuilder();
        StringBuilder bfsStringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(bufferedReader.readLine());

            UnionFind unionFind = new UnionFind();
            Map<String, List<String>> friendsMap = new HashMap<>();

            for (int j = 0; j < F; j++) {
                String[] friends = bufferedReader.readLine().split(" ");
                String friendA = friends[0];
                String friendB = friends[1];

                // Union-Find
                unionFind.unionNode(friendA, friendB);
                unionStringBuilder.append(unionFind.getNodeSize(friendA)).append("\n");

                // BFS
                friendsMap.putIfAbsent(friendA, new ArrayList<>());
                friendsMap.putIfAbsent(friendB, new ArrayList<>());
                friendsMap.get(friendA).add(friendB);
                friendsMap.get(friendB).add(friendA);

                bfsStringBuilder.append(BFS(friendsMap, friendA)).append("\n");
            }
        }

        bufferedWriter.write("UNION-FIND = " + unionStringBuilder);
        bufferedWriter.write("BFS = " + bfsStringBuilder);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * Union-Find 알고리즘
     * <p>
     * 집합을 관리하는 자료구조로, 각 요소가 속한 집합의 대표자를 추적한다.
     * findNode 연산 -> 특정 요소의 대표자를 찾는 연산이다.
     * unionNode 연산 -> 두 요소를 연결하여 같은 집합으로 만드는 연산이다.
     * <p>
     * findNode 연산 시 경로 압축을 통해 트리의 높이를 줄여 성능을 향상시킨다.
     * - 작은 집합을 큰 집합에 연결하여 트리의 높이를 최소화한다.
     * <p>
     * 평균적으로 O(α(N))의 시간 복잡도를 갖어 빠른 성능을 제공하며, 네트워크의 크기를 즉시 계산할 수 있다.
     * 하지만, 초기 설정 및 알고리즘 이해가 상대적으로 복잡하다.
     */
    private static class UnionFind {
        private Map<String, String> parentNodeMap;
        private Map<String, Integer> nodeSizeMap;

        public UnionFind() {
            this.parentNodeMap = new HashMap<>();
            this.nodeSizeMap = new HashMap<>();
        }

        private String findNode(String node) {
            if (!parentNodeMap.containsKey(node)) {
                parentNodeMap.put(node, node);
                nodeSizeMap.put(node, 1);
            }

            if (!parentNodeMap.get(node).equals(node)) parentNodeMap.put(node, findNode(parentNodeMap.get(node)));

            return parentNodeMap.get(node);
        }

        public void unionNode(String nodeX, String nodeY) {
            String rootNodeX = findNode(nodeX);
            String rootNodeY = findNode(nodeY);

            if (!rootNodeX.equals(rootNodeY)) {
                if (nodeSizeMap.get(rootNodeX) < nodeSizeMap.get(rootNodeY)) {
                    parentNodeMap.put(rootNodeX, rootNodeY);
                    nodeSizeMap.put(rootNodeY, nodeSizeMap.get(rootNodeY) + nodeSizeMap.get(rootNodeX));
                } else {
                    parentNodeMap.put(rootNodeY, rootNodeX);
                    nodeSizeMap.put(rootNodeX, nodeSizeMap.get(rootNodeX) + nodeSizeMap.get(rootNodeY));
                }
            }
        }

        public int getNodeSize(String nodeX) {
            String rootNode = findNode(nodeX);
            return nodeSizeMap.get(rootNode);
        }
    }

    /**
     * BFS 알고리즘
     * <p>
     * 그래프 탐색 알고리즘으로, 그래프의 모든 정점을 방문하고 연결된 컴포넌트를 탐색한다.
     * <p>
     * 구현이 비교적 간단하고 직관적이며, 연결된 모든 노드를 탐색할 수 있어 특정 조건에 맞는 노드를 찾는 데 유용하다.
     * 하지만 각 친구 관계가 생길 때마다 전체 네트워크를 탐색해야 하므로 최악의 경우 O(F)의 시간 복잡도를 갖으며, 그래프의 크기에 따라 메모리 사용량이 증가할 수 있다.
     */
    private static int BFS(Map<String, List<String>> friendsMap, String start) {
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.offerLast(start);
        visited.add(start);

        while (!deque.isEmpty()) {
            String currentNode = deque.pollFirst();

            for (String neighborNode : friendsMap.get(currentNode)) {
                if (!visited.contains(neighborNode)) {
                    visited.add(neighborNode);
                    deque.offerLast(neighborNode);
                }
            }
        }

        return visited.size();
    }
}
