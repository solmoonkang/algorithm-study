package 연습문제풀이.알고리즘.투포인터;

public class 투포인터슬라이딩윈도우 {

    /**
     * 투 포인터 슬라이딩 윈도우
     * 고정된 길이의 윈도우를 배열이나 리스트에서 슬라이딩하면서 특정 조건을 만족하는 부분 구간을 찾는다.
     *
     * 예를 들어, 배열에서 K의 길이만큼의 합 중 최대 값을 찾는 문제이다.
     * 1. 초기 윈도우의 합을 계산한다.
     * 2. 윈도우를 이동하며 최대값을 찾는다.
     * 3. 최대값을 반환한다.
     */
    public int solution(int[] numbers, int K) {
        int maxSum = 0;
        int currentSum = 0;

        // 1. 초기 윈도우의 합을 계산한다.
        for (int i = 0; i < K; i++) {
            currentSum += numbers[i];
        }

        maxSum = currentSum;

        // 2. 윈도우를 이동하며 최대값을 찾는다.
        for (int i = K; i < numbers.length; i++) {
            // 윈도우를 한 칸씩 오른쪽으로 이동시키며, 새로운 윈도우의 합을 계산한다.
            // 이때, 매번 모든 숫자를 다시 더하는 것이 아닌, 이전 윈도우의 합에서 가장 왼쪽에 있던 숫자를 빼고, 새로 들어온 오른쪽 숫자를 더해준다.
            currentSum = currentSum - numbers[i - K] + numbers[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        // 3. 최대값을 반환한다.
        return maxSum;
    }

    public static void main(String[] args) {
        투포인터슬라이딩윈도우 twoPointerSlidingWindow = new 투포인터슬라이딩윈도우();

        int[] numbers = {2, 3, 1, 5, 4, 2, 3};
        int K = 3;
        System.out.println("twoPointerSlidingWindow = " +
                twoPointerSlidingWindow.solution(numbers, K));
    }
}
