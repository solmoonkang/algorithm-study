package programmers.coding_basic_introduction.day14;

public class 대문자와소문자 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 반환하라.
     */
    public String solution(String my_string) {
        // TODO: Character 메소드에 대해서 더 공부가 필요하다.
        StringBuilder builder = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (Character.isUpperCase(c)) {
                builder.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                builder.append(Character.toUpperCase(c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        대문자와소문자 upperLowerCase = new 대문자와소문자();
        System.out.println("Result: " + upperLowerCase.solution("cccCCC"));
        System.out.println("Result: " + upperLowerCase.solution("abCdEfghIJ"));
    }
}
