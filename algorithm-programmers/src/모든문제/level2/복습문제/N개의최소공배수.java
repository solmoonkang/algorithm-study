package 모든문제.level2.복습문제;

public class N개의최소공배수 {

    public int solution(int[] arr) {
        int answer = arr[0];                        // 배열의 첫 번째 요소를 LCM의 초기값으로 설정한다. 이는 나중에 다른 수들과 LCM을 계산할 때 기준이 된다.
        for (int i = 1; i < arr.length; i++) {      // 각 요소에 대해 현재까지 계산된 LCM과 다음 요소의 LCM을 계산한다.
            answer = getLCM(answer, arr[i]);        // getLCM 메서드를 호출하여 현재 LCM과 배열의 i번째 요소의 LCM을 계산하고, 그 결과를 다시 answer에 저장한다.
        }

        return answer;
    }

    /**
     * 최대공약수 (GCD)
     * 최대공약수는 두 개 이상의 자연수의 공통된 약수 중에서 가장 큰 수를 의미한다. 예를 들어, 12와 18의 공약수는 1,2,3,6 이므로, 이들의 최대공약수는 6이다.
     * <p>
     * 유클리드 호제법: 두 수의 최대공약수를 구하는 효율적인 방법으로, 다음과 같은 과정을 따른다.
     * - 두 수 a와 b가 있을 때, a와 b로 나눈 나머지를 r이라고 하면, GCD(a, b) = GCD(b, r)이다.
     * - 이 과정을 반복하여 나머지가 0이 될 떄의 b가 최대공약수이다.
     */
    public int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        return getGCD(num2, num1 % num2);
    }

    /**
     * 최소공배수 (LCM)
     * 최소공배수는 두 개 이상의 자연수의 공통된 배수 중에서 가장 작은 수를 의미한다. 예를 들어, 4와 5의 배수는 4,8,12,16,...과 5,10,15,...으로, 이들의 최소공배수는 20이다.
     * <p>
     * 관계식: GCD와 LCM은 다음과 같은 관계가 있다.
     * - LCM(a, b) = a * b / GCD(a, b)
     */
    public int getLCM(int num1, int num2) {
        return num1 * num2 / getGCD(num1, num2);
    }

    public static void main(String[] args) {
        N개의최소공배수 problem = new N개의최소공배수();

        int[] arr1 = {2, 6, 8, 1, 14};
        System.out.println("problem = " + problem.solution(arr1));

        int[] arr2 = {1, 2, 3};
        System.out.println("problem = " + problem.solution(arr2));
    }
}
