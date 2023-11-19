package programmers.coding_basic_introduction.day4;

public class 피자나눠먹기1 {

    /**
     * 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
     * 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 반환하라
     */
    public int solution(int n) {
        // 7의 배수인지 확인하고
        if (n % 7 == 0) {
            // 7의 배수이면 해당 값의 몫을 반환하고
            return n / 7;
        }
        // 7의 배수가 아니면 해당 값의 몫에 1을 더해서 반환환다.
        return (n / 7) + 1;
    }

    public static void main(String[] args) {
        피자나눠먹기1 pizza = new 피자나눠먹기1();
        System.out.println("Result: " + pizza.solution(7));
        System.out.println("Result: " + pizza.solution(1));
        System.out.println("Result: " + pizza.solution(15));
    }
}
