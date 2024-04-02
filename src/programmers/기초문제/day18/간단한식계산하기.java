package programmers.기초문제.day18;

public class 간단한식계산하기 {

    public int solution(String binomial) {

        // binomial 은 "a op b" 형태의 이항식이고, a와 b는 음이 아닌 정수, op는 '+, -, *' 중 하나이다
        // 주어진 식을 계산한 정수를 반환하라

        // 문자열 binomial 을 a op b 형태로 저장한다 -> 공백으로 구분..?

        String[] str = binomial.split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[2]);

        String op = str[1];

        int result = 0;

        if (op.equals("+")) {

            result = a + b;

        } else if (op.equals("-")) {

            result = a - b;

        } else if (op.equals("*")) {

            result = a * b;

        }


        return result;
    }

    public static void main(String[] args) {

        간단한식계산하기 calculate = new 간단한식계산하기();

        System.out.println("Result : " + calculate.solution("43 + 12"));
        System.out.println("Result : " + calculate.solution("0 - 7777"));
        System.out.println("Result : " + calculate.solution("40000 * 40000"));
    }
}
