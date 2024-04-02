package programmers.기초문제.day21;

import java.util.*;

public class 전국대회선발고사 {

    public int solution(int[] rank, boolean[] attendance) {

        // 0번부터 N-1번까지 N명의 학생 중 3명을 선발하는 전국 대회 선발 고사가 있다
        // 등수가 높은 3명을 선발해야 하지만, 개인 사정으로 참여하지 못하는 학생이 있다
        // 참여가 가능한 학생 중 등수가 높은 3명을 선발한다
        // 전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 A, B, C 번이라고 할 때, 10000 * A + 100 * B + C 를 반환하라

        // 즉, boolean 값이 true 인 학생들에 한해서 등수가 높은 3명(인덱스 위치)을 선발해서 해당 계산식의 결과값을 반환한다

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < rank.length; i++) {

            if (attendance[i]) {

                hashMap.put(i, rank[i]);

            }
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort(Comparator.comparing(Map.Entry::getValue));

        System.out.print(list);

        int answer = (10000 * list.get(0).getKey()) + (100 * list.get(1).getKey()) + list.get(2).getKey();

        return answer;
    }

    public static void main(String[] args) {

        전국대회선발고사 contest = new 전국대회선발고사();

        int[] rank = {3, 7, 2, 5, 4, 6, 1};
        boolean[] attendance = {false, true, true, true, true, false, false};

        System.out.println("Result : " + contest.solution(rank, attendance));
    }
}
