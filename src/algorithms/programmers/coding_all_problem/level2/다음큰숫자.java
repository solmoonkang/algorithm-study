package algorithms.programmers.coding_all_problem.level2;

public class 다음큰숫자 {

    public int beforeRefactoringSolution(int n) {

        // 자연수 N이 주어졌을 때, N의 다음 큰 숫자는 다음과 같다
            // N의 다음 큰 숫자는 N보다 큰 자연수이다
            // N의 다음 큰 숫자와 N은 2진수로 변환했을 때, 1의 개수와 같다
            // N의 다음 큰 숫자는 조건 1, 조건 2를 만족하는 숫자 중 가장 작은 수이다
        // N의 다음 큰 숫자를 반환하라

        // 현재 숫자를 이진수로 바꾸고, 1을 카운트하여 저장한다
        String now = Integer.toBinaryString(n);
        int nowCount = 0;

        for (int i = 0; i < now.length(); i++) {

            if (now.charAt(i) == '1') {

                nowCount++;

            }
        }

        // 이후, N에 1씩 더해가면서 위의 과정을 반복하면서 현재 숫자보다 크고 1의 수가 같은 숫자를 찾는다
        while (true) {

            n++;

            int nextCount = 0;

            String next = Integer.toBinaryString(n);

            for (int i = 0; i < next.length(); i++) {

                if (next.charAt(i) == '1') {

                    nextCount++;

                }
            }

            if (nowCount == nextCount) break;

        }

        return n;
    }

    public int afterRefactoringSolution(int n) {

        int nowCount = Integer.bitCount(n);

        while (true) {

            n++;

            int nextCount = Integer.bitCount(n);

            if (nowCount == nextCount) break;
        }

        return n;
    }

    public static void main(String[] args) {

        다음큰숫자 nextBiggerNum = new 다음큰숫자();


        System.out.println("===== Before The Refactoring =====");
        System.out.println("Result : " + nextBiggerNum.beforeRefactoringSolution(78));
        System.out.println("Result : " + nextBiggerNum.beforeRefactoringSolution(15));


        System.out.println("===== After The Refactoring =====");
        System.out.println("Result : " + nextBiggerNum.afterRefactoringSolution(78));
        System.out.println("Result : " + nextBiggerNum.afterRefactoringSolution(15));
    }
}
