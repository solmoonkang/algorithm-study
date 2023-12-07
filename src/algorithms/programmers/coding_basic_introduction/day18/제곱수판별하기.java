package algorithms.programmers.coding_basic_introduction.day18;

public class 제곱수판별하기 {

    /**
     * [ 문제 설명 ]
     * 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 반환하라.
     */
    public int solution(int n) {
        return Math.sqrt(n) == Math.floor(Math.sqrt(n)) ? 1 : 2;
    }

    public static void main(String[] args) {
        제곱수판별하기 determineSquareNumber = new 제곱수판별하기();
        System.out.println("Result: " + determineSquareNumber.solution(144));
        System.out.println("Result: " + determineSquareNumber.solution(976));
    }
}
