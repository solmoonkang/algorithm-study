package 모든문제.level1.전체문제;

public class 푸드파이트대회 {

    /**
     * [ 문제 설명 ]
     * 수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최합니다.
     * 이 대회에서 선수들은 1대 1로 대결하며, 매 대결마다 음식의 종류와 양이 바뀝니다.
     * 대결은 준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로,
     * 다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다.
     * 중앙에는 물을 배치하고, 물을 먼저 먹는 선수가 승리하게 됩니다.
     *
     * 이때, 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 합니다.
     * 또한, 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다.
     * 이번 대회를 위해 수웅이는 음식을 주문했는데, 대회의 조건을 고려하지 않고 음식을 주문하여 몇 개의 음식은 대회에 사용하지 못하게 되었습니다.
     *
     * 예를 들어, 3가지의 음식이 준비되어 있으며,
     * 칼로리가 적은 순서대로 1번 음식을 3개, 2번 음식을 4개, 3번 음식을 6개 준비했으며, 물을 편의상 0번 음식이라고 칭한다면,
     * 두 선수는 1번 음식 1개, 2번 음식 2개, 3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다.
     * 따라서 1번 음식 1개는 대회에 사용하지 못합니다.
     *
     * 수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때,
     * 대회를 위한 음식의 배치를 나타내는 문자열을 return 하는 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 2 ≤ food의 길이 ≤ 9
     * 1 ≤ food의 각 원소 ≤ 1,000
     * food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
     * food[i]는 i번 음식의 수입니다.
     * food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
     * 정답의 길이가 3 이상인 경우만 입력으로 주어집니다.
     */

    public String solution(int[] food) {
        // TODO: foodFighter = 1223003221 다음과 같이 출력이 됌. 반복문이 문제인거 같음.
        // 각 음식을 2로 나눠야 함. -> 참여자가 두 명이니까
        // 그리고 대회에서 먹게 될 음식은 문자열에 담아서 반환

        // 우선 처음 선수가 먹게 될 음식을 문자열에 담아서 저장하고
        // 그 다음 선수가 먹을 음식은 빌더를 사용해 뒤집어서 append로 붙여서 반환 중간에 0도 같이 추가

        // 예를 들어 1번: 3개, 2번: 4개, 3번: 6개 음식이 있다고 가정하고 풀이하자.
        StringBuilder builder = new StringBuilder();

        int result = 0;
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i]--;
            }
            int count = countDivisionsByTwo(food[i]);
            for (int j = 0; j < count; j++) {
                builder.append(i);
            }
        }

        builder.append("0");

        StringBuilder reverse = new StringBuilder(builder);
        reverse.reverse();

        builder.append(reverse);

        return builder.toString();
    }

    /**
     * [ 문제 풀이 흐름 ]
     * 입력 받기: 음식의 양을 담고 있는 food 배열을 입력 받습니다. 이 배열은 이미 칼로리가 적은 순서대로 정렬되어 있습니다.
     *
     * 중앙값 찾기: 물을 중앙에 배치해야 하므로, 두 선수가 먹을 음식의 양이 같아야 합니다. 따라서 각 음식을 반으로 나눠서 양쪽에 배치해야 합니다. 이 과정에서 각 음식의 수를 2로 나눈 몫을 사용합니다.
     *
     * 문자열 생성: 두 선수가 먹을 음식의 양이 같도록 문자열을 생성합니다. 이때, 문자열의 가운데에는 물(0)을 배치하고, 그 양 옆으로 음식을 배치합니다. 음식을 배치할 때는 각 음식 번호를 해당 음식의 양만큼 반복하여 추가합니다.
     *
     * 반대편 음식 배치: 한쪽 방향으로 음식을 배치한 후, 그 순서를 뒤집어 다른 쪽 방향으로도 같은 방식으로 배치합니다. 이렇게 하면 두 선수가 먹는 음식의 종류와 양, 순서가 같아집니다.
     *
     * 결과 반환: 최종적으로 생성된 문자열을 반환합니다.
     */
    public String solution2(int[] food) {
        StringBuilder builder = new StringBuilder();

        // 음식을 반으로 나눠서 배치
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                builder.append(i);
            }
        }

        builder.append("0");

        StringBuilder reverse = new StringBuilder(builder).reverse();
        builder.append(reverse);

        return builder.toString();
    }



    private int countDivisionsByTwo(int number) {
        int count = 0;
        while (number > 0 && number % 2 == 0) {
            number /= 2;
            count++;
        }
        return count;
    }



    /**
     * 준비된 음식은 짝수로만 섭취가 가능함
     * 대회 음식을 배치할 경우, 중간에는 0이 들어가고 그 이외에는 거꾸로 뒤집은 상태가 되어야 함
     *
     * 예를 들어, 1, 3, 4, 6 이면, 0번 음식 1개, 1번 음식 3개, 2번 음식 4개, 3번 음식 6개
     * 결과는 1223330333221
     */
    public String solution3(int[] food) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                builder.append(i);
            }
        }
        builder.append("0");

        StringBuilder reverse = new StringBuilder(builder).reverse();
        builder.append(reverse);

        return builder.toString();
    }

    public static void main(String[] args) {
        푸드파이트대회 foodFighter = new 푸드파이트대회();

        int[] firstFood = {1, 3, 4, 6};
        System.out.println("foodFighter = " + foodFighter.solution3(firstFood));

        int[] secondFood = {1, 7, 1, 2};
        System.out.println("foodFighter = " + foodFighter.solution3(secondFood));
    }
}
