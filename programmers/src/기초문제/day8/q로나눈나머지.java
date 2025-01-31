package 기초문제.day8;

import java.math.BigInteger;

public class q로나눈나머지 {

    public int solution(String number) {

        // 음이 아닌 정수를 9로 나눈 나머지 -> number / 9 = 몫...나머지
        // 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같다 -> number 의 각 자리 숫자
        // 예를 들어, 123일 경우, 1 + 2 + 3 / 9 = 몫...나머지

        // 단, number 는 정수 0이 아니라면, 0으로 시작하지 않는다

        // 문자열을 숫자로 바꿔야 함 -> Integer.parseInt( ), Integer.valueOf( )
        // int answer = Integer.valueOf(number);

        BigInteger a = new BigInteger(number);
        BigInteger b = new BigInteger("9");

        BigInteger result = a.mod(b);

        int sum = result.intValue();

        return sum;
    }

    public static void main(String[] args) {

        q로나눈나머지 rest = new q로나눈나머지();

        System.out.println("Result : " + rest.solution("123"));
        System.out.println("Result : " + rest.solution("78720646226947352489"));
    }
}
