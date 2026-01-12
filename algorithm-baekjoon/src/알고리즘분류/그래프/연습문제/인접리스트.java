package 알고리즘분류.그래프.연습문제;

import java.util.ArrayList;
import java.util.List;

public class 인접리스트 {

    private static final int N = 5;

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        putEdge(graph, 1, 2);
        putEdge(graph, 1, 3);
        putEdge(graph, 1, 4);
        putEdge(graph, 2, 3);
        putEdge(graph, 2, 5);
        putEdge(graph, 3, 4);
        putEdge(graph, 4, 5);

        print(graph);
    }

    private static void putEdge(List<List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    private static void print(List<List<Integer>> graph) {
        for (int i = 1; i < graph.size(); i++) {
            List<Integer> node = graph.get(i);
            System.out.print("node" + "[" + i + "] : ");

            for (int neighbor : node) {
                System.out.print(neighbor + "->");
            }
            System.out.println();
        }
    }
}
