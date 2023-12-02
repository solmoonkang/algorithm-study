package algorithms.programmers.coding_basic_training.day20;

import java.util.HashMap;

public class 문자열묶기 {

    public int solution(String[] strArr) {

        // strArr 의 원소들을 길이가 같은 문자열들끼리 그룹으로 묶었을 때, 가장 개수가 많은 그룹의 크기를 반환하라

        // HashMap 을 사용해 각 길이별로 등장하는 횟수를 저장한다
        // Key : 문자열의 길이, Value : 해당 문자열이 등장하는 횟수
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (String str : strArr) {

            int length = str.length();

            hashMap.put(length, hashMap.getOrDefault(length, 0) + 1);

        }

        int answer = 0;

        for (int v : hashMap.values()) {

            answer = Math.max(answer, v);

        }

        return answer;
    }

    public static void main(String[] args) {

        문자열묶기 tie = new 문자열묶기();

        String[] strArr = {"a", "bc", "d", "efg", "hi"};

        System.out.println("Result : " + tie.solution(strArr));
    }
}
