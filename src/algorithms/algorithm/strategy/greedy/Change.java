package algorithms.algorithm.strategy.greedy;

public class Change {

    /** 예제 - 거스름 돈
     *  당신은 음식점의 계산을 도와주는 점원이다
     *  카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다
     *  손님에게 거슬러 주어야 할 돈이 N원일 때, 거슬러 주어야 하는 동전의 최소 개수를 구하라
     *  ( 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다 )
     */

    public static void main(String[] args) {

        // 최적의 해를 빠르게 구하기 위해서는 가장 큰 화폐 단위부터 돈을 거슬러 주면 된다
        // 즉, N원을 거슬러 줘야 할 때, 가장 먼저 500원으로 거슬러 줄 수 있을만큼 거슬러 준다

        int[] coins = {100, 10, 500, 50};   // 동전 종류
        int total = 1260;                   // 거스름돈
        int count = 0;                      // 동전 사용 개수

        for (int i = 0; i < 4; i++) {
            // 현재 확인하고 있는 동전으로 얼마나 많이 거슬러 줄 수 있는지 계산하고, 그 개수만큼 count 값을 증가
            count += (total / coins[i]);
            // 현재 확인하고 있는 동전으로 거슬러준 후 남은 금액을 계산
            total %= coins[i];
        }

        System.out.println("Change : " + count);
    }
}
