package programmers.모든문제.level0;

public class 옹알이1 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
     * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
     * 문자열 배열 babbling이 매개변수로 주어질 때,
     * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ babbling의 길이 ≤ 100
     * 1 ≤ babbling[i]의 길이 ≤ 15
     * babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
     *  - 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
     * 문자열은 알파벳 소문자로만 이루어져 있습니다.
     */
    public int solution(String[] babbling) {
        // TODO: substring의 활용을 잘 못하고 있음. 방식만 이해하면 금방 풀 수 있을거 같음.

    }

    public int solutionGpt(String[] babbling) {
        // 다른 사람이 푼 코드
        int count = 0;

        for (String word : babbling) {
            String tempWord = word;
            tempWord = tempWord.replace("aya", "A").replace("ye", "Y").replace("woo", "W").replace("ma", "M");

            boolean isValid = true;
            for (int i = 0; i < tempWord.length() - 1; i++) {
                if (tempWord.charAt(i) == tempWord.charAt(i + 1)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        옹알이1 babble = new 옹알이1();

        String[] firstBabbling = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println("babble = " + babble.solution(firstBabbling));

        String[] secondBabbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println("babble = " + babble.solution(secondBabbling));
    }
}
