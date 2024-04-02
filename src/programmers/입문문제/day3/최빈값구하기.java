package programmers.입문문제.day3;

import java.util.*;

public class 최빈값구하기 {

    /**
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
     * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 반환하라
     * 최빈값이 여러 개면 -1을 반환하라
     */
    public int solution(int[] array) {
        // TODO: HashMap을 통해서 구현했다. 아직 실전에서 사용할만큼 능숙하진 않으므로, 해당 자료 구조와 구현 방식에 대해서 공부가 더 필요하다.
        // 중복할 수 없는 자료구조(Set, HashMap 등)를 사용해서 배열의 값을 넣고 해당 자료구조와 배열의 값을 비교하여 배열에서 남아있는 값이 중복된 값이므로 해당 값을 반환한다.

        /**
         * [ 구현 방법 ]
         * hashMap.put(a, hashMap.getOrDefault(a, 0) + 1) 으로 a가 hashMap에 존재하면 그 값을 반환하고, 존재하지 않으면 기본값인 0을 반환한다.
         * int countMax = Collections.max(hashMap.values()); 으로 hashMap의 모든 값 중 가장 큰 값을 찾는다. 이는 가장 많이 등장한 횟수가 된다.
         * Map.Entry<Integer, Integer> entry : hashMap.entrySet() 으로 hashMap을 순회하면서 등장 횟수가 가장 큰 숫자를 찾는다.
         * if (entry.getValue() == countMax) 으로 만약, 가장 큰 등장 횟수를 가진 숫자가 여러 개일 경우를 판단한다.
         * list.add(entry.getKey()); 으로 등장 횟수가 여러 개일 경우, 그 숫자들을 리스트에 추가한다.
         * if (list.size() > 1) 으로 만약, 그 크기가 1보다 크면 최빈값이 여러 개 있으므로 -1을 반환한다.
         * return list.get(0); 으로 만약, 그렇지 않다면, 리스트의 첫 번째 원소를 반환한다.
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int a : array) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }

        int countMax = Collections.max(hashMap.values());
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == countMax) {
                list.add(entry.getKey());
            }
        }

        if (list.size() > 1) {
            return -1;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        최빈값구하기 mostFrequentValue = new 최빈값구하기();
        int[] firstArray = {1, 2, 3, 3, 3, 4};
        int[] secondArray = {1, 1, 2, 2};
        int[] thirdArray = {1};
        System.out.println("Result: " + mostFrequentValue.solution(firstArray));
        System.out.println("Result: " + mostFrequentValue.solution(secondArray));
        System.out.println("Result: " + mostFrequentValue.solution(thirdArray));
    }
}
