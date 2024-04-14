package 연습문제풀이.알고리즘.이진탐색;

public class 배열내의숫자탐색 {

    /**
     * 이진 탐색 알고리즘의 숫자 탐색
     * 배열 내의 숫자를 찾는 문제이다.
     * while 문으로 정렬된 배열 array에서 key값을 찾는 문제로, 다음과 같은 풀이 흐름을 갖는다.
     * 1. low는 첫 번째 인덱스, high는 마지막 인덱스를 저장한다.
     * 2. 마지막 인덱스보다 첫 번째 인덱스가 같거나 작을 경우까지 순회한다.
     * 3. 중간 값인 mid를 구한다.
     * 4. 중간 값보다 찾으려는 key가 큰 경우, 중간 값에 1을 더해서 오른쪽 절반을 탐색한다.
     * 5. 중간 값보다 찾으려는 key가 작은 경우, 중간 값에 1을 빼고 왼쪽 절반만 탐색한다.
     * 6. 그 외의 경우에는 중간 값을 최종 값으로 반환한다.
     *  - 최종 탐색을 못한 경우에 최종 값은 -1을 반환한다.
     */
    public int solution(int[] array, int key) {

        // 시작 인덱스와 마지막 인덱스의 값을 지정한다.
        int low = 0;
        int high = array.length - 1;

        // 마지막 인덱스보다 시작 인덱스가 작거나 같아질 때까지 순회한다.
        while (low <= high) {

            // 중간 값을 구한다.
            int mid = (low + high) / 2;

            // 중간 값보다 찾으려는 값(key)가 큰 경우: 중간 값에 1을 더해 오른쪽 절반을 탐색한다.
            if (array[mid] < key) low = mid + 1;

            // 중간 값보다 찾으려는 값(key)가 작은 경우: 중간 값에서 1을 빼서 왼쪽 절반을 탐색한다.
            else if (array[mid] > key) high = mid - 1;

            // 해당 경우가 아닌 경우 중간 값을 최종 값으로 반환한다.
            else return mid;
        }

        // 최종 탐색을 하지 못할 경우 -1을 반환한다.
        return -1;
    }

    public static void main(String[] args) {
        배열내의숫자탐색 binarySearch = new 배열내의숫자탐색();

        int[] array = {1, 3, 5, 8, 11, 15, 30, 32, 45};     // 전체 배열
        int key = 8;                                        // 찾고자 하는 키 값
        System.out.println("binarySearch = " + binarySearch.solution(array, key));
    }
}
