package baekjoon.알고리즘분류.너비우선탐색.연습문제;

import java.util.ArrayList;

public class AdjacencyListExample {

    static final int N = 7;

    static boolean[] visited = new boolean[N];
    static ArrayList<Integer>[] arrayLists = new ArrayList[N];
    static ArrayList<Integer> procedure = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        arrayLists[1].add(2);
        arrayLists[1].add(3);
        arrayLists[2].add(5);
        arrayLists[2].add(6);
        arrayLists[3].add(4);
        arrayLists[4].add(6);

        QueueExample queueExample = new QueueExample();
        queueExample.BFS(1, visited, arrayLists, procedure);
        System.out.println("queue procedure = " + procedure);
    }
}
