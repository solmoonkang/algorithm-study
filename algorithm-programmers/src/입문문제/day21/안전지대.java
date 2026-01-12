package 입문문제.day21;

public class 안전지대 {

    /**
     * [ 문제 설명 ]
     * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
     * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 반환하라.
     */
    public int solution(int[][] board) {
        // TODO: x좌표 변화량과 y좌표 변화량에 대한 이해가 부족하다. 그리고 범위를 벗어났는지, 이미 위험지역으로 체크되지 않았는지 확인하는 부분에 대한 이해가 필요하다.
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int n = board.length;
        int m = board[0].length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                            board[nx][ny] = -1;
                            answer++;
                        }
                    }
                }
            }
        }

        return n * m - answer;
    }

    public static void main(String[] args) {
        안전지대 safetyZone = new 안전지대();
        int[][] firstBoards = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] secondBoards = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}};
        int[][] thirdBoards = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}};
        System.out.println("Result: " + safetyZone.solution(firstBoards));
        System.out.println("Result: " + safetyZone.solution(secondBoards));
        System.out.println("Result: " + safetyZone.solution(thirdBoards));
    }
}
