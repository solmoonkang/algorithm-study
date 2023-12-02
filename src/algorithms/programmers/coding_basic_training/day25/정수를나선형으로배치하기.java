package algorithms.programmers.coding_basic_training.day25;

import java.util.Arrays;

public class 정수를나선형으로배치하기 {

    /**
     * [ 문제 설명 ]
     * 양의 정수 n이 매개변수로 주어집니다.
     * n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 반환하라.
     */
    public int[][] solution(int n) {
        // TODO: 프로그래머스 자바편을 다시 정독하고, 구현할 필요가 있다.
        int[][] answer = new int[n][n];

        // 우, 하, 좌, 상 순서로 이동한다.
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int count = 1;
        int x = 0, y = 0, direction = 0;

        while (count <= n * n) {
            answer[x][y] = count;
            count++;

            // 현재 위치 (x, y)에서 다음 위치 (nx, ny)를 계산한다.
            // direction은 현재 이동 방향을 나타내며, dx와 dy 배열을 사용하여 이동 방향에 따라 위치를 업데이트한다.
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 다음 위치가 이차원 배열의 범위를 벗어나거나, 이미 방문한 위치인지 검사한다.
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                // 만약 그렇다면, 방향을 바꾼다. (여기서 % 연산자를 사용하면 4가 되면 0으로 돌아가므로 우, 하, 좌, 상 순환을 구현한다.)
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            // 마지막으로, 현재 위치를 다음 위치로 업데이트한다.
            x = nx;
            y = ny;
        }
        return answer;
    }

    public static void main(String[] args) {
        정수를나선형으로배치하기 spiralNumberArranger = new 정수를나선형으로배치하기();
        System.out.println("Result: " + Arrays.deepToString(spiralNumberArranger.solution(4)));
        System.out.println("Result: " + Arrays.deepToString(spiralNumberArranger.solution(5)));
    }
}
