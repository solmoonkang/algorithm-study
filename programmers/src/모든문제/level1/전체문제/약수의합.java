package 모든문제.level1.전체문제;

/**
 * 문제 설명 : 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 * 제한 조건 : - n은 0 이상 3000이하인 정수입니다.
 * 입/출력 : 12	28, 5	6
 * 12 = 1 2 3 4 6 12,   5 = 1 5
 */

public class 약수의합 {

    public int sumOfDivisors(int n) {
//        int answer = 0;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                answer += i;
//            }
//        }
//
//        return answer;

        int answer = 0;
        for (int i = 1 ; i <= n/2; i++){
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer+n;
    }

    public static void main(String[] args) {
        약수의합 solution = new 약수의합();
        System.out.println("answer : " + solution.sumOfDivisors(16));
    }
}
