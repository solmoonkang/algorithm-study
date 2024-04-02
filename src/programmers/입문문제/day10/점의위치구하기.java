package programmers.입문문제.day10;

public class 점의위치구하기 {

    /**
     * [ 문제 설명 ]
     * 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
     *
     * x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
     * x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
     * x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
     * x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
     *
     * x 좌표 (x, y)를 차례대로 담은 정수 배열 dot이 매개변수로 주어집니다.
     * 좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 반환하라.
     */
    public int solution(int[] dot) {
        if (dot[0] > 0 && dot[1] > 0) {
            return 1;
        } else if (dot[0] < 0 && dot[1] > 0) {
            return 2;
        } else if (dot[0] > 0 && dot[1] < 0) {
            return 4;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        점의위치구하기 pointPosition = new 점의위치구하기();
        int[] firstDot = {2, 4};
        int[] secondDot = {-7, 9};
        System.out.println("Result: " + pointPosition.solution(firstDot));
        System.out.println("Result: " + pointPosition.solution(secondDot));
    }
}
