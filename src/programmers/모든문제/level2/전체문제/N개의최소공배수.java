package programmers.모든문제.level2.전체문제;

public class N개의최소공배수 {

    /**
     * [ 문제 설명 ]
     * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
     * 예를 들어 2와 7의 최소공배수는 14가 됩니다.
     * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
     * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
     */

    /**
     * [ 제한 사항 ]
     * arr은 길이 1이상, 15이하인 배열입니다.
     * arr의 원소는 100 이하인 자연수입니다.
     */
    public int solution(int[] arr) {

        return leastCommonMultiple(arr);
    }

    private int leastCommonMultiple(int[] arr) {

        if (arr.length == 1) return arr[0];

        int gcd = greatestCommonDivisor(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = greatestCommonDivisor(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }

        return lcm;
    }

    private int greatestCommonDivisor(int number1, int number2) {

        if (number1 % number2 == 0) return number2;

        return greatestCommonDivisor(number2, number1 % number2);
    }

    public static void main(String[] args) {
        N개의최소공배수 leastCommonMultiple = new N개의최소공배수();

        int[] firstArr = {2, 6, 8, 14};
        System.out.println("leastCommonMultiple = " + leastCommonMultiple.solution(firstArr));

        int[] secondArr = {1, 2, 3};
        System.out.println("leastCommonMultiple = " + leastCommonMultiple.solution(secondArr));
    }
}
