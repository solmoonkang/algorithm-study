package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판점프 {

    private static final int NUMBER_BOARD_SIZE = 5;
    private static final int NUMBER_LENGTH = 6;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int[][] numberBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        numberBoard = new int[NUMBER_BOARD_SIZE][NUMBER_BOARD_SIZE];
        for (int i = 0; i < NUMBER_BOARD_SIZE; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < NUMBER_BOARD_SIZE; j++) {
                numberBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 중복된 6자리 수를 자동으로 제거하기 위해서 Set 자료구조를 사용한다.
        Set<String> numberSet = new HashSet<>();

        for (int i = 0; i < NUMBER_BOARD_SIZE; i++) {
            for (int j = 0; j < NUMBER_BOARD_SIZE; j++) {
                DFS(i, j, String.valueOf(numberBoard[i][j]), 1, numberSet);
            }
        }

        bufferedWriter.write(String.valueOf(numberSet.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     *
     * @param startX: 현재 위치를 나타내는 좌표로, DFS를 통해 이동할 때마다 현재 위치를 추적한다.
     * @param startY: 현재 위치를 나타내는 좌표로, DFS를 통해 이동할 때마다 현재 위치를 추적한다.
     * @param path: 현재 생성된 숫자의 경로로, 각 이동에서 숫자를 추가하여 6자리 수를 만들기 때문에, 이 문자열을 매개변수로 전달한다.
     * @param depth: 현재까지 이동한 횟수를 나타내며, 해당 값이 6에 도달하면 6자리 수가 완성된 것으로 간주하고, 그때 Set에 추가한다.
     * @param numberSet: 생성된 6자리 수를 저장하여 중복을 제거하기 위해 사용한다.
     */
    private static void DFS(int startX, int startY, String path, int depth, Set<String> numberSet) {
        // 현재 깊이가 6에 도달했을 때, 즉 6자리 수가 완성되었을 때 실행된다. 이때 path를 Set에 추가하고, 더 이상 진행할 필요가 없으므로 실행을 종료한다.
        if (depth == NUMBER_LENGTH) {
            numberSet.add(path);
            return;
        }

        for (int[] direction : DIRECTIONS) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            if (nx >= 0 && nx < NUMBER_BOARD_SIZE && ny >= 0 && ny < NUMBER_BOARD_SIZE) {
                DFS(nx, ny, path + numberBoard[nx][ny], depth + 1, numberSet);
            }
        }
    }
}
