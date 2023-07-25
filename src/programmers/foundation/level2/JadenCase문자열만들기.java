package programmers.foundation.level2;

import java.util.StringTokenizer;

public class JadenCase문자열만들기 {

    public String solution(String s) {
        // " " 공백문자가 여러개 올 경우 split 함수는 오류가 발생하므로 tokenizer의 true로 사용하는 것이 좋음
        s = s.toLowerCase();    // 처음부터 모두 소문자로 변환시킨다

        StringTokenizer tokenizer = new StringTokenizer(s, " ", true);
        StringBuilder builder = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken();

            if (str.equals(" "))    // 만약 단어가 공백이면 그대로 출력하고
                builder.append(str);
            else {                  // 아닐 경우 첫글자를 대문자로 변환해준다
                builder.append(str.substring(0, 1).toUpperCase() + str.substring(1));
            }   // toUpperCase() : 대문자로 변환시킨다
        }

        System.out.println("JadenCcase :" + builder);
        return builder.toString();
    }

    public static void main(String[] args) {
        JadenCase문자열만들기 solution = new JadenCase문자열만들기();
        solution.solution("3people Unfollowed Me");
    }
}
