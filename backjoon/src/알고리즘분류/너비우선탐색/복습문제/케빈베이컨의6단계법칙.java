package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 케빈베이컨의6단계법칙 {

    private static int N, M;
    private static List<List<Integer>> kevinBaconSeparationList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        kevinBaconSeparationList = new ArrayList<>();
        for (int i = 0; i <= N; i++) kevinBaconSeparationList.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int friendship1 = Integer.parseInt(stringTokenizer.nextToken());
            int friendship2 = Integer.parseInt(stringTokenizer.nextToken());

            kevinBaconSeparationList.get(friendship1).add(friendship2);
            kevinBaconSeparationList.get(friendship2).add(friendship1);
        }

        int minKevinBaconNumber = Integer.MAX_VALUE;
        int userWithMinKevinBacon = -1;

        for (int i = 1; i <= N; i++) {
            int kevinBaconNumber = BFS(i);

            if (kevinBaconNumber < minKevinBaconNumber) {
                minKevinBaconNumber = kevinBaconNumber;
                userWithMinKevinBacon = i;
            // 현재 계산된 kevinBaconNumber가 이전에 저장된 최소 케빈-베이컨 수와 동일한지 확인한다. 즉, 현재 유저와 다른 유저 간의 연결 수가 최소값과 같다는 의미이다.
            // 만약, 두 명 이상의 유저가 같은 최소 케빈-베이컨 수를 가지고 있다면 번호가 더 작은 유저를 선택해야 한다. 이때, userWithMinKevinBacon를 갱신해야 하는데, 이떄 Math.min을 사용해 현재 유저와 기존 유저 중 더 작은 번호를 선택한다.
            } else if (kevinBaconNumber == minKevinBaconNumber) {
                userWithMinKevinBacon = Math.min(userWithMinKevinBacon, i);
            }
        }

        bufferedWriter.write(String.valueOf(userWithMinKevinBacon));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        Deque<int[]> searchDeque = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        searchDeque.offerLast(new int[]{start, 0});
        visited[start] = true;

        int totalDistance = 0;
        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int number = current[0];
            int distance = current[1];

            totalDistance += distance;

            for (int friend : kevinBaconSeparationList.get(number)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    searchDeque.offerLast(new int[]{friend, distance + 1});
                }
            }
        }

        return totalDistance;
    }
}
