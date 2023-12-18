package algorithms.programmers.coding_all_problem.level1.codechallenge3;

public class 없는숫자더하기 {

    /**
     * [ 문제 설명 ]
     * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
     * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
     */
    public int solution(int[] numbers) {
        // 0~9까지 모두 더한 수에서 numbers 배열에 있는 값들을 모두 더한 값을 뺀다.
        int answer = 45;

        for (int i = 0; i < numbers.length; i++) {
            answer -= numbers[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // commit: adding missing numbers
        없는숫자더하기 addMissingNumbers = new 없는숫자더하기();
        int[] firstNumbers = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] secondNumbers = {5, 8, 4, 0, 6, 7, 9};
        System.out.println("Result: " + addMissingNumbers.solution(firstNumbers));
        System.out.println("Result: " + addMissingNumbers.solution(secondNumbers));
    }
}
