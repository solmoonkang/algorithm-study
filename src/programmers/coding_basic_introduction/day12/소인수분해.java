package programmers.coding_basic_introduction.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소인수분해 {

    /**
     * [ 문제 설명 ]
     * 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
     * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.
     * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 반환하라.
     * 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수를 소수라고 한다.
     */
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                // n이 i로 나누어 떨어질 경우 i는 n의 소인수이므로 리스트에 추가한다.
                list.add(i);
                // n을 i로 나눈다.
                n /= i;
            }
        }
        return list.stream().distinct().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        소인수분해 primeFactorization = new 소인수분해();
        System.out.println("Result: "+ Arrays.toString(primeFactorization.solution(12)));
        System.out.println("Result: "+ Arrays.toString(primeFactorization.solution(17)));
        System.out.println("Result: "+ Arrays.toString(primeFactorization.solution(420)));
    }
}
