package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 촌수계산 {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;
    private static int degreeOfKinship = -1;

    private static Map<Integer, Integer> parentMap;
    private static Set<Integer> visitedSet;
    private static int cousinDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int relativeA = Integer.parseInt(stringTokenizer.nextToken());
        int relativeB = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        M = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[parentNode].add(childNode);
            arrayLists[childNode].add(parentNode);
        }

        DFS(relativeA, relativeB, 0);
        bufferedWriter.write(String.valueOf(degreeOfKinship));
        bufferedWriter.newLine();

        parentMap = new HashMap<>();
        visitedSet = new HashSet<>();
        cousinDegree = -1;

        calculateCousinDegree(relativeA, relativeB, 0);
        bufferedWriter.write(String.valueOf(cousinDegree));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int currentNode, int targetNode, int count) {
        if (currentNode == targetNode) {
            degreeOfKinship = count;
            return;
        }

        visited[currentNode] = true;

        for (int nextNode : arrayLists[currentNode]) {
            if (!visited[nextNode]) {
                DFS(nextNode, targetNode, count + 1);
                if (degreeOfKinship != -1) return;
            }
        }
    }

    private static void calculateCousinDegree(int current, int target, int degree) {
        visitedSet.add(current);

        if (current == target) {
            cousinDegree = degree;
            return;
        }

        if (parentMap.containsKey(current)) {
            int parent = parentMap.get(current);
            if (!visitedSet.contains(parent)) calculateCousinDegree(parent, target, degree + 1);
        }

        visitedSet.remove(current);
    }
}
