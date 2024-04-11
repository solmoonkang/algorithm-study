package programmers.모든문제.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 땅따먹기 {

    /**
     * [ 문제 설명 ]
     * 땅따먹기 게임을 하려고 합니다.
     * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
     * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
     * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
     *
     * 예를 들면,
     * | 1 | 2 | 3 | 5 |
     * | 5 | 6 | 7 | 8 |
     * | 4 | 3 | 2 | 1 |
     * 로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.
     *
     * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
     * 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.
     */

    /**
     * [ 제한 사항 ]
     * 행의 개수 N : 100,000 이하의 자연수
     * 열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
     * 점수 : 100 이하의 자연수
     */
    public int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land.length; i++) {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] > maxValue) {
                    maxValue = land[i][j];
                    maxIndex = j;
                }
                // 이전 행에서 선택했던 인덱스인지 아닌지 판별 후 동일하면 그 다음으로 큰 수를, 동일하지 않다면 해당 수를 저장한다.
            }
            answer += maxValue;
        }

        return answer;
    }

    public int solutionDynamicProgramming(int[][] land) {
        // TODO: DP 알고리즘을 활용해서 구현했음. 아직 알고리즘에 대한 공부가 빈약함. 다시 한 번 풀어보자.
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;

                for (int k = 0; k < land[0].length; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }
                land[i][j] += max;
            }
        }

        int answer = 0;
        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        땅따먹기 landGrab = new 땅따먹기();

        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println("landGrab = " + landGrab.solution(land));

        System.out.println("landGrab = " + landGrab.solutionDynamicProgramming(land));
    }
}
