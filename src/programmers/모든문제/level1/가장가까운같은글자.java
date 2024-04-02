package programmers.모든문제.level1;

import java.util.Arrays;

public class 가장가까운같은글자 {

    /**
     * [ 문제 설명 ]
     * 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서,
     * 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
     * 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
     *
     * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
     * a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
     * n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
     * a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
     * n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
     * a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
     * 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
     *
     * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ s의 길이 ≤ 10,000
     *  - s은 영어 소문자로만 이루어져 있습니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 초기화:
     *  - 먼저, 문자열 s의 각 문자에 대해 자신보다 앞에 나왔으면서 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지를 기록할 배열 result를 초기화합니다.
     *  - 배열의 크기는 문자열 s의 길이와 같고, 모든 값을 -1로 초기화할 수 있습니다.
     *
     * 2. 마지막 등장 위치 기록:
     *  - 문자열 s를 탐색하면서 각 문자가 마지막으로 등장한 위치를 기록합니다.
     *  - 이를 위해, 알파벳 소문자에 대응하는 크기가 26인 배열 lastSeen을 사용할 수 있으며, 모든 값을 -1로 초기화합니다.
     *
     * 3. 문자열 탐색 및 결과 계산:
     *  - 문자열 s를 왼쪽부터 오른쪽으로 한 문자씩 탐색합니다.
     *  - 각 문자에 대해, 해당 문자가 마지막으로 등장한 위치를 lastSeen 배열에서 찾습니다.
     *  - 만약 해당 문자가 이전에 나타난 적이 있다면(lastSeen의 해당 값이 -1이 아니라면), 현재 위치와 그 마지막 등장 위치의 차이를 계산합니다.
     *  - 이 차이가 바로 자신과 가장 가까운 같은 글자와의 거리입니다.
     *  - 이 거리를 result 배열의 현재 인덱스에 저장합니다.
     *  - 마지막으로, 현재 문자의 마지막 등장 위치를 현재 인덱스로 업데이트합니다.
     *
     * 4. 결과 반환: 모든 문자를 처리한 후, result 배열을 반환합니다.
     */
    public int[] solution(String s) {
        // TODO: 코드 자체를 이해하지 못함.
        int[] answer = new int[s.length()];
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';

            if (lastSeen[charIndex] != -1) {
                answer[i] = i - lastSeen[charIndex];
            } else {
                answer[i] = -1;
            }

            lastSeen[charIndex] = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        가장가까운같은글자 nearestRepeatingCharacter = new 가장가까운같은글자();

        System.out.println("nearestCharacter = " + Arrays.toString(nearestRepeatingCharacter.solution("banana")));

        System.out.println("nearestCharacter = " + Arrays.toString(nearestRepeatingCharacter.solution("foobar")));
    }
}
