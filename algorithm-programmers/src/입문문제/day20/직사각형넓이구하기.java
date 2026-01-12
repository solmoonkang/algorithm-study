package 입문문제.day20;

public class 직사각형넓이구하기 {

    /**
     * [ 문제 설명 ]
     * 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
     * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
     * 직사각형의 넓이를 반환하라.
     */
    public int solution(int[][] dots) {
        // TODO: 2차원 배열을 다루는 지식과 응용 능력이 미숙하여 공부가 더 필요하다.

        // 먼저, 첫 번째 점의 x, y 좌표를 최소값과 최대값으로 설정한다. 이를 위해 min과 max라는 두 개의 배열을 생성하고,
        // 첫 번째 점의 x, y 좌표로 초기화한다.
        int[] min = {dots[0][0], dots[0][1]};
        int[] max = {dots[0][0], dots[0][1]};

        // 두 번째 점부터 마지막 점까지 순회하면서 각 점의 x, y 좌표를 검사한다. 이를 위해 두 개의 for 반복문을 사용하는데,
        // 바깥쪽 반복문은 점들을 순회하고, 안쪽 반복문은 x, y 좌표를 순회한다.
        for (int i = 1; i < dots.length; i++) {
            for (int j = 0; j < 2; j++) {
                // 현재 좌표가 min보다 작으면 min을 업데이트하고,
                if (dots[i][j] < min[j]) {
                    // min에는 x, y 좌표의 최소값이 저장되고,
                    min[j] = dots[i][j];
                // max보다 크면 max를 업데이트한다.
                } else if (dots[i][j] > max[j]) {
                    // max에는 x, y 좌표의 최대값이 저장된다.
                    max[j] = dots[i][j];
                }
            }
        }
        int width = max[0] - min[0];
        int height = max[1] - min[1];

        return width * height;
    }

    public static void main(String[] args) {
        직사각형넓이구하기 findingAreaOfRectangle = new 직사각형넓이구하기();
        int[][] firstDots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        int[][] secondDots = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        System.out.println("Result: " + findingAreaOfRectangle.solution(firstDots));
        System.out.println("Result: " + findingAreaOfRectangle.solution(secondDots));

    }
}
