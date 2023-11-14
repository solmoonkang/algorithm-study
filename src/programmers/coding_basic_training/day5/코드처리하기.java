package programmers.coding_basic_training.day5;

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

    public String solution(String code) {

        String answer = "";

        int mode = 0;

        for (int i = 0; i < code.length(); i++) {

            // 만약, code 에 1이 있다면,
            if (code.charAt(i) == '1') {

                // 모드를 토글한다 즉, 0은 1로, 1은 0으로 변경
                mode = 1 - mode;

            // 만약, 1이 아닌, 모드에 따라 문자를 선택할 경우,
            } else if (i % 2 == mode) {

                // answer 에 현재 문자를 추가하며 또한 모드 값과 인덱스의 홀짝 여부를 비교하여 문자 선택 규칙을 적용
                answer += code.charAt(i);

            }
        }

        // 결과 문자열이 비어있는 경우, "EMPTY" 를 반환하고, 그렇지 않은 경우, 결과 문자열을 반환
        return "".equals(answer) ? "EMPTY" : answer;
    }

    public static void main(String[] args) {

        코드처리하기 code = new 코드처리하기();

        System.out.println("Result : " + code.solution("abc1abc1abc"));
    }
}
