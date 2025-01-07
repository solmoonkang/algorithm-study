package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 아기상어 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static int[][] aquariumSpace;
    private static int babySharkSize = 2;
    private static int sharkEaten = 0;
    private static int timeSpent = 0;

    // Position 레코드는 아기 상어와 물고기의 위치를 쉽게 관리하기 위해 사용된다. 여기서 x는 행을, y는 열을 나타내며, distance는 현재 위치에서 아기 상어까지의 거리를 나타낸다.
    private record Position(int x, int y, int distance) {
    }

    // TODO: 전체적으로 이해가 많이 부족한 문제였던 것 같다. 동작 방식을 복습하고 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        aquariumSpace = new int[N][N];
        Position sharkPosition = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                aquariumSpace[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (aquariumSpace[i][j] == 9) {
                    sharkPosition = new Position(i, j, 0);
                    // 아기 상어가 있던 위치를 9에서 0으로 업데이트한다.
                    aquariumSpace[i][j] = 0;
                }
            }
        }

        // 아기 상어가 먹을 수 있는 물고기가 있는 동안 계속해서 먹는 과정을 반복하기 위해 사용한다.
        // 각 반복에서 BFS를 호출하여 현재 위치에서 먹을 수 있는 물고기를 찾고, 가장 가까운 물고기를 먹는다.
        while (true) {
            // BFS를 호출하여 현재 아기 상어 위치에서 먹을 수 있는 물고기 리스트를 찾는다.
            List<Position> fishPositionList = BFS(sharkPosition);
            if (fishPositionList.isEmpty()) break;

            // 가장 가까운 먹을 수 있는 물고기를 선택하고, 아기 상어의 위치를 업데이트한다. 먹은 물고기는 빈 칸으로 설정한다.
            // 이후, 아기 상어가 먹은 물고기 수를 증가시키고 크기와 비교하여 크기를 증가시킨다.
            Position targetFishPosition = fishPositionList.get(0);
            timeSpent += targetFishPosition.distance;
            sharkPosition = new Position(targetFishPosition.x, targetFishPosition.y, 0);
            aquariumSpace[targetFishPosition.x][targetFishPosition.y] = 0;
            sharkEaten++;

            if (sharkEaten == babySharkSize) {
                babySharkSize++;
                sharkEaten = 0;
            }
        }

        bufferedWriter.write(String.valueOf(timeSpent));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static List<Position> BFS(Position sharkPosition) {
        boolean[][] visited = new boolean[N][N];
        Deque<Position> searchDeque = new LinkedList<>();
        List<Position> fishPositionList = new ArrayList<>();
        searchDeque.offerLast(sharkPosition);
        visited[sharkPosition.x][sharkPosition.y] = true;

        while (!searchDeque.isEmpty()) {
            Position currentPosition = searchDeque.pollFirst();

            for (int[] direction : directions) {
                int nx = currentPosition.x + direction[0];
                int ny = currentPosition.y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // 아기 상어는 자신의 크기보다 크기 않은 물고기나 빈 칸만 지나갈 수 있다. 이 조건을 통해 지나갈 수 있는 칸을 확인한다.
                    if (aquariumSpace[nx][ny] <= babySharkSize) {
                        searchDeque.offerLast(new Position(nx, ny, currentPosition.distance + 1));

                        if (aquariumSpace[nx][ny] > 0 && aquariumSpace[nx][ny] < babySharkSize) {
                            fishPositionList.add(new Position(nx, ny, currentPosition.distance + 1));
                        }
                    }
                }
            }
        }

        // BFS는 가까운 물고기를 먼저 찾지만, 여러 마리의 물고기가 있을 경우 거리가 가장 가까운 것 중에서 위쪽과 왼쪽 우선으로 정렬해야 한다.
        // 정렬 후 가장 첫 번째 위치에 있는 물고기를 선택하여 아기 상어가 먹도록 한다.
        fishPositionList.sort((A, B) -> {
            if (A.distance != B.distance) return Integer.compare(A.distance, B.distance);
            if (A.x != B.x) return Integer.compare(A.x, B.x);
            return Integer.compare(A.y, B.y);
        });

        return fishPositionList;
    }
}
