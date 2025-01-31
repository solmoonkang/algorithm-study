package 입문문제.day21;

public class 삼각형의완성조건2 {

    /**
     * [ 문제 설명 ]
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 반환하라.
     */
    public int solution(int[] sides) {
        // sides 원소 중 가장 긴 값을 찾고, 가장 큰 값과 가장 작은 값을 뺀 값을 구한다.
        // sides 원소들을 모두 더한 값 - 1에서 sides 원소 중 가장 큰 값을 뺀 값을 구한다.
        int longestSide = Math.max(sides[0], sides[1]);
        int shortestSide = Math.min(sides[0], sides[1]);

        int minValue = longestSide - shortestSide;
        int maxValue = longestSide + shortestSide;

        return maxValue - minValue - 1;
    }

    public static void main(String[] args) {
        삼각형의완성조건2 conditionsForTriangle = new 삼각형의완성조건2();
        int[] firstSides = {1, 2};
        int[] secondSides = {3, 6};
        int[] thirdSides = {11, 7};
        System.out.println("Result: " + conditionsForTriangle.solution(firstSides));
        System.out.println("Result: " + conditionsForTriangle.solution(secondSides));
        System.out.println("Result: " + conditionsForTriangle.solution(thirdSides));
    }
}
