package baekjoon.알고리즘분류.구현;

import java.io.*;
import java.util.*;

public class 연구소 {

    private static int N, M;
    private static int[][] researchLaboratory;
    private static int maxSafeArea = 0;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // TODO: 문제를 단계별로 나눠서 각 부분을 구현해보자. 벽 설치 조합, 바이러스 확산, 안전 영역 계산으로 나눠서 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        researchLaboratory = new int[N][M];
        List<int[]> emptySpaces = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                researchLaboratory[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (researchLaboratory[i][j] == 0) emptySpaces.add(new int[]{i, j});
            }
        }

        installWalls(emptySpaces, 0, 0);

        bufferedWriter.write(String.valueOf(maxSafeArea));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * installWalls( ) 메서드의 역할
     * <p>
     * 1. 벽 설치 조합 생성: 빈 공간에 3개의 벽을 설치하는 모든 조합을 생성한다.
     * 2. 재귀 호출: 벽을 설치한 후, 다음 빈 공간에 벽을 설치하기 위해 재귀적으로 자신을 호출한다.
     * 3. 백트래킹: 벽을 3개 설치한 상태에서 바이러스 확산을 시뮬레이션하고, 설치한 벽을 제거하여 이전 상태로 되돌린다.
     */
    private static void installWalls(List<int[]> emptySpaces, int start, int wallCount) {
        // wallCount == 3일 때는 벽이 3개 설치된 상태로, 바이러스가 퍼지는 상황을 시뮬레이션하여 안전 영역의 크기를 계산한다.
        // 현재 설치된 벽의 조합에 대해 바이러스가 퍼진 후 남은 안전 영역의 크기를 계산하고, 그 크기를 maxSafeArea와 비교하여 최대 안전 영역을 업데이트한다.
        if (wallCount == 3) {
            simulateVirusSpread();
            return;
        }

        // List<int[]> emptySpaces는 연구소 내의 모든 빈 공간의 좌표를 저장한다. 이를 통해 벽을 설치할 수 있는 위치를 쉽게 찾을 수 있다.
        // 현재 가능한 빈 공간을 기준으로 벽을 설치할 수 있는 조합을 생성할 수 있다. start 인덱스를 사용하여 이미 선택한 빈 공간의 인덱스를 건너뛰고 다음 빈 공간부터 벽을 설치하게 된다.
        // 벽을 설치한 후, 다음 벽 설치를 위해 재귀 호출을 하는데, 이때 리스트를 통해 남은 빈 공간을 효율적으로 탐색하고, 설치한 벽을 제거하여 원래 상태로 복구하는 방식으로 백트래킹을 수행한다.
        for (int i = start; i < emptySpaces.size(); i++) {
            int x = emptySpaces.get(i)[0];
            int y = emptySpaces.get(i)[1];

            researchLaboratory[x][y] = 1;
            installWalls(emptySpaces, i + 1, wallCount + 1);
            researchLaboratory[x][y] = 0;
        }
    }

    /**
     * simulateVirusSpread( ) 메서드 역할
     * <p>
     * 1. 바이러스 확산 시뮬레이션: 주어진 연구소 상태에서 바이러스가 퍼지는 과정을 시뮬레이션한다.
     * 2. 안전 영역 계산: 바이러스가 퍼진 후 남아 있는 안전 영역 크기를 계산하여 maxSafeArea와 비교하여 업데이트한다.
     */
    private static void simulateVirusSpread() {
        // researchLaboratory의 현재 상태를 virusLaboratory에 복사하여, 원본 데이터를 보존하고 바이러스 확산을 시뮬레이션할 수 있다.
        int[][] virusLaboratory = new int[N][M];
        for (int i = 0; i < N; i++) {
            virusLaboratory[i] = Arrays.copyOf(researchLaboratory[i], M);
        }

        Deque<int[]> deque = new LinkedList<>();

        // virusLaboratory에서 바이러스가 있는 위치인 값이 2인 위치를 찾고, 이를 Deque에 추가한다.
        // Deque를 통해 BFS를 통해 바이러스 확산을 처리한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusLaboratory[i][j] == 2) deque.offerLast(new int[]{i, j});
            }
        }

        // while 루프를 통해 Deque에서 바이러스의 현재 위치를 꺼내고, 상하좌우로 이동하여 빈 공간인 값이 0인 곳을 확인한다.
        // 빈 공간에 바이러스가 퍼지면 해당 위치의 값을 2로 변경하고, 그 위치를 Deque에 추가하여 다음 확산 처리를 위해 Deque에 추가한다.
        while (!deque.isEmpty()) {
            int[] currentVirus = deque.pollFirst();

            for (int[] direction : directions) {
                int nx = currentVirus[0] + direction[0];
                int ny = currentVirus[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && virusLaboratory[nx][ny] == 0) {
                    virusLaboratory[nx][ny] = 2;
                    deque.offerLast(new int[]{nx, ny});
                }
            }
        }

        // 모든 칸을 탐색하여 값이 0인 칸 즉, 안전 영역의 개수를 세어 safeArea에 저장한다.
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusLaboratory[i][j] == 0) safeArea++;
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}
