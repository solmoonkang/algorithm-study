package programmers.모든문제.level1.복습문제;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.naturalOrder;

public class 문자열내마음대로정렬하기 {

    // TODO: Compartor 함수에 대해 처음 알게 되었다. 정렬을 할 수 있는 함수들에 대해 학습할 필요가 있다.
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, Comparator.comparing((String s) -> s.charAt(n))
                .thenComparing(naturalOrder()));

        return strings;
    }

    public static void main(String[] args) {
        문자열내마음대로정렬하기 problem = new 문자열내마음대로정렬하기();

        String[] strings1 = {"sun", "bed", "car"};
        System.out.println("problem = " + Arrays.toString(problem.solution(strings1, 1)));

        String[] strings2 = {"abce", "abcd", "cdx"};
        System.out.println("problem = " + Arrays.toString(problem.solution(strings2, 2)));
    }
}
