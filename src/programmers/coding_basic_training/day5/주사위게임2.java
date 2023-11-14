package programmers.coding_basic_training.day5;

public class 주사위게임2 {

    public int solution(int a, int b, int c) {

        int answer = 0;

        if (a != b && a != c && b != c) {

            answer = a + b + c;

        } else if ((a == b && b != c) || (b == c && c != a) || (a == c && a != b)) {

            answer = (a + b + c) * ((a * a) + (b * b) + (c * c));

        } else if (a == b && b == c) {

            answer = (a + b + c) * ((a * a) + (b * b) + (c * c)) * ((a * a * a) + (b * b * b) + (c * c * c));
        }

        return answer;
    }

    public static void main(String[] args) {

        주사위게임2 game = new 주사위게임2();

        System.out.println("Result : " + game.solution(2, 6, 1));
        System.out.println("Result : " + game.solution(5, 3, 3));
        System.out.println("Result : " + game.solution(4, 4, 4));
    }
}
