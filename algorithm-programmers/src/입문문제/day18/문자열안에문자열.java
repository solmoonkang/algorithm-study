package 입문문제.day18;

public class 문자열안에문자열 {

    /**
     * [ 문제 설명 ]
     * 문자열 str1, str2가 매개변수로 주어집니다. str1 안에 str2가 있다면 1을 없다면 2를 반환하라.
     */
    public int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }

    public static void main(String[] args) {
        문자열안에문자열 stringWithinString = new 문자열안에문자열();
        System.out.println("Result: " + stringWithinString.solution("ab6CDE443fgh22iJKlmn1o", "6CD"));
        System.out.println("Result: " + stringWithinString.solution("ppprrrogrammers", "pppp"));
        System.out.println("Result: " + stringWithinString.solution("AbcAbcA", "AAA"));
    }
}
