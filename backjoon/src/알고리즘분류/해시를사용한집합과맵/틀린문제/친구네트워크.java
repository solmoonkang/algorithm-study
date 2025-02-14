package 알고리즘분류.해시를사용한집합과맵.틀린문제;

import java.io.*;
import java.util.*;

public class 친구네트워크 {

    private static Map<String, Set<String>> friendshipMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNumber = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testNumber; i++) {
            friendshipMap = new HashMap<>();

            int friendshipNumber = Integer.parseInt(bufferedReader.readLine());
            List<Integer> friendshipNetworkList = new ArrayList<>();

            for (int j = 0; j < friendshipNumber; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String memberNicknameA = stringTokenizer.nextToken();
                String memberNicknameB = stringTokenizer.nextToken();

                addFriendship(memberNicknameA, memberNicknameB);

                int relationshipDepth = BFS(memberNicknameA, memberNicknameB);
                friendshipNetworkList.add(relationshipDepth);
            }

            for (int friendship : friendshipNetworkList) {
                bufferedWriter.write(friendship + "\n");
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void addFriendship(String memberNicknameA, String memberNicknameB) {
        friendshipMap.putIfAbsent(memberNicknameA, new HashSet<>());
        friendshipMap.putIfAbsent(memberNicknameB, new HashSet<>());

        friendshipMap.get(memberNicknameA).add(memberNicknameB);
        friendshipMap.get(memberNicknameB).add(memberNicknameA);
    }

    private static int BFS(String startNode, String targetNode) {
        if (!friendshipMap.containsKey(startNode)) return 0;

        Deque<String> searchDeque = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        searchDeque.offerLast(startNode);
        visited.add(startNode);

        int depth = 0;

        while (!searchDeque.isEmpty()) {
            int size = searchDeque.size();
            depth++;

            for (int i = 0; i < size; i++) {
                String currentNode = searchDeque.pollFirst();

                for (String friendship : friendshipMap.get(currentNode)) {
                    if (friendship.equals(targetNode)) return depth + 1;
                    if (!visited.contains(friendship)) {
                        visited.add(friendship);
                        searchDeque.offerLast(friendship);
                    }
                }
            }
        }

        return 0;
    }
}
