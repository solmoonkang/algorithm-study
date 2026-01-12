package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 연구소 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int MAX_WALL_COUNT = 3;

    private static int N, M;
    private static int[][] virusResearchLaboratory;
    private static int maxSafeArea = 0;

    // TODO: 각 코드가 어떻게 동작을 하는지, 구현 과정을 자세하게 공부하고 커밋하자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        virusResearchLaboratory = new int[N][M];
        // 빈 공간(0)의 좌표를 저장하는 리스트로, 3개의 벽을 세우기 위한 조합을 생성할 때 필요하다.
        List<int[]> emptySpacesList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                virusResearchLaboratory[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                // 빈 공간의 좌표와 해당 공간의 벽을 세운 여부를 나타내기 위해 저장한다. 또한, 벽을 세운 공간을 체크하기 위해 다음과 같이 관리된다.
                if (virusResearchLaboratory[i][j] == 0) emptySpacesList.add(new int[]{i, j, 0});
            }
        }

        buildWalls(emptySpacesList, 0, 0);
        bufferedWriter.write(String.valueOf(maxSafeArea));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void buildWalls(List<int[]> emptySpacesList, int start, int count) {
        if (count == MAX_WALL_COUNT) {
            int[][] currentVirusResearchLaboratory = new int[N][M];
            for (int i = 0; i < N; i++) currentVirusResearchLaboratory[i] = virusResearchLaboratory[i].clone();

            for (int[] emptySpaces : emptySpacesList) {
                if (emptySpaces[2] == 1) currentVirusResearchLaboratory[emptySpaces[0]][emptySpaces[1]] = 1;
            }

            spreadVirus(currentVirusResearchLaboratory);
            maxSafeArea = Math.max(maxSafeArea, calculateSafeArea(currentVirusResearchLaboratory));
            return;
        }

        // 벽을 세운 후 재귀적으로 다음 벽을 세우기 위해 가능한 모든 조합을 시도한 후, 원래 상태로 되돌리기 위해 벽을 세운 상태를 초기화한다.
        for (int i = start; i < emptySpacesList.size(); i++) {
            emptySpacesList.get(i)[2] = 1;
            buildWalls(emptySpacesList, i + 1, count + 1);
            emptySpacesList.get(i)[2] = 0;
        }
    }

    private static void spreadVirus(int[][] currentVirusResearchLaboratory) {
        Deque<int[]> searchDeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currentVirusResearchLaboratory[i][j] == 2) searchDeque.offerLast(new int[]{i, j});
            }
        }

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && currentVirusResearchLaboratory[nx][ny] == 0) {
                    currentVirusResearchLaboratory[nx][ny] = 2;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }
    }

    private static int calculateSafeArea(int[][] currentVirusResearchLaboratory) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currentVirusResearchLaboratory[i][j] == 0) safeArea++;
            }
        }

        return safeArea;
    }
}
