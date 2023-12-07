package algorithms.programmers.coding_basic_introduction;

public class 중복된숫자개수 {

    /**
     * [ 문제 설명 ]
     * 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, array에 n이 몇 개 있는 지를 반환하라.
     */
    public int solution(int[] array, int n) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        중복된숫자개수 countOfDuplicatedNumbers = new 중복된숫자개수();
        int[] firstArray = {1, 1, 2, 3, 4, 5};
        int[] secondArray = {0, 2, 3, 4};
        System.out.println("Result: " + countOfDuplicatedNumbers.solution(firstArray, 1));
        System.out.println("Result: " + countOfDuplicatedNumbers.solution(secondArray, 1));
    }
}
