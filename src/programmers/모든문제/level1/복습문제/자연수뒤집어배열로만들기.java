package programmers.모든문제.level1.복습문제;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        StringBuilder reverseNumber = new StringBuilder(String.valueOf(n)).reverse();

        int[] answer = new int[reverseNumber.length()];
        for (int i = 0; i < reverseNumber.length(); i++) {
            answer[i] = Character.getNumericValue(reverseNumber.toString().charAt(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        자연수뒤집어배열로만들기 problem = new 자연수뒤집어배열로만들기();

        System.out.println("problem = " + Arrays.toString(problem.solution(12345)));
    }
}
