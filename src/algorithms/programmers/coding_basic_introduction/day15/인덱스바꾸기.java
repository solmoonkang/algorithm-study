package algorithms.programmers.coding_basic_introduction.day15;

public class 인덱스바꾸기 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
     * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 반환하라.
     */
    public String solution(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();

        char swap = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = swap;

        return new String(chars);
    }

    public static void main(String[] args) {
        인덱스바꾸기 convertIndex = new 인덱스바꾸기();
        System.out.println("Result: " + convertIndex.solution("hello", 1, 2));
        System.out.println("Result: " + convertIndex.solution("I love you", 3, 6));
    }
}
