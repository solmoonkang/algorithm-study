package 알고리즘분류.자료구조;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 뱀 {

    /**
     * LinkedList: 삽입과 삭제에서 강점을 갖지만, 요소 접근이 느리다.
     * ArrayList: 요소 접근이 빠르며, 연속적인 메모리 사용으로 인해 캐시 효율성이 높다.
     */

    private static int currentDirection = 0;

    private static final Deque<int[]> snake = new ArrayDeque<>();
    private static final Deque<int[]> directionChanges = new LinkedList<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int K = Integer.parseInt(bufferedReader.readLine());

        int[][] board = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());
            board[X][Y] = 1;
        }

        int L = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int X = Integer.parseInt(stringTokenizer.nextToken());
            char C = stringTokenizer.nextToken().charAt(0);
            directionChanges.offerLast(new int[]{X, C});
        }

        snake.offerFirst(new int[]{1, 1});
        int time = 0;

        while (true) {
            time++;

            int[] head = snake.peekFirst();
            int nextX = head[0] + directions[currentDirection][0];
            int nextY = head[1] + directions[currentDirection][1];

            if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || isBodyCollision(nextX, nextY)) {
                break;
            }

            snake.offerFirst(new int[]{nextX, nextY});

            if (board[nextX][nextY] == 1) board[nextX][nextY] = 0;
            else snake.pollLast();

            if (!directionChanges.isEmpty() && directionChanges.peek()[0] == time) {
                int[] change = directionChanges.pollFirst();
                char direction = (char) change[1];

                if (direction == 'L') currentDirection = (currentDirection + 3) % 4;
                else currentDirection = (currentDirection + 1) % 4;
            }
        }

        bufferedWriter.write(String.valueOf(time));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isBodyCollision(int x, int y) {
        for (int[] bodyPart : snake) {
            if (bodyPart[0] == x && bodyPart[1] == y) return true;
        }

        return false;
    }
}
