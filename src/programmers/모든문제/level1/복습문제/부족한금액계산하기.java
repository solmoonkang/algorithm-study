package programmers.모든문제.level1.복습문제;

public class 부족한금액계산하기 {

    public long solution(int price, int money, int count) {
        long fee = 0;
        for (int i = 1; i <= count; i++) {
            fee += (long) price * i;
        }

        return money > fee ? 0 : Math.abs(money - fee);
    }

    public static void main(String[] args) {
        부족한금액계산하기 problem = new 부족한금액계산하기();

        System.out.println("problem = " + problem.solution(3, 20, 4));
    }
}
