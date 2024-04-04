package programmers.모든문제.level0.코딩테스트입문;

public class K의개수 {

    /**
     * [ 문제 설명 ]
     * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
     * 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ i < j ≤ 100,000
     * 0 ≤ k ≤ 9
     */
    public int solution(int i, int j, int k) {
        // TODO: 문자열로 변환해서 풀이 할 생각이었음. 당연히 실패
        String changeK = Integer.toString(k);

        int count = 0;

        for (int index = i; index <= j; index++) {
            String changeIndex = Integer.toString(index);
            if (changeIndex.contains(changeK)) count++;
        }

        return count;
    }

    public int solution2(int i, int j, int k) {
        // TODO: 다시 한 번 풀어보자.
        int count = 0;

        for (int index = i; index <= j; index++) {
            int temp = index;
            while (temp > 0) {
                int digit = temp % 10;  // 현재 숫자의 마지막 자리수를 구함
                if (digit == k) {       // 마지막 자리수가 K와 같으면 카운트 증가
                    count++;
                }
                temp /= 10;             // 다음 자리수로 이동
            }
        }
        return count;
    }

    public static void main(String[] args) {
        K의개수 numberOfK = new K의개수();

        System.out.println("numberOfK = " + numberOfK.solution2(1, 13, 1));
        System.out.println("numberOfK = " + numberOfK.solution2(10, 50, 5));
        System.out.println("numberOfK = " + numberOfK.solution2(3, 10, 2));
    }
}
