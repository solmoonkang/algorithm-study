package programmers.모든문제.level1.전체문제;

public class 카드뭉치 {

    /**
     * [ 문제 설명 ]
     * 코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다.
     * 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
     *
     * 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
     * 한 번 사용한 카드는 다시 사용할 수 없습니다.
     * 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
     * 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
     * 예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"],
     * 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때
     * ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면
     * 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고
     * 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다.
     *
     * 문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
     * cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를,
     * 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
     *  - 1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
     *  - cards1과 cards2에는 서로 다른 단어만 존재합니다.
     * 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
     *  - 1 ≤ goal[i]의 길이 ≤ 10
     *  - goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
     * cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 두 카드 뭉치에서 현재 사용할 수 있는 카드를 추적하기 위한 포인터를 사용합니다. 각 카드 뭉치에 대해 하나씩, 총 두 개의 포인터가 필요합니다.
     * goal 배열을 순회하면서, 현재 goal에 해당하는 단어를 cards1 또는 cards2에서 찾을 수 있는지 확인합니다. 이때, 각 카드 뭉치에서의 포인터 위치 이전의 카드는 이미 사용했거나 건너뛴 것으로 간주합니다.
     * 만약 goal의 현재 단어를 두 카드 뭉치의 현재 포인터 위치 이후에서 찾을 수 있다면, 해당 카드 뭉치의 포인터를 찾은 단어의 위치 이후로 이동시킵니다.
     * goal의 모든 단어를 순서대로 찾을 수 있다면 "Yes"를, 그렇지 않다면 "No"를 반환합니다.
     */
    public String solution1(String[] cards1, String[] cards2, String[] goal) {
        // TODO: 배열 활용이 여전히 미숙함. 다시 한 번 풀어보자.
        int cards1Pointer = 0;
        int cards2Pointer = 0;

        for (String word : goal) {
            if (cards1Pointer < cards1.length && word.equals(cards1[cards1Pointer])) cards1Pointer++;
            else if (cards2Pointer < cards2.length && word.equals(cards2[cards2Pointer])) cards2Pointer++;
            else return "No";
        }

        return "Yes";
    }

    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < goal.length; i++) {
            if (index1 < cards1.length && goal[i].equals(cards1[index1])) index1++;
            else if (index2 < cards2.length && goal[i].equals(cards2[index2])) index2++;
            else return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        카드뭉치 stackOfCards = new 카드뭉치();

        String[] firstCards1 = {"i", "drink", "water"};
        String[] firstCards2 = {"want", "to"};
        String[] firstGoal = {"i", "want", "to", "drink", "water"};
        System.out.println("stackOfCards = " + stackOfCards.solution1(firstCards1, firstCards2, firstGoal));
        System.out.println("stackOfCards = " + stackOfCards.solution2(firstCards1, firstCards2, firstGoal));

        String[] secondCards1 = {"i", "water", "drink"};
        String[] secondCards2 = {"want", "to"};
        String[] secondGoal = {"i", "want", "to", "drink", "water"};
        System.out.println("stackOfCards = " + stackOfCards.solution1(secondCards1, secondCards2, secondGoal));
        System.out.println("stackOfCards = " + stackOfCards.solution2(secondCards1, secondCards2, secondGoal));
    }
}
