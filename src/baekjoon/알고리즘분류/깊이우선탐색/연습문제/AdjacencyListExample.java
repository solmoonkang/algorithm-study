package baekjoon.알고리즘분류.깊이우선탐색.연습문제;

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

        StackExample stackExample = new StackExample();
        stackExample.DFS(1, visited, arrayLists, procedure);
        System.out.println("stack procedure = " + procedure);

        visited = new boolean[N];
        procedure.clear();

        RecursiveExample recursiveExample = new RecursiveExample();
        recursiveExample.DFS(1, visited, arrayLists, procedure);
        System.out.println("recursive procedure = " + procedure);
    }
}
