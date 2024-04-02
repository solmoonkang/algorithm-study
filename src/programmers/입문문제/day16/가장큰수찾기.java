package programmers.입문문제.day16;

import java.util.Arrays;

public class 가장큰수찾기 {

    /**
     * [ 문제 설명 ]
     * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 반환하라.
     */
    public int[] solution(int[] array) {
        int largestNumber = array[0];
        int largestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largestNumber) {
                largestNumber = array[i];
                largestIndex = i;
            }
        }
        return new int[]{largestNumber, largestIndex};
    }

    public static void main(String[] args) {
        가장큰수찾기 findingTheLargestNumber = new 가장큰수찾기();
        int[] firstArray = {1, 8, 3};
        int[] secondArray = {9, 10, 11, 8};
        System.out.println("Result: " + Arrays.toString(findingTheLargestNumber.solution(firstArray)));
        System.out.println("Result: " + Arrays.toString(findingTheLargestNumber.solution(secondArray)));
    }
}
