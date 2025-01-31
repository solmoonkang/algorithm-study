package 모든문제.level1.전체문제;

import java.util.Arrays;

public class 과일장수 {

    /**
     * [ 문제 풀이 흐름 ]
     * 점수 분포 파악: 사과의 점수 분포를 파악하기 위해 각 점수별로 몇 개의 사과가 있는지 계산합니다.
     * 이를 위해 길이가 k+1인 배열을 생성하여, 각 점수에 해당하는 사과의 수를 저장합니다.
     *
     * 상자에 담을 사과 선정: 가장 높은 점수부터 낮은 점수까지 확인하며, 해당 점수의 사과가 m개 이상인지 확인합니다.
     * m개 이상이면, 해당 점수의 사과로 상자를 채울 수 있습니다.
     *
     * 이익 계산: 상자에 담을 수 있는 사과가 있다면, (해당 사과 점수) x (상자당 사과 개수) x (상자 개수)를 계산하여 최대 이익을 구합니다.
     * 여기서 상자 개수는 해당 점수의 사과 수 / m으로 계산할 수 있으며, 나머지 사과는 버려집니다.
     *
     * 최대 이익 반환: 모든 점수에 대해 위 과정을 반복하여 최대 이익을 찾습니다. 만약 이익이 발생하지 않는 경우 0을 반환합니다.
     */

    public int solution(int k, int m, int[] score) {
        // TODO: 다른 사람 풀이. 반복문과 배열에 대한 응용력이 아직도 많이 부족한 것 같음. 다시 풀어보자.
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m;
        }

        return answer;
    }

    /**
     * 1. 사과 점수 정렬: 주어진 사과 점수를 내림차순으로 정렬합니다. 이렇게 하면 높은 점수의 사과를 먼저 고려할 수 있습니다.
     * 2. 상자 포장 단위 계산: 사과를 m개씩 포장해야 하므로, 전체 사과 수를 m으로 나누어 몇 개의 상자를 만들 수 있는지 계산합니다. 이때 남는 사과는 버리게 됩니다.
     * 3. 상자당 최저 점수 찾기: 각 상자에 담길 사과들 중 최저 점수를 찾아야 합니다. 정렬된 리스트에서 m개씩 묶어가며 가장 낮은 점수를 확인합니다.
     * 4. 이익 계산하기: 각 상자에 대해 계산한 최저 점수를 사용하여 이익을 계산합니다. 이익은 (최저 점수) x (m) x (상자의 수)로 계산됩니다.
     * 5. 최대 이익 반환: 모든 상자에 대해 계산한 이익을 합산하여 최대 이익을 반환합니다.
     */

    public int solution2(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length; i >= m; i -=m) {
            answer += score[i -m] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        과일장수 fruitVendor = new 과일장수();

        int[] firstScore = {1, 2, 3, 1, 2, 3, 1};
        System.out.println("fruitVendor = " + fruitVendor.solution2(3, 4, firstScore));

        int[] secondScore = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println("fruitVendor = " + fruitVendor.solution2(4, 3, secondScore));
    }
}
