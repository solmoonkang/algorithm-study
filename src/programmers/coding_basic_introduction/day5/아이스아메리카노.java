package programmers.coding_basic_introduction.day5;

import java.util.Arrays;

public class 아이스아메리카노 {

    /**
     * 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 아이스 아메리카노는 한잔에 5,500원입니다.
     * 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때,
     * 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 반환하라
     */
    public int[] solution(int money) {
        int numOfAmericano = money / 5500;
        int remainingAmount = money - (5500 * numOfAmericano);
        return new int[]{numOfAmericano, remainingAmount};
    }

    public static void main(String[] args) {
        아이스아메리카노 iceAmericano = new 아이스아메리카노();
        System.out.println("Result: " + Arrays.toString(iceAmericano.solution(5500)));
        System.out.println("Result: " + Arrays.toString(iceAmericano.solution(15000)));
    }
}
