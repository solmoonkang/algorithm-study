package programmers.coding_basic_introduction.day9;

public class 가위바위보 {

    /**
     * 가위는 2 바위는 0 보는 5로 표현합니다.
     * 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
     * rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 반환하라.
     */
    public String solution(String rsp) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '2') {
                builder.append('0');
            } else if (rsp.charAt(i) == '0') {
                builder.append('5');
            } else {
                builder.append('2');
            }
        }
        return builder.toString();
    }

    public String solution_other(String rsp) {
        StringBuilder builder = new StringBuilder();

        for (char r : rsp.toCharArray()) {
            switch (r) {
                case '2':
                    builder.append('0');
                    break;
                case '0':
                    builder.append('5');
                    break;
                case '5':
                    builder.append('2');
                    break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        가위바위보 rockPaperScissors = new 가위바위보();
        System.out.println("Result: " + rockPaperScissors.solution("2"));
        System.out.println("Result: " + rockPaperScissors.solution("205"));
    }
}
