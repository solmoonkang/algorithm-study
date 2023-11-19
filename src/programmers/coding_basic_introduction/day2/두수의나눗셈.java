package programmers.coding_basic_introduction.day2;

public class 두수의나눗셈 {

    /**
     * 정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 반환하라
     */

    public int solution(int num1, int num2) {
        float answer = ((float) num1 / num2) * 1000;
        return (int) answer;
    }

    public static void main(String[] args) {
        두수의나눗셈 division = new 두수의나눗셈();

        System.out.println("Result: " + division.solution(3, 2));
        System.out.println("Result: " + division.solution(7, 3));
        System.out.println("Result: " + division.solution(1, 16));
    }
}
