package 알고리즘고득점KIT.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 피로도 {

    private static int maxDungeonNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int currentFatigue = Integer.parseInt(stringTokenizer.nextToken());
        int dungeonNumber = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dungeons = new int[dungeonNumber][2];
        for (int i = 0; i < dungeonNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            dungeons[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            dungeons[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        boolean[] visited = new boolean[dungeonNumber];
        DFS(currentFatigue, dungeons, visited, 0);

        bufferedWriter.write(String.valueOf(maxDungeonNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // DFS는 각 재귀 호출 시마다 아직 방문하지 않은 던전들을 하나씩 선택하여 탐색하기 때문에, 최악의 경우 모든 던전의 모든 순서를 탐색하게 된다.
    // 던전의 개수를 N이라고 하면, 모든 가능한 순서의 개수는 N!이다.
    // 각 순열(방문 순서)에 대해 최대 N번 반복문을 실행하므로 O(N * N!)의 시간 복잡도를 가진다.
    private static void DFS(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
        maxDungeonNumber = Math.max(maxDungeonNumber, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                DFS(currentFatigue - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
