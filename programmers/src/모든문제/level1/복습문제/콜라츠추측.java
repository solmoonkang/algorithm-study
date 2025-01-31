package 모든문제.level1.복습문제;

public class 콜라츠추측 {

    public int solution(int num) {
        long number = num;
        if (number == 1) return 0;

        int count = 0;
        while (number != 1) {
            if (number % 2 == 0) number /= 2;
            else number = ((number * 3) + 1);
            count++;

            if (count == 500) return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        콜라츠추측 problem = new 콜라츠추측();

        System.out.println("problem = " + problem.solution(6));
        System.out.println("problem = " + problem.solution(16));
        System.out.println("problem = " + problem.solution(626331));
    }
}
