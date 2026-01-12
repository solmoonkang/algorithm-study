package 모든문제.level1.알고리즘고득점KIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] giveUpMath1 = {1, 2, 3, 4, 5};
        int[] giveUpMath2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUpMath3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giveUpMath1[i % giveUpMath1.length]) count1++;
            if (answers[i] == giveUpMath2[i % giveUpMath2.length]) count2++;
            if (answers[i] == giveUpMath3[i % giveUpMath3.length]) count3++;
        }

        int maxScore = Math.max(count1, Math.max(count2, count3));
        List<Integer> winners = new ArrayList<>();

        if (count1 == maxScore) winners.add(1);
        if (count2 == maxScore) winners.add(2);
        if (count3 == maxScore) winners.add(3);

        return winners.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        모의고사 problem = new 모의고사();

        int[] answers1 = {1, 2, 3, 4, 5};
        System.out.println("problem = " + Arrays.toString(problem.solution(answers1)));

        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println("problem = " + Arrays.toString(problem.solution(answers2)));
    }
}
