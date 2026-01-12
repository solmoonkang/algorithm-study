package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 피로도 {

    private static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dungeons = new int[N][2];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            dungeons[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            dungeons[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxDungeons = getExploreMaxDungeons(K, dungeons);
        bufferedWriter.write(String.valueOf(maxDungeons));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 던전을 탐험할 수 있는 모든 가능한 순서(경우의 수)를 따져서, 그중 가장 많은 던전을 탐험할 수 있는 경우의 최대 개수를 구하는 것이다.
     *  - 즉, 던전이 최대 8개니까, 가능한 순서는 8! = 40,320개
     *  - 전부 탐색해도 시간 초과가 나지 않기 때문에 완전 탐색이 타당하다.
     *
     * DFS + 백트래킹 조합을 사용하는 이유는 불필요한 경로를 조기에 잘라낼 수 있어서이다.
     *  - DFS는 완전 탐색의 한 방식으로,
     *  - 특히 재귀적으로 가능한 경로를 탐색하면서, 조건이 안 맞는 경우(피로도 부족 등)는 더 깊이 가지 않고 바로 되돌아올 수 있기 때문에 효율적이다.
     *  - 즉, 단순한 순열 생성 + 검증 방식보다도 DFS 백트래킹이 더 효율적이다.
     */
    private static int getExploreMaxDungeons(int K, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        maxCount = 0;
        DFS(K, dungeons, visited, 0);
        return maxCount;
    }

    /**
     * DFS + 백트래킹 구조
     *  - 현재 상태(피로도, 방문 여부, 탐험 수)를 기억한다.
     *  - 갈 수 있는 던전이 있다면 진행한다.
     *  - 진행 후에는 원상 복구(백트래킹)한다.
     */
    private static void DFS(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        // 탐험을 진행할 때마다 현재까지 탐험한 수(count)를 maxCount와 비교해서 갱신한다.
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            int minRequired = dungeons[i][0];
            int consume = dungeons[i][1];

            // 아직 방문하지 않았고, 현재 피로도로 해당 던전을 갈 수 있다면,
            if (!visited[i] && fatigue >= minRequired) {
                // 해당 던전 선택 후, 소모 피로도만큼 줄이고, 탐험 수를 1 증가시켜 재귀 호출한다.
                visited[i] = true;
                DFS(fatigue - consume, dungeons, visited, count + 1);
                // 그 후 visited[i] = false를 통해 다시 원래 상태로 되돌린다. (백트래킹)
                visited[i] = false;
            }
        }
    }
}
