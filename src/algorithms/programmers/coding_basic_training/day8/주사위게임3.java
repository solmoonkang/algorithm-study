package algorithms.programmers.coding_basic_training.day8;

public class 주사위게임3 {

    public int solution(int a, int b, int c, int d) {

        // 절대값 계산 : Math.abs
        // 최대 / 최소값 계산 : Math.max, Math.min

        if (a == b && b == c && c == d) {   // a, b, c, d가 모두 같을 경우

            return 1111 * a;

        } else if (a == b && b == c) {  // a, b, c가 같을 경우

            return ((10 * a + d) * (10 * a + d));

        } else if (a == c && c == d) {  // a, c, d가 같을 경우

            return ((10 * a + b) * (10 * a + b));

        } else if (a == b && b == d) {  // a, b, d가 같을 경우

            return ((10 * a + c) * (10 * a + c));

        } else if (b == c && c == d) {  // b, c, d가 같을 경우

            return ((10 * b + a) * (10 * b + a));

        } else if (a == b && c == d) {  // a, b가 같고 c, d가 같을 경우

            return ((a + c) * (Math.abs(a - c)));

        } else if (a == c && b == d) {  // a, c가 같고, b, d가 같을 경우

            return ((a + b) * (Math.abs(a - b)));

        } else if (a == d && b == c) {  // a, d가 같고, b, c가 같을 경우

            return ((a + b) * (Math.abs(a - b)));

        } else if (a == b && c != d) {  // a, b가 같고, c, d가 다를 경우

            return (c * d);

        } else if (a == c && b != d) {  // a, c가 같고, b, d가 다를 경우

            return (b * d);

        } else if (a == d && b != c) {  // a, d가 같을 경우, b, c가 다를 경우

            return (b * c);

        } else if (b == c && a != d) {  // b, c가 같을 경우, a, d가 다를 경우

            return (a * d);

        } else if (b == d && a != c) {  // b, d가 같을 경우, a, c가 다를 경우

            return (a * c);

        } else {    // a, b, c, d가 모두 다를 경우

            return Math.min(Math.min(a, b), Math.min(c, d));

        }
    }

    public static void main(String[] args) {

        주사위게임3 game = new 주사위게임3();

        System.out.println("Result : " + game.solution(2, 2, 2, 2));
        System.out.println("Result : " + game.solution(4, 1, 4, 4));
        System.out.println("Result : " + game.solution(6, 3, 3, 6));
        System.out.println("Result : " + game.solution(2, 5, 2, 6));
        System.out.println("Result : " + game.solution(6, 4, 2, 5));
    }
}
