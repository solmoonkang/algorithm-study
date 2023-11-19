package programmers.coding_basic_introduction.day4;

public class 피자나눠먹기2 {

    /**
     * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다.
     * 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
     * n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 반환하라
     */
    public int solution(int n) {
        int answer = n;

        while (answer % 6 != 0) {
            answer += n;
        }

        return answer / 6;
    }

    public static void main(String[] args) {
        피자나눠먹기2 pizza = new 피자나눠먹기2();
        System.out.println("Result: " + pizza.solution(6));
        System.out.println("Result: " + pizza.solution(10));
        System.out.println("Result: " + pizza.solution(4));
    }
}
