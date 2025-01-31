package 기출문제.PCCE기출문제.LV0;

import java.util.Arrays;

public class 심폐소생술 {

    public int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for (int i = 0; i < cpr.length; i++) {
            for (int j = 0; j < basic_order.length; j++) {
                if (cpr[i].equals(basic_order[j])) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        심폐소생술 problem = new 심폐소생술();

        String[] cpr1 = {"call", "respiration", "repeat", "check", "pressure"};
        System.out.println("problem = " + Arrays.toString(problem.solution(cpr1)));

        String[] cpr2 = {"respiration", "repeat", "check", "pressure", "call"};
        System.out.println("problem = " + Arrays.toString(problem.solution(cpr2)));
    }
}
