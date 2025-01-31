package 입문문제.day1;

public class 두수의합 {

    /**
     * 정수 num1과 num2가 주어질 때, num1과 num2의 합을 반환하라
     */

    public int solution(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        두수의합 sum = new 두수의합();

        System.out.println("Result: " + sum.solution(2, 3));
        System.out.println("Result: " + sum.solution(100, 2));
    }
}
