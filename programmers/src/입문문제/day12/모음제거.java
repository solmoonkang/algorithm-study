package 입문문제.day12;

public class 모음제거 {

    /**
     * [ 문제 설명 ]
     * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
     * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 반환하라.
     */
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }

    public static void main(String[] args) {
        모음제거 removeVowels = new 모음제거();
        System.out.println("Result: " + removeVowels.solution("bus"));
        System.out.println("Result: " + removeVowels.solution("nice to meet you"));
    }
}
