package algorithms.programmers.coding_basic_introduction.day7;

public class 양꼬치 {

    /**
     * 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
     * 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.
     * 정수 n과 k가 매개변수로 주어졌을 때, 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 반환하라.
     */
    public int solution(int n, int k) {
        return (12000 * n) + (2000 * k) - (2000 * (n / 10));
    }

    public static void main(String[] args) {
        양꼬치 lambSkewers = new 양꼬치();
        System.out.println("Result: " + lambSkewers.solution(10, 3));
        System.out.println("Result: " + lambSkewers.solution(64, 6));
    }
}
