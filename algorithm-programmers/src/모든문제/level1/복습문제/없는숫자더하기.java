package 모든문제.level1.복습문제;

public class 없는숫자더하기 {

    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }

    public static void main(String[] args) {
        없는숫자더하기 problem = new 없는숫자더하기();

        int[] numbers1 = {1,2,3,4,6,7,8,0};
        System.out.println("problem = " + problem.solution(numbers1));

        int[] numbers2 = {5,8,4,0,6,7,9};
        System.out.println("problem = " + problem.solution(numbers2));
    }
}
