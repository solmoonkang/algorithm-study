package programmers.입문문제.day16;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class 배열의유사도 {

    /**
     * [ 문제 설명 ]
     * 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 반환하라.
     */
    public int solution(String[] s1, String[] s2) {
        // set 자료형에 s1과 s2를 넣고, s1.length + s2.length의 값과 set.size의 값을 빼면, 같은 원소의 개수를 구할 수 있다.
        String[] merged = Stream.concat(Arrays.stream(s1), Arrays.stream(s2)).toArray(String[]::new);
        Set<String> set = new LinkedHashSet<>(Arrays.asList(merged));
        return (s1.length + s2.length) - (set.size());
    }

    public static void main(String[] args) {
        배열의유사도 similarityOfArrays = new 배열의유사도();
        String[] firstS1 = {"a", "b", "c"};
        String[] firstS2 = {"com", "b", "d", "p", "c"};
        String[] secondS1 = {"n", "omg"};
        String[] secondS2 = {"m", "dot"};
        System.out.println("Result: " + similarityOfArrays.solution(firstS1, firstS2));
        System.out.println("Result: " + similarityOfArrays.solution(secondS1, secondS2));
    }
}
