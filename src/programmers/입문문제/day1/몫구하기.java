package programmers.입문문제.day1;

public class 몫구하기 {

    /**
     * 정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 반환하라
     */

    public int solution(int num1, int num2) {
        return num1 / num2;
    }

    public static void main(String[] args) {
        몫구하기 share = new 몫구하기();

        System.out.println("Result: " + share.solution(10, 5));
        System.out.println("Result: " + share.solution(7, 2));
    }
}
