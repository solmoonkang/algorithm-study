package programmers.coding_basic_training.level0.practice;

import java.util.Arrays;

public class n보다커질때까지더하기 {

    public int solution(int[] numbers, int n) {

        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {

            answer += numbers[i];

            if (answer > n) {
                break;
            }
        }

        return answer;
    }

    public int solution_best(int[] numbers, int n) {
        return Arrays.stream(numbers).reduce(0, (acc, i) -> n >= acc ? acc + i : acc);
    }

    public static void main(String[] args) {

        n보다커질때까지더하기 plus = new n보다커질때까지더하기();

        int[] numbers1 = {34, 5, 71, 29, 100, 34};
        int[] numbers2 = {58, 44, 27, 10, 100};

        System.out.println("Bigger Than N : " + plus.solution(numbers1, 123));
        System.out.println("Bigger Than N : " + plus.solution(numbers2, 239));
    }
}
