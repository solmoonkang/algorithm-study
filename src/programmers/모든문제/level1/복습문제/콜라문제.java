package programmers.모든문제.level1.복습문제;

public class 콜라문제 {

    // TODO: 빈 병 수를 업데이트하는 과정에서 계산 착오가 있었다.
    public int solution(int a, int b, int n) {
        int totalCola = 0;

        while (n >= a) {
            int receivedCola = (n / a) * b;
            totalCola += receivedCola;

            n = (n % a) + receivedCola;
        }

        return totalCola;
    }

    public static void main(String[] args) {
        콜라문제 problem = new 콜라문제();

        System.out.println("problem = " + problem.solution(2, 1, 20));
        System.out.println("problem = " + problem.solution(3, 1, 20));
    }
}
