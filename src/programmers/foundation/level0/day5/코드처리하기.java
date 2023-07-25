package programmers.foundation.level0.day5;

public class 코드처리하기 {

    /** 문제 설명
     *
     *  mode 가 0일 때,
     *      code[idx] 가 1이 아니면, idx 가 짝수일 때만 ret 의 맨 뒤에 code[idx] 를 추가한다
     *      code[idx] 가 1이면, mode 를 0에서 1로 바꾼다
     *
     *  mode 가 1일 때,
     *      code[idx]가 1이 아니면, idx 가 홀수일 때만 ret 의 맨 뒤에 code[idx]를 추가
     *      code[idx]가 1이면, mode 를 1에서 0으로 바꾼다
     */

    public String solution_my(String code) {

        String answer = "";

        char mode = '0';

        for (int i = 0; i < code.length(); i++) {

            if (code.charAt(i) == '1') {

                mode = (mode == '0' ? '1' : '0');

                continue;
            }

            if (mode == '0') {

                // 짝수
                if (i % 2 == 0) {
                    answer += code.charAt(i);
                }
            } else {

                // 홀수
                if (i % 2 != 0) {
                    answer += code.charAt(i);
                }
            }
        }

        return answer;
    }

    public String solution_best(String code) {

        String answer = "";

        return answer;
    }

    public static void main(String[] args) {

        코드처리하기 code = new 코드처리하기();

        System.out.println("Result My : " + code.solution_my("abc1abc1abc"));
        System.out.println("==============================================");

        System.out.println("Result Best : " + code.solution_best("abc1abc1abc"));
    }
}
