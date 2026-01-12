package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {

    private static boolean[] visited;
    private static List<List<Integer>> parentChildRelationList;
    private static int degreeOfKinship = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int peopleNumber = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int relationA = Integer.parseInt(stringTokenizer.nextToken());
        int relationB = Integer.parseInt(stringTokenizer.nextToken());

        int parentChildRelationNumber = Integer.parseInt(bufferedReader.readLine());

        // 사람의 수에 따라 인접 리스트를 만들기 위해서는 전체 사람의 수 + 1으로 설정해야 한다.
        parentChildRelationList = new ArrayList<>();
        for (int i = 0; i <= peopleNumber; i++) parentChildRelationList.add(new ArrayList<>());

        // 사람의 번호는 1부터 시작하므로, 인덱스 0은 사용할 수 없다. 따라서 전체 사람의 수 + 1로 설정해야 한다.
        visited = new boolean[peopleNumber + 1];

        for (int i = 0; i < parentChildRelationNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            parentChildRelationList.get(parentNode).add(childNode);
            parentChildRelationList.get(childNode).add(parentNode);
        }

        DFS(relationA, relationB, 0);
        bufferedWriter.write(String.valueOf(degreeOfKinship));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start, int target, int depth) {
        if (start == target) {
            degreeOfKinship = depth;
            return;
        }

        visited[start] = true;

        for (int neighbor : parentChildRelationList.get(start)) {
            if (!visited[neighbor]) {
                DFS(neighbor, target, depth + 1);
                // degreeOfKinship이 -1이 아닌 경우는 목표 노드에 도달했다는 의미로, 해당 깊이를 이미 설정했으므로, 다른 경로를 탐색하지 않도록 조기 종료시키는 부분이다.
                if (degreeOfKinship != -1) return;
            }
        }

        // DFS를 통해 탐색한 경로를 되돌리기 위해, 현재 노드의 방문 상태를 다시 false로 설정한다.
        // 자식 노드를 탐색한 후에 부모 노드로 돌아올 때 방문 상태를 초기화하여 다른 경로를 탐색할 수 있게 한다.
        visited[start] = false;
    }
}
