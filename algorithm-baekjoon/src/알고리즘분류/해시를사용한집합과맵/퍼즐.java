package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 퍼즐 {

    private static final int BOARD_SIZE = 3;
    private static final int IMPOSSIBLE_MOVES = -1;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String TARGET_STATE = "123456780";

    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    // TODO: newState부터 이해가 잘 되질 않는다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < BOARD_SIZE; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int minMoves = BFS();
        bufferedWriter.write(String.valueOf(minMoves));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        String initialState = getTargetState();
        Deque<String> searchDeque = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        searchDeque.offerLast(initialState);
        visited.add(initialState);
        int moves = 0;

        while (!searchDeque.isEmpty()) {
            int size = searchDeque.size();

            for (int i = 0; i < size; i++) {
                String currentState = searchDeque.pollFirst();
                if (Objects.equals(currentState, TARGET_STATE)) return moves;

                int zeroIndex = Objects.requireNonNull(currentState).indexOf('0');
                int zeroRow = zeroIndex / BOARD_SIZE;
                int zeroCol = zeroIndex % BOARD_SIZE;

                for (int[] direction : directions) {
                    int newRow = zeroRow + direction[0];
                    int newCol = zeroCol + direction[1];

                    if (newRow >= 0 && newRow < BOARD_SIZE && newCol >= 0 && newCol < BOARD_SIZE) {
                        char[] newState = currentState.toCharArray();

                        char temp = newState[zeroIndex];
                        newState[zeroIndex] = newState[newRow * BOARD_SIZE + newCol];
                        newState[newRow * BOARD_SIZE + newCol] = temp;

                        String nextState = new String(newState);
                        if (!visited.contains(nextState)) {
                            visited.add(nextState);
                            searchDeque.offerLast(nextState);
                        }
                    }
                }
            }

            moves++;
        }

        return IMPOSSIBLE_MOVES;
    }

    private static String getTargetState() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                stringBuilder.append(board[i][j]);
            }
        }

        return stringBuilder.toString();
    }
}
