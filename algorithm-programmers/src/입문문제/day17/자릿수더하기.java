package 입문문제.day17;

public class 자릿수더하기 {

    /**
     * [ 문제 설명 ]
     * 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 반환하라.
     */
    public int solution(int n) {
        int sumDigit = 0;
        for (char digit : String.valueOf(n).toCharArray()) {
            sumDigit += Character.getNumericValue(digit);
        }
        return sumDigit;
    }

    public static void main(String[] args) {
        자릿수더하기 sumOfDigits = new 자릿수더하기();
        System.out.println("Result: " + sumOfDigits.solution(1234));
        System.out.println("Result: " + sumOfDigits.solution(930211));
    }
}
