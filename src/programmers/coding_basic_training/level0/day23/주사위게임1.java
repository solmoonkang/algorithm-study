package programmers.coding_basic_training.level0.day23;

public class 주사위게임1 {

    public int solution(int a, int b) {

        // A와 B가 모두 홀수라면, A^2 + B^2 점을 얻는다
        // A와 B 중 하나만 홀수라면 2 * (A + B) 점을 얻는다
        // A와 B 모두 홀수가 아니라면 |A - B| 점을 얻는다
        // 위 과정을 고려하여 얻는 점수를 반환하라

        int answer = 0;

        if (a % 2 != 0 && b % 2 != 0) {

            answer = Math.addExact((a * a), (b * b));

        } else if (a % 2 != 0 || b % 2 != 0) {

            answer = 2 * Math.addExact(a, b);

        } else {

            answer = Math.abs(a - b);

        }

        return answer;
    }

    public static void main(String[] args) {

        주사위게임1 dice = new 주사위게임1();

        System.out.println("Result : " + dice.solution(3, 5));
        System.out.println("Result : " + dice.solution(6, 1));
        System.out.println("Result : " + dice.solution(2, 4));
    }
}
