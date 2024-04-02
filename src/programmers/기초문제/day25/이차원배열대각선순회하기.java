package programmers.기초문제.day25;

public class 이차원배열대각선순회하기 {

    /**
     * [ 문제 설명 ]
     * 2차원 정수 배열 board와 정수 k가 주어집니다.
     * i + j <= k를 만족하는 모든 (i, j)에 대한 board[i][j]의 합을 반환하라.
     */
    public int solution(int[][] board, int k) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i + j <= k) {
                    answer += board[i][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        이차원배열대각선순회하기 diagonalArrayTraversal = new 이차원배열대각선순회하기();
        int[][] board = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        System.out.println("Result: " + diagonalArrayTraversal.solution(board, 2));
    }
}
