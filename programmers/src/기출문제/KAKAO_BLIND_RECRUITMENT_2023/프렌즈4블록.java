package 기출문제.KAKAO_BLIND_RECRUITMENT_2023;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록 {

    /**
     * [ 문제 설명 ]
     * 블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
     * 같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
     * 만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다.
     * 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
     * 블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
     * 만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
     *
     * 위 초기 배치를 문자로 표시하면 아래와 같다.
     * TTTANT
     * RRFACC
     * RRRFCC
     * TRRRAA
     * TTMMMF
     * TMMTTJ
     * 각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다.
     * 입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
     */

    /**
     * [ 입력 형식 ]
     * 입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
     * 2 ≦ n, m ≦ 30
     * board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
     */

    /**
     * [ 출력 형식 ]
     * 입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.
     */
    public int solution(int m, int n, String[] board) {
        // TODO: 코드를 봐도 모르겠다. 나중에 다시 풀어보자.
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean matched = true;
        while (matched) {
            matched = false;
            List<int[]> toRemove = new ArrayList<>();

            // 1단계: 지워질 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char current = map[i][j];
                    if (current != ' ' &&
                            current == map[i][j + 1] &&
                            current == map[i + 1][j] &&
                            current == map[i + 1][j + 1]) {
                        toRemove.add(new int[] {i, j});
                        matched = true;
                    }
                }
            }

            // 2단계: 블록 지우기
            for (int[] pos : toRemove) {
                int i = pos[0];
                int j = pos[1];
                map[i][j] = map[i][j + 1] = map[i + 1][j] = map[i + 1][j + 1] = ' ';
            }

            // 3단계: 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != ' ') {
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }

        }
        // 결과 계산
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == ' ') count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        프렌즈4블록 friends4Block = new 프렌즈4블록();

        String[] firstBoard = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println("friends4Block = " + friends4Block.solution(4, 5, firstBoard));

        String[] secondBoard = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println("friends4Block = " + friends4Block.solution(6, 6, secondBoard));
    }
}
