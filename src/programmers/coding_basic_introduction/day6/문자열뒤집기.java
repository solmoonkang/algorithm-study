package programmers.coding_basic_introduction.day6;

public class 문자열뒤집기 {

    /**
     * 문자열 my_string이 매개변수로 주어집니다.
     * my_string을 거꾸로 뒤집은 문자열을 반환하라.
     */
    public String solution(String my_string) {
        StringBuilder stringBuilder = new StringBuilder(my_string);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        문자열뒤집기 reverse = new 문자열뒤집기();
        System.out.println("Result: " + reverse.solution("jaron"));
        System.out.println("Result: " + reverse.solution("bread"));
    }
}
