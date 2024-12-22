package programmers.기출문제.PCCP기출문제;

import java.util.Arrays;

public class 퍼즐게임챌린지 {

    public int solution(int[] diffs, int[] times, long limit) {
        int skillLevel = 1;

        int N = diffs.length;
        int[] maxLevelDiffs = Arrays.copyOf(diffs, N);

        Arrays.sort(maxLevelDiffs);
        int maxLevel = maxLevelDiffs[N - 1];
        long[] timeSpentByLevel = new long[maxLevel];

        while (skillLevel < maxLevel + 1) {
            int fullTime = times[0];

            for (int i = 1; i < N; i++) {
                int currentLevel = diffs[i];
                int currentTime = times[i];
                int previousTime = times[i - 1];
                int wrongTime = currentLevel - skillLevel;

                if (skillLevel < currentLevel) fullTime += (wrongTime * (previousTime + currentTime)) + currentTime;
                else fullTime += currentTime;
            }

            timeSpentByLevel[skillLevel - 1] = fullTime;
            skillLevel++;
        }

        int minSkillLevel = 0;
        for (int i = 1; i < maxLevel; i++) {
            if (timeSpentByLevel[i - 1] <= limit) {
                minSkillLevel = i;
                break;
            }
        }

        return minSkillLevel;
    }

    public static void main(String[] args) {
        퍼즐게임챌린지 problem = new 퍼즐게임챌린지();

        int[] diffs1 = {1, 5, 3};
        int[] times1 = {2, 4, 7};
        long limit1 = 30;
        System.out.println("problem = " + problem.solution(diffs1, times1, limit1));


        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59;
        System.out.println("problem = " + problem.solution(diffs2, times2, limit2));


        int[] diffs3 = {1, 328, 467, 209, 54};
        int[] times3 = {2, 7, 1, 4, 3};
        long limit3 = 1723;
        System.out.println("problem = " + problem.solution(diffs3, times3, limit3));


        int[] diffs4 = {1, 99999, 100000, 99995};
        int[] times4 = {9999, 9001, 9999, 9001};
        long limit4 = 3456789012L;
        System.out.println("problem = " + problem.solution(diffs4, times4, limit4));

    }
}
