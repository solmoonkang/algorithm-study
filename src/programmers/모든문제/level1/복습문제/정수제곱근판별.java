package programmers.모든문제.level1.복습문제;

public class 정수제곱근판별 {

    // TODO: Math 함수에 대해서 필요한 것들 몇 개는 암기해두자.
    public long solution(long n) {
        long x = (long) Math.sqrt(n);
        return x * x == n ? (long) Math.pow(x + 1, 2) : -1;
    }

    public static void main(String[] args) {
        정수제곱근판별 problem = new 정수제곱근판별();

        System.out.println("problem = " + problem.solution(121));
        System.out.println("problem = " + problem.solution(3));
    }
}
