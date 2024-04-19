package programmers.모든문제.level1;

public class 문자열나누기 {

    /**
     * [ 문제 설명 ]
     * 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
     *
     * 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
     * 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.
     * 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
     * s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
     * 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
     * 문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ s의 길이 ≤ 10,000
     * s는 영어 소문자로만 이루어져 있습니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 변수 초기화: 분해한 문자열의 개수를 저장할 변수를 초기화합니다. 이 변수는 나중에 반환할 값입니다.
     *
     * 2. 문자열 순회: 문자열 s를 처음부터 끝까지 순회하면서, 각 문자에 대해 처리합니다. 순회 중에 사용할 변수들을 초기화합니다:
     *  - 첫 번째 문자 x를 기록합니다.
     *  - x의 개수와 x가 아닌 다른 문자의 개수를 세기 위한 변수를 초기화합니다.
     *
     * 3. 문자 카운트: 문자열을 순회하면서 현재 문자가 x인지 아닌지를 확인하고, 해당하는 카운터를 증가시킵니다.
     *
     * 4. 분리 조건 검사: 각 단계에서 x의 개수와 x가 아닌 문자의 개수가 같아지는지 확인합니다.
     *  - 만약 같아진다면, 현재까지의 부분 문자열을 분리하고, 분해한 문자열의 개수를 1 증가시킵니다.
     *  - 그리고 남은 부분 문자열에 대해 같은 과정을 반복합니다.
     *
     * 5. 반복 완료: 문자열의 끝에 도달하면 반복을 종료합니다.
     *  - 만약 두 개수가 다른 상태에서 문자열이 끝났다면, 남은 부분도 하나의 분리된 문자열로 처리하고, 분해한 문자열의 개수를 1 증가시킵니다.
     *
     * 6. 결과 반환: 분해한 문자열의 총 개수를 반환합니다.
     */
    public int solution(String s) {
        // TODO: 코드 채점 시 실패. 다시 풀어야 할거 같음.
        int count = 0;
        int xCount = 0;
        int nonXCount = 0;

        char x = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) xCount++;
            else nonXCount++;

            if (xCount == nonXCount) {
                count++;
                xCount = 0;
                nonXCount = 0;
            }
        }
        if (xCount > 0 || nonXCount > 0) count++;

        return count;
    }

    public static void main(String[] args) {
        문자열나누기 splitString = new 문자열나누기();

        System.out.println("splitString = " + splitString.solution("banana"));

        System.out.println("splitString = " + splitString.solution("abracadabra"));

        System.out.println("splitString = " + splitString.solution("aaabbaccccabba"));
    }
}
