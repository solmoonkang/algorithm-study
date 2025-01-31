package 기출문제.KAKAO_WINTER_INTERNSHIP_2024;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {

    /**
     * [ 문제 설명 ]
     * 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다.
     * 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.
     *
     * 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
     * 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
     * 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
     * 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
     * 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다.
     * B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다.
     * 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
     * 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
     * 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
     *
     * 친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다.
     * 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
     */

    /**
     * [ 제한 사항 ]
     * 2 ≤ friends의 길이 = 친구들의 수 ≤ 50
     *  - friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
     *  - 이름이 같은 친구는 없습니다.
     * 1 ≤ gifts의 길이 ≤ 10,000
     *  - gifts의 원소는 "A B"형태의 문자열입니다. A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
     *  - A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않습니다.
     */
    public int solution(String[] friends, String[] gifts) {
        // TODO: Map을 사용하니까 시간 복잡도는 단축됨. 근데 너무 복잡해짐. 다시 한 번 풀어보자.
        Map<String, Integer> giftScoreMap = new HashMap<>();
        Map<String, Map<String, Integer>> giftRecordMap = new HashMap<>();
        Map<String, Integer> nextMonthGiftsMap = new HashMap<>();

        for (String friend : friends) {
            giftScoreMap.put(friend, 0);
            giftRecordMap.put(friend, new HashMap<>());
            nextMonthGiftsMap.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String giver = split[0];
            String receiver = split[1];

            giftRecordMap.get(giver).put(receiver, giftRecordMap.get(giver).getOrDefault(receiver, 0) + 1);
            giftScoreMap.put(giver, giftScoreMap.get(giver) + 1);
            giftScoreMap.put(receiver, giftScoreMap.get(receiver) - 1);
        }

        for (String giver : friends) {
            for (String receiver : friends) {
                if (!giver.equals(receiver)) {
                    int giverToReceiver = giftRecordMap.get(giver).getOrDefault(receiver, 0);
                    int receiverToGiver = giftRecordMap.get(receiver).getOrDefault(giver, 0);

                    if (giverToReceiver > receiverToGiver) {
                        nextMonthGiftsMap.put(giver, nextMonthGiftsMap.get(giver) + 1);
                    } else if (giverToReceiver == receiverToGiver && giftScoreMap.get(giver) > giftScoreMap.get(receiver)) {
                        nextMonthGiftsMap.put(giver, nextMonthGiftsMap.get(giver) + 1);
                    }
                }
            }
        }

        return Collections.max(nextMonthGiftsMap.values());
    }

    public static void main(String[] args) {
        가장많이받은선물 theMostReceivedGift = new 가장많이받은선물();

        String[] firstFriends = {"muzi", "ryan", "frodo", "neo"};
        String[] firstGifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println("theMostReceivedGift = " +
                theMostReceivedGift.solution(firstFriends, firstGifts));

        String[] secondFriends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] secondGifts = {"alessandro brad", "alessandro joy",
                "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println("theMostReceivedGift = " +
                theMostReceivedGift.solution(secondFriends, secondGifts));

        String[] thirdFriends = {"a", "b", "c"};
        String[] thirdGifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println("theMostReceivedGift = " +
                theMostReceivedGift.solution(thirdFriends, thirdGifts));
    }
}
