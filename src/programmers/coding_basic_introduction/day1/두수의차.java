package programmers.coding_basic_introduction.day1;

public class 두수의차 {

    /**
     * 정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 반환하라
     */

    public int solution(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {
        두수의차 difference = new 두수의차();

        System.out.println("Result: " + difference.solution(2, 3));
        System.out.println("Result: " + difference.solution(100, 2));
    }
}
