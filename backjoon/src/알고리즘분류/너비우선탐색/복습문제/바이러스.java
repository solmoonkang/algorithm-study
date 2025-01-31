package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 바이러스 {

    private static boolean[] visited;
    private static List<List<Integer>> wormVirusComputerList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int computerConnection = Integer.parseInt(bufferedReader.readLine());
        int networkConnectionComputerTuple = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[computerConnection + 1];
        wormVirusComputerList = new ArrayList<>();
        for (int i = 0; i <= computerConnection; i++) wormVirusComputerList.add(new ArrayList<>());

        for (int i = 0; i < networkConnectionComputerTuple; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int computerA = Integer.parseInt(stringTokenizer.nextToken());
            int computerB = Integer.parseInt(stringTokenizer.nextToken());

            wormVirusComputerList.get(computerA).add(computerB);
            wormVirusComputerList.get(computerB).add(computerA);
        }

        int wormVirus = BFS();
        bufferedWriter.write(String.valueOf(wormVirus - 1));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.add(1);
        visited[1] = true;

        int wormVirus = 0;
        // BFS는 현재 레벨의 모든 노드를 탐색한 후 다음 레벨로 넘어가는데, 이 과정에서 현재 레벨의 노드 수를 관리하는 것이 중요하다.

        // BFS는 두 가지 접근 방식이 있는데, 먼저 레벨 관리 없이 탐색하는 과정으로 사과를 따는 예를 들어보자.
        // 사과나무가 있고, 나무에 있는 사과를 따기 위해 탐색을 한다. 탐색할 때, 사과를 한 개 따면 그 사과와 연결된 다른 사과를 따러 간다.
        // 이 방식은 사과를 하나씩 따면서 그와 연결된 다른 사과를 탐색한다. 레벨을 신경 쓰지 않고, 매번 꺼낸 사과에 대해 직접적으로 탐색한다.

        // 반면, 레벨을 관리하며 탐색하는 과정으로 친구를 초대하는 예를 들어보자.
        // 친구를 초대할 때, 친구들이 서로 연결되어 내가 친구를 초대하면 그 친구가 다른 친구들을 초대한다. 처음 초대한 친구들만 초대하고, 그 친구들이 초대할 수 있는 친구들을 다음 단계로 초대한다.
        // 이 방식은 초대할 친구의 수를 size로 관리한다. 먼저 현재 초대된 친구들만 탐색하고, 그 친구들이 초대할 수 있는 친구들을 다음 단계로 초대한다. 이렇게 하면 초대 레벨을 관리할 수 있다.
        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();
            wormVirus++;

            for (int neighbor : wormVirusComputerList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    searchDeque.add(neighbor);
                }
            }
        }

        return wormVirus;
    }
}
