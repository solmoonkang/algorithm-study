package 입문문제.day1;

public class 두수의곱 {

    /**
     * 정수 num1, num2가 매개변수 주어집니다. num1과 num2를 곱한 값을 반환하라
     */

    public int solution(int num1, int num2) {
        return num1 * num2;
    }

    public static void main(String[] args) {
        두수의곱 multi = new 두수의곱();

        System.out.println("Result: " + multi.solution(3, 4));
        System.out.println("Result: " + multi.solution(27, 19));
    }
}
