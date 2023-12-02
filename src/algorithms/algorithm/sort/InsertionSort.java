package algorithms.algorithm.sort;

public class InsertionSort {

    public static void main(String[] args) {

//        int[] numbers = {3, 5, 1, 2, 4};
//        int tempValue;
//        int target;
//
//        for (int i = 0; i < numbers.length; i++) {
//
//            // 선택된 숫자를 임시 저장
//            tempValue = numbers[i];
//
//            // 비교 대상의 위치
//            target = i - 1;
//
//            // 좌측 끝까지 가거나, 자신보다 작은 수를 만나기 전까지 이동하면서 삽입될 위치를 탐색
//            while (target >= 0 && numbers[target] > tempValue) {
//
//                // 본인보다 큰 수는 우측으로 한 칸 이동
//                numbers[target + 1] = numbers[target];
//                // 그 다음 비교 대상을 좌측으로 한 칸 이동
//                target--;
//            }
//
//            // 적정한 위치를 찾아 선택된 숫자를 삽입
//            numbers[target + 1] = tempValue;
//        }
//
//        System.out.println(Arrays.toString(numbers));


        int[] numbers = {3, 5, 1, 4, 2};

        for (int i = 1; i < numbers.length; i++) {

            int target = numbers[i];
            int compareIndex = i - 1;

            while (compareIndex >= 0 && target < numbers[compareIndex]) {
                numbers[compareIndex + 1] = numbers[compareIndex];
                compareIndex--;
            }

            numbers[compareIndex + 1] = target;
        }
    }
}
