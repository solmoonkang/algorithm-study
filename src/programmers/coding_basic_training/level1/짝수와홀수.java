package programmers.coding_basic_training.level1;

/**
 * 문제 설명 : 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 * 제한 조건 : - num은 int 범위의 정수입니다.
 *          - 0은 짝수입니다.
 * 입/출력 : 3 = Odd, 4 = Even
 */

public class 짝수와홀수 {

    public String evenOrOdd(int num) {
        String answer = "";

//        if (num % 2 == 0) {
//            answer = "Even";
//            System.out.println(num + ":" + answer);
//        }
//        else {
//            answer = "Odd";
//            System.out.println(num + ":" + answer);
//        }

        return (num % 2 == 0) ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        짝수와홀수 solution = new 짝수와홀수();
        System.out.println("결과 : " + solution.evenOrOdd(4));
    }
}
