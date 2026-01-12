package 입문문제.day20;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다항식더하기 {

    /**
     * [ 문제 설명 ]
     * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
     * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 동류항끼리 더한 결괏값을 문자열로 반환하라.
     * 단, 같은 식이라면 가장 짧은 수식을 반환한다.
     */

    /**
     * [ 제한 사항 ]
     * 0 < polynomial에 있는 수 < 100
     * polynomial에 변수는 'x'만 존재합니다.
     * polynomial은 양의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
     * 항과 연산기호 사이에는 항상 공백이 존재합니다.
     * 공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
     * 하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
     * " + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
     * 0으로 시작하는 수는 없습니다.
     * 문자와 숫자 사이의 곱하기는 생략합니다.
     * polynomial에는 일차 항과 상수항만 존재합니다.
     * 계수 1은 생략합니다.
     * 결괏값에 상수항은 마지막에 둡니다.
     * 0 < polynomial의 길이 < 50
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 먼저, 주어진 다항식 polynomial을 항별로 분리합니다. 각 항은 덧셈 기호 '+'로 구분되므로, 이를 기준으로 문자열을 분리하면 됩니다.
     * 분리된 각 항에 대해, 계수와 변수를 분리합니다. 계수는 항의 앞부분에 위치한 숫자이며, 변수는 항의 뒷부분에 위치한 문자입니다. 이를 위해 정규 표현식을 사용할 수 있습니다.
     * 동류항끼리 더하기 위해, 같은 변수를 가진 항들의 계수를 더합니다. 이를 위해 해시맵을 사용하면 효율적으로 계산할 수 있습니다. 해시맵의 키는 변수, 값은 그 변수를 가진 항들의 계수의 합이 됩니다.
     * 마지막으로, 해시맵에 저장된 각 항을 덧셈 기호 '+'로 연결하여 결과의 다항식을 구성합니다. 이 때, 계수가 0인 항은 결과에 포함시키지 않습니다.
     * 만약 같은 식이라면, 가장 짧은 수식을 반환해야 하므로, 결과의 다항식을 항의 길이에 따라 정렬합니다. 항의 길이는 계수와 변수의 길이의 합이 됩니다.
     */
    public String solution(String polynomial) {
        // TODO: Pattern, Matcher에 대한 이해가 필요하다.
        // TODO: Runtime Error
        String[] terms = polynomial.split("\\s+\\+\\s+");

        // Step 2: 동류항끼리 더하기 위한 해시맵 생성
        Map<String, Integer> termMap = new HashMap<>();

        // Step 3: 각 항에 대해 계수와 변수를 분리
        Pattern pattern = Pattern.compile("(\\d+)?(x)?");
        for (String term : terms) {
            Matcher matcher = pattern.matcher(term);
            if (matcher.find()) {
                String coefficientStr = matcher.group(1);  // 계수
                String variable = matcher.group(2);  // 변수

                // 계수가 없는 경우 1로 설정
                int coefficient = (coefficientStr != null) ? Integer.parseInt(coefficientStr) : 1;

                // 변수가 없는 경우 (즉, 상수항인 경우) 빈 문자열로 설정
                variable = (variable != null) ? variable : "";

                // 동류항끼리 더하기
                termMap.put(variable, termMap.getOrDefault(variable, 0) + coefficient);
            }
        }

        // Step 4: 결과의 다항식을 구성
        List<String> resultTerms = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : termMap.entrySet()) {
            int coefficient = entry.getValue();
            String variable = entry.getKey();

            // 계수가 0인 항은 결과에 포함시키지 않음
            if (coefficient != 0) {
                String term = (variable.equals("x")) ? coefficient + variable : String.valueOf(coefficient);
                resultTerms.add(term);
            }
        }

        // Step 5: 결과의 다항식을 항의 길이에 따라 정렬
        Collections.sort(resultTerms, (a, b) -> b.length() - a.length());

        // 결과 반환
        return String.join(" + ", resultTerms);
    }

    public static void main(String[] args) {
        // commit: adding polynomials
        다항식더하기 addingPolynomials = new 다항식더하기();
        System.out.println("Result: " + addingPolynomials.solution("3x + 7 + x"));
        System.out.println("Result: " + addingPolynomials.solution("x + x + x"));
    }
}
