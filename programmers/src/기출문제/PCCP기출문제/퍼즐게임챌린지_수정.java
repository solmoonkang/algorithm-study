package 기출문제.PCCP기출문제;

public class 퍼즐게임챌린지_수정 {

    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        int minSkillLevel = 0;

        while (start <= end) {
            int level = (start + end) / 2;
            long totalTime = calculateMinimumTotalTime(diffs, times, level);

            if (totalTime <= limit) {
                minSkillLevel = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }

        return minSkillLevel;
    }

    private long calculateMinimumTotalTime(int[] diffs, int[] times, int level) {
        long minTotalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int solveTimes = diffs[i] - level;

            if (solveTimes <= 0) {
                minTotalTime += times[i];
                continue;
            }

            if (i == 0) minTotalTime += (long) times[i] * solveTimes + times[i];
            else minTotalTime += (long) (times[i - 1] + times[i]) * solveTimes + times[i];
        }

        return minTotalTime;
    }

    public static void main(String[] args) {
        퍼즐게임챌린지_수정 problem = new 퍼즐게임챌린지_수정();

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
