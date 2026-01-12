package 기출문제.월간코드챌린지시즌2;

public class 약수의개수와덧셈 {

    /**
     * [ 문제 설명 ]
     * 두 정수 left와 right가 매개변수로 주어집니다.
     * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 반환하라.
     */
    public int solution(int left, int right) {
        int divisors = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                divisors += i;
            } else {
                divisors -= i;
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 numberOfDivisorsAndAddition = new 약수의개수와덧셈();
        System.out.println("Result: " + numberOfDivisorsAndAddition.solution(13, 17));
        System.out.println("Result: " + numberOfDivisorsAndAddition.solution(24, 27));
    }
}
