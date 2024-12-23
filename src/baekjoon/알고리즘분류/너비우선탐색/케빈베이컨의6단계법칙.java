package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 케빈베이컨의6단계법칙 {

    private static int N, M;
    private static List<List<Integer>> arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int relationA = Integer.parseInt(stringTokenizer.nextToken());
            int relationB = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists.get(relationA).add(relationB);
            arrayLists.get(relationB).add(relationA);
        }

        int minKevinBaconNumber = Integer.MAX_VALUE;
        int resultUser = -1;

        // 각 사용자에 대해 BFS를 수행하여 케빈-베이컨 수를 계산한다.
        for (int i = 1; i <= N; i++) {
            int kevinBaconNumber = BFS(i);
            // 가장 적은 케빈-베이컨 수를 찾고, 동일할 경우 작은 번호를 선택한다.
            if (kevinBaconNumber < minKevinBaconNumber) {
                minKevinBaconNumber = kevinBaconNumber;
                resultUser = i;
            }
        }

        bufferedWriter.write(String.valueOf(resultUser));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{start, 0});

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        int totalRelation = 0;      // 현재 사용자의 케빈-베이컨 수

        while (!searchDeque.isEmpty()) {
            int[] currentPosition = searchDeque.pollFirst();
            int position = currentPosition[0];
            int relation = currentPosition[1];

            // 친구 관계를 통해 다른 유저와의 관계를 계산한다.
            for (int nextPosition : arrayLists.get(position)) {
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    searchDeque.add(new int[]{nextPosition, relation + 1});
                    totalRelation += relation + 1;      // 각 친구와의 관계 수를 누적한다.
                }
            }
        }

        // 자기 자신을 제외하고 모든 유저와의 관계 수를 구해야 하므로 userCount + 1를 한다.
        return totalRelation;
    }
}
