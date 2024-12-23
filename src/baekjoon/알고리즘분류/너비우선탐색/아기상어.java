package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 아기상어 {

    private static final int[] sharkPosition = new int[2];
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static int sharkSize = 2;
    private static int eatCount = 0;
    private static int timeSpent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (arrayLists[i][j] == 9) {
                    sharkPosition[0] = i;
                    sharkPosition[1] = j;
                    arrayLists[i][j] = 0;
                }
            }
        }

        while (true) {
            visited = new boolean[N][N];
            Fish nearestFish = findNearestFish();
            if (nearestFish == null) break;
            eatFish(nearestFish);
        }

        bufferedWriter.write(String.valueOf(timeSpent));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static Fish findNearestFish() {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{sharkPosition[0], sharkPosition[1], 0});
        visited[sharkPosition[0]][sharkPosition[1]] = true;

        Fish nearestFish = null;
        int minDistance = Integer.MAX_VALUE;

        while (!searchDeque.isEmpty()) {
            int[] currentPosition = searchDeque.pollFirst();
            int x = currentPosition[0];
            int y = currentPosition[1];
            int distance = currentPosition[2];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (arrayLists[nx][ny] == 0 || arrayLists[nx][ny] == sharkSize) {
                        searchDeque.add(new int[]{nx, ny, distance + 1});
                    } else if (arrayLists[nx][ny] < sharkSize) {
                        int fishDistance = distance + 1;

                        if (fishDistance < minDistance) {
                            minDistance = fishDistance;
                            nearestFish = new Fish(nx, ny, fishDistance);
                        } else if (fishDistance == minDistance) {
                            if (nearestFish != null) {
                                if (nx < nearestFish.x || (nx == nearestFish.x && ny < nearestFish.y))
                                    nearestFish = new Fish(nx, ny, fishDistance);
                            } else {
                                nearestFish = new Fish(nx, ny, fishDistance);
                            }
                        }
                    }
                }
            }
        }

        return nearestFish;
    }

    private static void eatFish(Fish fish) {
        timeSpent += fish.distance;
        eatCount++;
        sharkPosition[0] = fish.x;
        sharkPosition[1] = fish.y;

        arrayLists[fish.x][fish.y] = 0;

        if (eatCount == sharkSize) {
            sharkSize++;
            eatCount = 0;
        }
    }

    private static class Fish {
        int x, y, distance;

        Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
