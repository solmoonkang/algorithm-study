package 입문문제.day14;

public class 가까운수 {

    /**
     * [ 문제 설명 ]
     * 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 반환하라.
     */
    public int solution(int[] array, int n) {
        int nearest = array[0];

        for (int arr : array) {
            // n과 arr 사이의 절대값 차이가 n과 nearest 사이의 절대값 차이보다 작은지를 확인하는 조건이다.
            if (Math.abs(n - arr) < Math.abs(n - nearest)) {
                nearest = arr;
            // 가장 가까운 수가 여러 개일 경우, 가장 작은 수를 반환하는 조건이다.
            } else if (Math.abs(n - arr) == Math.abs(n - nearest) && arr < nearest) {
                // arr와 nearest가 n과 같은 거리에 있고, arr가 nearest보다 작은 경우, nearest를 arr로 업데이트한다.
                nearest = arr;
            }
        }

        return nearest;
    }

    public static void main(String[] args) {
        가까운수 nearestNumber = new 가까운수();
        int[] firstArray = {3, 10, 28};
        int[] secondArray = {10, 11, 12};
        System.out.println("Result: " + nearestNumber.solution(firstArray, 20));
        System.out.println("Result: " + nearestNumber.solution(secondArray, 13));
    }
}
