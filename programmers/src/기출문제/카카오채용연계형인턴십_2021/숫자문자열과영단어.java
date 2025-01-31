package 기출문제.카카오채용연계형인턴십_2021;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {

    /**
     * [ 문제 설명 ]
     *  네오와 프로도가 숫자놀이를 하고 있습니다.
     *  네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
     *
     * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
     *
     * 1478 → "one4seveneight"
     * 234567 → "23four5six7"
     * 10203 → "1zerotwozero3"
     * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
     * s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ s의 길이 ≤ 50
     * s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
     * return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 문제의 핵심은 주어진 문자열 s에서 영단어로 표현된 숫자를 실제 숫자로 변환하는 것입니다.
     *
     * 1. 영단어와 숫자 매핑:
     *  - 먼저, 영단어로 표현된 숫자와 실제 숫자를 매핑할 수 있는 방법을 구현합니다.
     *  - 이를 위해 HashMap 또는 배열을 사용할 수 있습니다.
     *  - HashMap을 사용하면 영단어를 키(key)로, 해당하는 숫자를 값(value)으로 저장할 수 있습니다.
     *
     * 2. 문자열 탐색 및 변환: 주어진 문자열 s를 탐색하면서, 매핑된 영단어를 실제 숫자로 변환합니다.
     *  - 이 과정에서 문자열 치환을 사용할 수 있습니다. 즉, 문자열 s 내에서 영단어를 찾아 해당하는 숫자로 치환합니다.
     *
     * 3. 결과 반환: 최종적으로 변환된 문자열을 정수로 변환하여 반환합니다.
     */
    public int solution(String s) {
        Map<String, String> numbers = new HashMap<>();
        numbers.put("zero", "0");
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");

        for (String key : numbers.keySet()) {
            s = s.replace(key, numbers.get(key));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        숫자문자열과영단어 numberStringAndAlphabet = new 숫자문자열과영단어();

        System.out.println("numberStringAndAlphabet = " + numberStringAndAlphabet.solution("one4seveneight"));

        System.out.println("numberStringAndAlphabet = " + numberStringAndAlphabet.solution("23four5six7"));

        System.out.println("numberStringAndAlphabet = " + numberStringAndAlphabet.solution("2three45sixseven"));

        System.out.println("numberStringAndAlphabet = " + numberStringAndAlphabet.solution("123"));
    }
}
