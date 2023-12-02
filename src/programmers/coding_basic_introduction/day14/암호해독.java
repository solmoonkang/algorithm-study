package programmers.coding_basic_introduction.day14;

import java.security.spec.RSAOtherPrimeInfo;

public class 암호해독 {

    /**
     * [ 문제 설명 ]
     * 군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다. 암호화된 문자열 cipher를 주고받습니다.
     * 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
     * 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 반환하라.
     */
    public String solution(String cipher, int code) {
        StringBuilder builder = new StringBuilder();

        for (int i = code - 1; i < cipher.length(); i += code) {
            char c = cipher.charAt(i);
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        암호해독 decryption = new 암호해독();
        System.out.println("Result: " + decryption.solution("dfjardstddetckdaccccdegk", 4));
        System.out.println("Result: " + decryption.solution("pfqallllabwaoclk", 2));
    }
}
