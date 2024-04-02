package studying_algorithm.methodology.recursive;

public class MaxFinder {

    public int finder(int[] a, int n) {
        return arraySort(a, n);
    }

    private int arraySort(int[] a, int n) {
        int x = 0;

        // n이 1인 경우, 배열의 첫 번째 요소를 반환한다.
        if (n == 1) {
            return a[0];
        // n이 1보다 큰 경우, x에 arraySort(a, n - 1) 결과를 저장한다.
        // 이는 배열의 첫 번째 요소부터 (n - 1)번째 요소까지 중에서 최댓값을 찾는 것을 의미한다.
        } else {
            x = arraySort(a, n - 1);
        }

        // 그 다음, x와 n번째 요소 a[n - 1]를 비교한다. x가 더 크면 x를 반환하고,
        if (x > a[n - 1]) {
            return x;
        // 그렇지 않으면, a[n - 1]을 반환한다.
        } else {
            return a[n - 1];
        }
    }

    public static void main(String[] args) {
        MaxFinder max = new MaxFinder();
        int[] arr = {0, 80, 60, 40, 20, 100};
        System.out.println(max.finder(arr, 4));
    }
}
