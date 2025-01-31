package 모든문제.level1.전체문제;

public class 옹알이2 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
     * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
     * 연속해서 같은 발음을 하는 것을 어려워합니다.
     * 문자열 배열 babbling이 매개변수로 주어질 때,
     * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ babbling의 길이 ≤ 100
     * 1 ≤ babbling[i]의 길이 ≤ 30
     * 문자열은 알파벳 소문자로만 이루어져 있습니다.
     */
    public int solution(String[] babbling) {
        // TODO: 어지럽다. 문제를 더 많이 풀어보고 다시 풀어보자.
        String[] sounds = {"aya", "ye", "woo", "ma"};

        int count = 0;
        for (String babble : babbling) {
            boolean isValid = true;
            String prevSound = "";

            String current = babble;

            while (!current.isEmpty() && isValid) {
                boolean found = false;

                for (String sound : sounds) {
                    if (current.startsWith(sound)) {
                        if (sound.equals(prevSound)) {
                            isValid = false;
                            break;
                        }

                        current = current.substring(sound.length());
                        prevSound = sound;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    isValid = false;
                }
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        옹알이2 babbling = new 옹알이2();

        String[] firstBabbling = {"aya", "yee", "u", "maa"};
        System.out.println("babbling = " + babbling.solution(firstBabbling));

        String[] secondBabbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println("babbling = " + babbling.solution(secondBabbling));
    }
}
