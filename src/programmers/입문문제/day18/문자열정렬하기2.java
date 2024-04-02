package programmers.입문문제.day18;

public class 문자열정렬하기2 {

    /**
     * [ 문제 설명 ]
     * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
     * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 반환하라.
     */
    public String solution(String my_string) {
        return my_string.toLowerCase().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        문자열정렬하기2 sortStrings = new 문자열정렬하기2();
        System.out.println("Result: " + sortStrings.solution("Bcad"));
        System.out.println("Result: " + sortStrings.solution("heLLo"));
        System.out.println("Result: " + sortStrings.solution("Python"));
    }
}
