package programmers.모든문제.level0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 평행 {

    /**
     * [ 문제 설명 ]
     * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
     *
     * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     */

    /**
     * [ 제한 사항 ]
     * dots의 길이 = 4
     * dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
     * 0 ≤ x, y ≤ 100
     * 서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
     * 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
     * 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
     */
    public int solution(int[][] dots) {
        Set<String> differences = new HashSet<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                int[] difference = calculateDifference(dots[i], dots[j]);
                String answer = Arrays.toString(difference);

                if (differences.contains(answer)) {
                    return 1;
                }

                differences.add(answer);
            }
        }

        return 0;
    }

    public int[] calculateDifference(int[] point1, int[] point2) {
        int[] difference = new int[2];
        difference[0] = point1[0] - point2[0]; // x 값의 차이
        difference[1] = point1[1] - point2[1]; // y 값의 차이
        return difference;
    }

    public static void main(String[] args) {
        평행 parallel = new 평행();

        int[][] dots1 = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int[][] dots2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};

        System.out.println("parallel = " + parallel.solution(dots1));
        System.out.println("parallel = " + parallel.solution(dots2));
    }
}
