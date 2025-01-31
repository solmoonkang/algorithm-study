package 모든문제.level2.전체문제;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 숫자변환하기 {

    /**
     * [ 문제 설명 ]
     * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
     *
     * x에 n을 더합니다
     * x에 2를 곱합니다.
     * x에 3을 곱합니다.
     * 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
     * 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ x ≤ y ≤ 1,000,000
     * 1 ≤ n < y
     */
    public int solution(int x, int y, int n) {
        // TODO: BFS 알고리즘에 대해 공부하자. 그리고선 다시 풀어보자.
        Deque<int[]> deque = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        deque.offerLast(new int[] {x, 0});
        visited.add(x);

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentValue = current[0];
            int count = current[1];

            if (currentValue == y) return count;

            int[] nextValues = {currentValue + n, currentValue * 2, currentValue * 3};
            for (int nextValue : nextValues) {
                if (nextValue <= y && visited.add(nextValue)) {
                    deque.offerLast(new int[] {nextValue, count + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        숫자변환하기 convertInteger = new 숫자변환하기();

        System.out.println("convertInteger = " + convertInteger.solution(10, 40, 5));

        System.out.println("convertInteger = " + convertInteger.solution(10, 40, 30));

        System.out.println("convertInteger = " + convertInteger.solution(2, 5, 4));
    }
}
