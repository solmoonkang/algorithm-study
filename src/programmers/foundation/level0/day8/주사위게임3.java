package programmers.foundation.level0.day8;

public class 주사위게임3 {

    public int solution(int a, int b, int c, int d) {

        int answer = 0;

        if (a == b && b == c && c == d) {

            answer = 1111 * a;

        } else if ((a == b && b == c) || (a == b && b == d) || (b == c && c == d)) {

            if (a == b && b == c) {

                answer = (10 * a + d) ^ 2;

            } else if (a == b && b == d) {

                answer = (10 * a + c) ^ 2;

            } else if (b == c && c == d) {

                answer = (10 * b + a) ^ 2;

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        주사위게임3 game = new 주사위게임3();

        System.out.println("Result : " + game.solution(4, 1, 4, 4));
    }
}
