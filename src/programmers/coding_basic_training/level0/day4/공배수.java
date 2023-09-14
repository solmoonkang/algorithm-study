package programmers.coding_basic_training.level0.day4;

public class 공배수 {

    public int solution_my(int number, int n, int m) {

        int answerN = number % n;
        int answerM = number % m;

        if (answerN == 0 && answerM == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int solution_best(int number, int n, int m) {

        int answer = (number % n == 0) && (number % m == 0) ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {

        공배수 result = new 공배수();

        System.out.println("Result : " + result.solution_my(60, 2, 3));
        System.out.println("Result : " + result.solution_my(55, 10, 5));
        System.out.println("======================================");

        System.out.println("Result : " + result.solution_best(60, 2, 3));
        System.out.println("Result : " + result.solution_best(60, 10, 5));
    }
}
