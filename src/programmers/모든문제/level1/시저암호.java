package programmers.모든문제.level1;

public class 시저암호 {

    /**
     * [ 문제 설명 ]
     * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
     * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
     */

    /**
     * [ 제한 조건 ]
     * 공백은 아무리 밀어도 공백입니다.
     * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
     * s의 길이는 8000이하입니다.
     * n은 1 이상, 25이하인 자연수입니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 문자열 분석: 입력된 문자열 s를 문자 단위로 분석합니다.
     *  - 문자열의 각 문자에 대해 반복문을 실행하여 각 문자가 알파벳인지, 공백인지 판단합니다.
     *
     * 2. 알파벳 판별 및 변환: 문자가 알파벳일 경우, 해당 문자가 대문자인지 소문자인지를 판별합니다.
     *  - ASCII 코드를 활용하거나 Character 클래스의 메소드(isLowerCase(), isUpperCase())를 사용할 수 있습니다.
     *
     * 3. 암호화: 각 알파벳 문자를 주어진 거리 n만큼 밀어 암호화합니다.
     *  - 이 때, 'z'에서 더 밀 경우 'a'로 돌아가야 하며, 'Z'에서 더 밀 경우 'A'로 돌아가야 합니다.
     *  - 이를 위해 모듈로(%) 연산을 이용하여 알파벳을 순환시킬 수 있습니다.
     *
     * 4. 공백 처리: 문자가 공백일 경우, 그대로 공백으로 둡니다.
     *  - 공백 문자는 암호화 과정을 거치지 않습니다.
     *
     * 5. 결과 문자열 생성: 변환된 문자들을 새로운 문자열에 추가하여 결과 문자열을 생성합니다.
     *  - StringBuilder 또는 StringBuffer를 사용하여 효율적으로 문자열을 조합할 수 있습니다.
     *
     * 6. 결과 반환: 최종적으로 생성된 암호화된 문자열을 반환합니다.
     */
    public String solution(String s, int n) {
        // TODO: 알파벳 연산이 미흡하다. 관련된 문제들을 많이 풀어보면서 익숙해지도록 하자.
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }

            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        시저암호 caesarCipher = new 시저암호();

        System.out.println("caesarCipher = " + caesarCipher.solution("AB", 1));

        System.out.println("caesarCipher = " + caesarCipher.solution("z", 1));

        System.out.println("caesarCipher = " + caesarCipher.solution("a B z", 4));
    }
}
