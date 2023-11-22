package programmers.coding_basic_introduction.day7;

public class 특정문자제거하기 {

    /**
     * 문자열 my_string과 문자 letter이 매개변수로 주어집니다.
     * my_string에서 letter를 제거한 문자열을 반환하라.
     */
    public String solution(String my_string, String letter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(my_string.replace(letter, ""));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        특정문자제거하기 removeSpecificChar = new 특정문자제거하기();
        System.out.println("Result: " + removeSpecificChar.solution("abcdef", "f"));
        System.out.println("Result: " + removeSpecificChar.solution("BCBdbe", "B"));
    }
}
