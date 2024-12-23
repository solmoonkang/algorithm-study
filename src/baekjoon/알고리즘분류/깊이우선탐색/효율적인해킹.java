package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인해킹 {

    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int trustedConnectionA = Integer.parseInt(stringTokenizer.nextToken());
            int trustedConnectionB = Integer.parseInt(stringTokenizer.nextToken());

            // A가 B를 신뢰하면, B를 해킹하면 A도 해킹할 수 있다. 따라서 방향 반대로 저장해야 한다.
            arrayLists.get(trustedConnectionB).add(trustedConnectionA);
        }

        int maxHackableCount = 0;
        List<Integer> hackableComputersList = new ArrayList<>();

        // 각 사용자에 대해 DFS를 수행하여 해킹할 수 있는 컴퓨터 수를 계산한다.
        for (int i = 1; i <= N; i++) {
            // 각 DFS를 호출하기 전에 visited 배열을 초기화한다.
            visited = new boolean[N + 1];
            int hackableCount = DFS(i);

            // 최대 해킹 가능한 수와 비교한다.
            if (hackableCount > maxHackableCount) {
                maxHackableCount = hackableCount;
                hackableComputersList.clear();
                hackableComputersList.add(i);
            } else if (hackableCount == maxHackableCount) {
                hackableComputersList.add(i);
            }
        }

        for (int computer : hackableComputersList) bufferedWriter.write(computer + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int start) {
        visited[start] = true;  // 현재 컴퓨터를 방문 처리한다.
        int computerCount = 1;  // 현재 컴퓨터를 포함하여 카운트한다.

        // 신뢰 관계를 통해 연결된 컴퓨터를 탐색한다.
        for (int neighbor : arrayLists.get(start)) {
            // 재귀 호출하여 해킹 가능한 수를 카운트한다.
            if (!visited[neighbor]) computerCount += DFS(neighbor);
        }

        // 해킹 가능한 총 컴퓨터의 수를 반환한다.
        return computerCount;
    }
}
