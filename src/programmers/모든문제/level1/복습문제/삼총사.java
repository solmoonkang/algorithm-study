package programmers.모든문제.level1.복습문제;

public class 삼총사 {

    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        삼총사 problem = new 삼총사();

        int[] number1 = {-2, 3, 0, 2, -5};
        System.out.println("problem = " + problem.solution(number1));

        int[] number2 = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println("problem = " + problem.solution(number2));

        int[] number3 = {-1, 1, -1, 1};
        System.out.println("problem = " + problem.solution(number3));
    }
}
