package 입문문제.day10;

public class 공던지기 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다.
     * 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
     * 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때, k번째로 공을 던지는 사람의 번호는 무엇인지 반환하라.
     */
    public int solution(int[] numbers, int k) {
        // TODO: 공 던지는 순서(패턴)을 찾는 것이 중요한 문제이다.
        // 만약, 배열의 크기를 넘어간다면, 각 인덱스는 numbers.length로 나눈 나머지가 된다.
        return numbers[2 * (k - 1) % numbers.length];
    }

    public static void main(String[] args) {
        공던지기 throwBall = new 공던지기();
        int[] firstNumbers = {1, 2, 3, 4};
        int[] secondNumbers = {1, 2, 3, 4, 5, 6};
        int[] thirdNumbers = {1, 2, 3};
        System.out.println("Result: " + throwBall.solution(firstNumbers, 2));
        System.out.println("Result: " + throwBall.solution(secondNumbers, 5));
        System.out.println("Result: " + throwBall.solution(thirdNumbers, 3));
    }
}
