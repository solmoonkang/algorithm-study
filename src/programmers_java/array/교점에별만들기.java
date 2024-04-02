package programmers_java.array;

import java.util.ArrayList;
import java.util.List;

public class 교점에별만들기 {

    /**
     * [ 문제 설명 ]
     * Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
     *
     * 예를 들어, 다음과 같은 직선 5개를
     *
     * 2x - y + 4 = 0
     * -2x - y + 4 = 0
     * -y + 1 = 0
     * 5x - 8y - 12 = 0
     * 5x + 8y + 12 = 0
     *
     * 직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다.
     * 이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
     *  - line의 가로(열) 길이는 3입니다.
     *  - line의 각 원소는 [A, B, C] 형태입니다.
     *  - A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
     *  - 무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
     *  - A = 0이면서 B = 0인 경우는 주어지지 않습니다.
     * 정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
     * 별이 한 개 이상 그려지는 입력만 주어집니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 모든 직선 쌍에 대해 반복
     *  - 교점 좌표 구하기
     *  - 정수 좌표만 구하기
     * 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
     * 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
     * 4. 2차원 배열에 별 표시
     * 5. 문자열 배열로 변환 후 반환
     */
    private static class Point {
        // 데이터를 나타내는 클래스로 final 키워드로 불변성을 갖게 하고, 생성자로 초기화할 수 있게 해준다.
        // 문제에서 좌표 범위가 주어지지 않았기 때문에 x, y는 long으로 표현한다. (그래야 오버플로우가 발생하지 않는다.)
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % x != 0) return null;

        return new Point((long) x, (long) y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        return null;
    }
}
