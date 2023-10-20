package programmers.coding_basic_training.level0.day22;

import java.math.BigInteger;

public class 두수의합 {

    public String solution(String a, String b) {

        // 0 이상의 두 정수가 문자열 a, b로 주어질 때, a + b 의 값을 문자열로 반환하라

        BigInteger x = new BigInteger(a);
        BigInteger y = new BigInteger(b);

        BigInteger answer = x.add(y);

        return answer.toString();
    }

    public static void main(String[] args) {

        두수의합 sum = new 두수의합();

        System.out.println("Result : " + sum.solution("582", "734"));
        System.out.println("Result : " + sum.solution("18446744073709551615", "287346502836570928366"));
        System.out.println("Result : " + sum.solution("0", "0"));
    }
}
