package programmers.입문문제.day17;

import java.util.Arrays;

public class OX퀴즈 {

    /**
     * [ 문제 설명 ]
     * 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
     * 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 반환하라.
     */
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");

            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[2]);
            int z = Integer.parseInt(parts[parts.length - 1]);

            switch (parts[1]) {
                case "+":
                    answer[i] = (x + y == z) ? "O" : "X";
                    break;
                case "-":
                    answer[i] = (x - y == z) ? "O" : "X";
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        OX퀴즈 quiz = new OX퀴즈();
        String[] firstQuiz = {"3 - 4 = -3", "5 + 6 = 11"};
        String[] secondQuiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
        System.out.println("Result: " + Arrays.toString(quiz.solution(firstQuiz)));
        System.out.println("Result: " + Arrays.toString(quiz.solution(secondQuiz)));
    }
}
