package programmers.모든문제.level1.복습문제;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int count = 0;
        int lastPainted = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] > lastPainted) {
                count++;
                lastPainted = section[i] + m - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        덧칠하기 problem = new 덧칠하기();

        int[] section1 = {2, 3, 6};
        System.out.println("problem = " + problem.solution(8, 4, section1));

        int[] section2 = {1, 3};
        System.out.println("problem = " + problem.solution(5, 4, section2));

        int[] section3 = {1, 2, 3, 4};
        System.out.println("problem = " + problem.solution(4, 1, section3));
    }
}
