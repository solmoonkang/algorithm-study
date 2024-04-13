package 연습문제풀이.알고리즘.투포인터;

public class 투포인터합 {

    /**
     * 투 포인터 합
     * 주어진 정수 배열에서 두 개의 숫자를 선택하여 합이 특정한 값을 갖는지 확인한다.
     *
     * 예를 들어, 주어진 정수 배열에서 두 개의 숫자를 선택하여 합이 특정한 값을 갖는지 확인하는 문제이다.
     * 1. Left와 Right라는 두 개의 포인터를 배열의 양 끝에서 시작한다.
     * 2. Left 값 보다 Right 값이 큰 경우일 때까지 반복한다.
     * 3. Left와 Right의 합을 sum에 저장한다.
     * 4. 만약, sum이 target과 같다면, count의 값을 증가하고, Left 인덱스는 오른쪽으로 이동하며 Right 인덱스는 왼쪽으로 이동한다.
     * 5. 만약, sum이 target보다 작다면, Left를 한 칸 오른쪽으로 이동시킨다.
     * 6. 만약, sum이 target보다 크다면, Right를 한 칸 왼쪽으로 이동시킨다.
     * 주어진 조건에 만족하는 count 값을 반환한다.
     */
    public int solution(int[] numbers, int target) {
        int count = 0;

        // 1. left와 right라는 두 개의 포인터를 배열의 양 끝에서 시작한다.
        int left = 0;
        int right = numbers.length - 1;

        // 2. left 값보다 right 값이 더 큰 경우일 때까지 반복한다.
        while (left < right) {

            // 3. left 값과 right 값의 합을 sum 변수에 저장한다.
            int sum = numbers[left] + numbers[right];

            // 4-1. sum 값이 target 값과 같다면, count 값을 증가하고 left는 오른쪽으로 이동, right는 왼쪽으로 이동시킨다.
            if (sum == target) {
                count++;
                left++;
                right--;
            // 4-2. sum 값이 target 값보다 작다면, left를 한 칸 오른쪽으로 이동시킨다.
            } else if (sum < target) {
                left++;
            // 4-3. sum 값이 target 값보다 크다면, right를 한 칸 왼쪽으로 이동시킨다.
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        투포인터합 twoPointerSum = new 투포인터합();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int target = 12;
        System.out.println("twoPointerSum = " + twoPointerSum.solution(numbers, target));
    }
}
