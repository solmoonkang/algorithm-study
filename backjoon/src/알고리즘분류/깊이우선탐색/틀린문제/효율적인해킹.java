package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인해킹 {

    private static boolean[] visited;
    private static List<List<Integer>> computerRelationshipList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int computerQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int trustedRelationshipsNumber = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[computerQuantity + 1];
        computerRelationshipList = new ArrayList<>();
        for (int i = 0; i <= computerQuantity; i++) computerRelationshipList.add(new ArrayList<>());

        for (int i = 0; i < trustedRelationshipsNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int trustedRelationshipA = Integer.parseInt(stringTokenizer.nextToken());
            int trustedRelationshipB = Integer.parseInt(stringTokenizer.nextToken());

            // A가 B를 신뢰하는 경우에 B를 해킹하면, A도 해킹할 수 있도록 A에서 B로의 간선만을 추가하도록 한다. 따라서 반대 방향으로 저장해야 한다.
            computerRelationshipList.get(trustedRelationshipB).add(trustedRelationshipA);
        }

        int maxHackingComputerNumber = 0;
        List<Integer> computerNumberList = new ArrayList<>();

        for (int i = 1; i <= computerQuantity; i++) {
            visited = new boolean[computerQuantity + 1];
            int hackingComputerNumber = DFS(i);

            if (hackingComputerNumber > maxHackingComputerNumber) {
                maxHackingComputerNumber = hackingComputerNumber;
                computerNumberList.clear();
                computerNumberList.add(i);
            } else if (hackingComputerNumber == maxHackingComputerNumber) {
                computerNumberList.add(i);
            }
        }

        for (int computerNumber : computerNumberList) bufferedWriter.write(computerNumber + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int current) {
        visited[current] = true;
        int hackingComputerNumber = 1;

        for (int neighbor : computerRelationshipList.get(current)) {
            if (!visited[neighbor]) hackingComputerNumber += DFS(neighbor);
        }

        return hackingComputerNumber;
    }
}
