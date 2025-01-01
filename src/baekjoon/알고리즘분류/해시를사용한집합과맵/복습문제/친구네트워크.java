package baekjoon.알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 친구네트워크 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    // TODO: Union-Find 방식을 통해 구현하였으나, 아직 제대로 이해하지 못했다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            Map<String, String> parentMap = new HashMap<>();
            Map<String, Integer> friendshipSizeMap = new HashMap<>();

            int F = Integer.parseInt(bufferedReader.readLine());

            for (int j = 0; j < F; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String friendA = stringTokenizer.nextToken();
                String friendB = stringTokenizer.nextToken();

                unionOperation(friendA, friendB, parentMap, friendshipSizeMap);
                stringBuilder.append(friendshipSizeMap.get(findWithPathCompression(friendA, parentMap, friendshipSizeMap))).append("\n");
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String findWithPathCompression(String friendName, Map<String, String> parentMap, Map<String, Integer> friendshipSizeMap) {
        if (!parentMap.containsKey(friendName)) {
            parentMap.put(friendName, friendName);
            friendshipSizeMap.put(friendName, 1);
        }

        if (!parentMap.get(friendName).equals(friendName)) {
            parentMap.put(friendName, findWithPathCompression(parentMap.get(friendName), parentMap, friendshipSizeMap));
        }

        return parentMap.get(friendName);
    }

    private static void unionOperation(String friendNameA, String friendNameB, Map<String, String> parentMap, Map<String, Integer> friendshipSizeMap) {
        String rootA = findWithPathCompression(friendNameA, parentMap, friendshipSizeMap);
        String rootB = findWithPathCompression(friendNameB, parentMap, friendshipSizeMap);

        if (!rootA.equals(rootB)) {
            if (friendshipSizeMap.get(rootA) < friendshipSizeMap.get(rootB)) {
                parentMap.put(rootA, rootB);
                friendshipSizeMap.put(rootB, friendshipSizeMap.get(rootB) + friendshipSizeMap.get(rootA));
            } else {
                parentMap.put(rootB, rootA);
                friendshipSizeMap.put(rootA, friendshipSizeMap.get(rootA) + friendshipSizeMap.get(rootB));
            }
        }
    }
}
