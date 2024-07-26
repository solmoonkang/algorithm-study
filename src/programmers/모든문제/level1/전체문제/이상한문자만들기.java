package programmers.모든문제.level1.전체문제;

public class 이상한문자만들기 {

    /**
     * [ 문제 설명 ]
     * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
     * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
     * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
     */

    /**
     * [ 제한 사항 ]
     * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
     * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
     */
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                index = 0;
                builder.append(" ");
            } else {
                builder.append((index++ % 2 == 0) ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        이상한문자만들기 createStrangeCharacters = new 이상한문자만들기();
        System.out.println("Result: " + createStrangeCharacters.solution("try hello world"));
    }
}
