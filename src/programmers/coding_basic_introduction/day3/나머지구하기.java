package programmers.coding_basic_introduction.day3;

public class 나머지구하기 {

    /**
     * 정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 반환하라
     */
    public int solution(int num1, int num2) {
        return num1 % num2;
    }

    public static void main(String[] args) {
        나머지구하기 mod = new 나머지구하기();
        System.out.println("Result: " + mod.solution(3, 2));
        System.out.println("Result: " + mod.solution(10, 5));
    }
}
