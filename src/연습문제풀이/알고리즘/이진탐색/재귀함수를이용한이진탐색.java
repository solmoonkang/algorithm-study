package 연습문제풀이.알고리즘.이진탐색;

public class 재귀함수를이용한이진탐색 {

    /**
     * 재귀 함수를 이용한 이진 탐색
     * 1. 높은 인덱스가 낮은 인덱스보다 크거나 같은지 확인한다.
     * 2. 중간 값을 구한다.
     * 3. 배열의 요소 값이 찾는 값과 동일하면 중간 값을 반환한다.
     * 4. 중간 값이 찾는 값(key)보다 큰 경우: 낮은 인덱스와 중간 인덱스에서 1을 뺀 값을 가지고 재귀 함수를 호출한다.
     * 5. 중간 값이 찾는 값(key)보다 작은 경우: 중간 인덱스에 1을 더하고 높은 인덱스와 함께 재귀 함수를 호출한다.
     */
    public int solution(int[] array, int key) {

        // 시작 인덱스와 마지막 인덱스의 값을 지정한다.
        int low = 0;
        int high = array.length - 1;

        return recursiveBinarySearch(array, low, high, key);
    }

    private int recursiveBinarySearch(int[] array, int low, int high, int key) {

        // 높은 인덱스가 낮은 인덱스보다 크거나 같은지 확인한다.
        if (high >= low) {

            // 중간 값을 구한다.
            int mid = low + (high - low) / 2;

            // 배열의 요소 값이 찾는 값과 동일하면 중간 값을 반환한다.
            if (array[mid] == key) return mid;

            // 중간 값이 찾는 값(key)보다 큰 경우: 낮은 인덱스와 중간 인덱스에서 1을 뺀 값을 가지고 재귀 호출한다.
            else if (array[mid] > key) return recursiveBinarySearch(array, low - 1, high - 1, key);

            // 중간 값이 찾는 값(key)보다 작은 경우: 중간 인덱스에 1을 더하고 높은 인덱스와 함께 재귀 호출한다.
            else return recursiveBinarySearch(array, mid + 1, high, key);
        }

        return -1;
    }

    public static void main(String[] args) {
        재귀함수를이용한이진탐색 binarySearch = new 재귀함수를이용한이진탐색();

        int[] array = {1, 3, 5, 8, 11, 15, 30, 32, 45};     // 전체 배열
        int key = 8;                                        // 찾고자 하는 키 값
        System.out.println("binarySearch = " + binarySearch.solution(array, key));
    }
}
