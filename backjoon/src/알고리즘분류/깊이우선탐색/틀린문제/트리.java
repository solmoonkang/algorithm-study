package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {

    private static int N;
    private static List<List<Integer>> tree;
    private static int root, removeNode;
    private static int leafNodeCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int child = 0; child < N; child++) {
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());

            if (parentNode == -1) root = child;     // 루트 노드 저장
            else tree.get(parentNode).add(child);   // 부모-자식 관계 저장
        }

        removeNode = Integer.parseInt(bufferedReader.readLine());

        removeNodeDFS(removeNode);

        if (removeNode != root) countLeafNodes(root);

        bufferedWriter.write(String.valueOf(leafNodeCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void removeNodeDFS(int node) {
        // 부모의 자식 리스트에서도 삭제한다.
        for (List<Integer> children : tree) {
            children.remove(Integer.valueOf(node));
        }

        // 자식 노드를 삭제한다.
        for (int childNode : tree.get(node)) {
            removeNodeDFS(childNode);
        }

        // 삭제할 노드의 리스트를 비운다.
        tree.get(node).clear();
    }

    private static void countLeafNodes(int node) {
        // 자식이 없으면 리프 노드이므로 리프 노드 개수를 증가시킨다.
        if (tree.get(node).isEmpty()) {
            leafNodeCount++;
            return;
        }

        for (int childNode : tree.get(node)) countLeafNodes(childNode);
    }

}
