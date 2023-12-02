package algorithms.programmers.coding_basic_introduction.day8;

import java.util.*;

public class 진로순서정하기 {

    /**
     * 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
     * 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 반환하라.
     */
    public int[] solution(int[] emergency) {
        // TODO: 문제 흐름에 대한 이해가 부족하다.
        // 문제에 대한 설명이 불친절한 문제이다. [3, 76, 24] -> [3 = 3순위, 76 = 1순위, 24 = 2순위] -> [3, 1, 2]
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                // 현재 i번째 요소가 j번째 요소보다 작은지를 확인한다.
                if (emergency[i] < emergency[j]) {
                    // 만약, 작다면 answer[i] 값을 1 증가시킨다. 이는 i번째 요소가 emergency 배열에서 몇 개의 요소보다 작은지를 센다.
                    answer[i]++;
                }
            }
            // 각 i번째 요소에 대해, 자신을 포함하여 몇 개의 요소보다 작은지를 최종적으로 계산하는 부분이다.
            answer[i]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        진로순서정하기 determineTheOrderOfCareerPaths = new 진로순서정하기();
        int[] firstEmergency = {3, 76, 24};
        int[] secondEmergency = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Result: " + Arrays.toString(determineTheOrderOfCareerPaths.solution(firstEmergency)));
        System.out.println("Result: " + Arrays.toString(determineTheOrderOfCareerPaths.solution(secondEmergency)));
    }
}
