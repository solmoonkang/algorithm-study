package algorithms.programmers.coding_all_problem.level1.codechallenge3;

public class 나머지가일이되는수찾기 {

    /**
     * [ 문제 설명 ]
     * 자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 반환하라.
     */
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        나머지가일이되는수찾기 findNumberRemainderOfOne = new 나머지가일이되는수찾기();
        System.out.println("Result: " + findNumberRemainderOfOne.solution(10));
        System.out.println("Result: " + findNumberRemainderOfOne.solution(12));
    }
}
