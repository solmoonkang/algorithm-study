package programmers.coding_basic_introduction.day9;

public class 구슬을나누는경우의수 {

    /**
     * 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
     * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
     * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 반환하라.
     *
     * 서로 다른 N개 중 M개를 뽑는 경우의 수 = N! / (N - M)! * M!
     */
    private int combination(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        } else {
            return combination(n - 1, m - 1) + combination(n - 1, m);
        }
    }

    public int solution(int balls, int share) {
         return combination(balls, share);
    }

    public static void main(String[] args) {
        구슬을나누는경우의수 numberOfWaysToDivideMarbles = new 구슬을나누는경우의수();
        System.out.println("Result: " + numberOfWaysToDivideMarbles.solution(3, 2));
        System.out.println("Result: " + numberOfWaysToDivideMarbles.solution(5, 3));
    }
}
