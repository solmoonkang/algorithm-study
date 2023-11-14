package programmers.coding_basic_training.day21;

public class 문자열정수의합 {

    public int solution(String num_str) {

        // 한 자리 정수로 이루어진 문자열의 각 자리수 합을 반환하라

        int answer = 0;

        for (int i = 0; i < num_str.length(); i++) {

            answer += Integer.parseInt(String.valueOf(num_str.charAt(i)));

        }

        return answer;
    }

    public static void main(String[] args) {

        문자열정수의합 sum = new 문자열정수의합();

        System.out.println("Result : " + sum.solution("123456789"));
        System.out.println("Result : " + sum.solution("1000000"));
    }
}
