package programmers.coding_basic_introduction.day2;

public class 숫자비교하기 {

    /**
     * 정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 반환하라
     */
    public int solution(int num1, int num2) {
        return (num1 == num2) ? 1 : -1;
    }

    public static void main(String[] args) {
        숫자비교하기 compare = new 숫자비교하기();
        System.out.println("Result: " + compare.solution(2, 3));
        System.out.println("Result: " + compare.solution(11, 11));
        System.out.println("Result: " + compare.solution(7, 99));
    }
}
