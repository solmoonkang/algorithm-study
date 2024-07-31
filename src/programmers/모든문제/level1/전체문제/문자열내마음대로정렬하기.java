package programmers.모든문제.level1.전체문제;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

    /**
     * [ 문제 설명 ]
     * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
     * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
     * 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
     */

    /**
     * [ 제한 조건 ]
     * strings는 길이 1 이상, 50이하인 배열입니다.
     * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
     * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
     * 모든 strings의 원소의 길이는 n보다 큽니다.
     * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     */
    public String[] solution(String[] strings, int n) {
        // TODO: 람다 표현식을 사용한 정렬 방법에 대해 학습하자.
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) return Character.compare(s1.charAt(n), s2.charAt(n));
            else return s1.compareTo(s2);
        });

        return strings;
    }

    /**
     * 1. Arrays.sort():
     *      주어진 배열을 정렬한다.
     *      두 번째 매개변수로는 비교기를 제공하여 정렬 기준을 정의할 수 있다.
     *      여기서 람다식을 사용하여 s1과 s2라는 두 개의 문자열을 비교하도록 설정한다.
     * 2. (s1, s2) -> {...}:
     *      Comparator<String> 인터페이스를 구현하는 람다식으로, 두 개의 문자열 s1과 s2를 입력으로 받아 비교하여 정렬 순서를 결정한다.
     * 3. s1.charAt(n) != s2.charAt(n):
     *      두 문자열의 n번째 문자를 비교한다.
     *      만약, 두 문자가 다르다면, Character.compare(s1.charAt(n), s2.charAt(n))를 호출하여 해당 문자의 아스키 값을 비교한다.
     *      Character.compare()는 두 문자를 비교하여, 첫 번째 문자가 두 번째 문자보다 작으면 음수, 같으면 0, 크면 양수를 반환한다.
     * 4. return s1.compareTo(s2):
     *      만약, n번쨰 문자가 동일하면, s1.compareTo(s2)를 호출하여 두 문자열을 사전식으로 비교한다.
     *      compareTo 메서드는 두 문자열을 비교하여 사전적 순서를 반환한다.
     *      만약, s1이 s2보다 사전적으로 앞서면 음수, 같으면 0, 뒤면 양수를 반환한다.
     */

    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n))
                return Character.compare(s1.charAt(n), s2.charAt(n));
            else
                return s1.compareTo(s2);
        });

        return strings;
    }

    public static void main(String[] args) {
        문자열내마음대로정렬하기 customOrder = new 문자열내마음대로정렬하기();

        String[] firstStrings = {"sun", "bed", "car"};
        System.out.println("customOrder = " + Arrays.toString(customOrder.solution2(firstStrings, 1)));

        String[] secondStrings = {"abce", "abcd", "cdx"};
        System.out.println("customOrder = " + Arrays.toString(customOrder.solution2(secondStrings, 2)));
    }
}
