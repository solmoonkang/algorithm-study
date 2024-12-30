package programmers.알고리즘고득점KIT.동적계획법;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {

    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            StringBuilder stringBuilder = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) stringBuilder.append(N);
            dp.get(i).add(Integer.parseInt(stringBuilder.toString()));

            for (int j = 1; j < i; j++) {
                int k = i - j;

                for (int number1 : dp.get(j)) {
                    for (int number2 : dp.get(k)) {
                        dp.get(i).add(number1 + number2);
                        dp.get(i).add(number1 - number2);
                        dp.get(i).add(number1 * number2);
                        if (number2 != 0) dp.get(i).add(number1 / number2);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        N으로표현 problem = new N으로표현();

        int N1 = 5, number1 = 12;
        System.out.println("problem = " + problem.solution(N1, number1));

        int N2 = 2, number2 = 11;
        System.out.println("problem = " + problem.solution(N2, number2));
    }
}
