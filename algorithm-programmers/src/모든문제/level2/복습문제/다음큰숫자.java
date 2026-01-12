package 모든문제.level2.복습문제;

public class 다음큰숫자 {

    public int solution(int n) {
        int targetCount = Integer.bitCount(n);
        int nextNumber = n + 1;

        while (true) {
            if (Integer.bitCount(nextNumber) == targetCount) return nextNumber;
            nextNumber++;
        }
    }

    public static void main(String[] args) {
        다음큰숫자 problem = new 다음큰숫자();

        System.out.println("problem = " + problem.solution(78));
        System.out.println("problem = " + problem.solution(15));
    }
}
