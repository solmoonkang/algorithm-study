package programmers.입문문제.day13;

import java.util.Arrays;

public class 삼각형의완성조건 {

    /**
     * [ 문제 설명 ]
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 반환하라.
     */
    public int solution(int[] sides) {
        Arrays.sort(sides);
        if ((sides[sides.length - 1]) < sides[0] + sides[1]) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        삼각형의완성조건 triangleInequalityTheorem = new 삼각형의완성조건();
        int[] firstSides = {1, 2, 3};
        int[] secondSides = {3, 6, 2};
        int[] thirdSides = {199, 72, 222};
        System.out.println("Result: " + triangleInequalityTheorem.solution(firstSides));
        System.out.println("Result: " + triangleInequalityTheorem.solution(secondSides));
        System.out.println("Result: " + triangleInequalityTheorem.solution(thirdSides));
    }
}
