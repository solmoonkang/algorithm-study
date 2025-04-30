package 입문문제.day10;

public class 공던지기 {

    public int solution(int[] numbers, int k) {
        return numbers[2 * (k - 1) % numbers.length];
    }

    public static void main(String[] args) {
        공던지기 throwBall = new 공던지기();
        int[] firstNumbers = {1, 2, 3, 4};
        int[] secondNumbers = {1, 2, 3, 4, 5, 6};
        int[] thirdNumbers = {1, 2, 3};
        System.out.println("Result: " + throwBall.solution(firstNumbers, 2));
        System.out.println("Result: " + throwBall.solution(secondNumbers, 5));
        System.out.println("Result: " + throwBall.solution(thirdNumbers, 3));
    }
}
