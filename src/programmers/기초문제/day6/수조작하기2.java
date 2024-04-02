package programmers.기초문제.day6;

public class 수조작하기2 {     // Review Required

    public String solution(int[] numLog) {

        String answer = "";

        for (int i = 1; i < numLog.length; i++) {

            if (numLog[i] - numLog[i - 1] == 1) {

                answer += 'w';
            }

            else if (numLog[i] - numLog[i - 1] == -1) {

                answer += 's';
            }

            else if (numLog[i] - numLog[i - 1] == 10) {

                answer += 'd';
            }

            else {

                answer += 'a';
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        수조작하기2 control = new 수조작하기2();

        int[] log = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};

        System.out.println("Result : " + control.solution(log));
    }
}
