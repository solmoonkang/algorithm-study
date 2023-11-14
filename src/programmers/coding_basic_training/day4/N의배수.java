package programmers.coding_basic_training.day4;

public class N의배수 {

    public int solution_my(int num, int n) {

        int answer = num % n;

        if (answer == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int solution_best(int num, int n) {

        int answer = num % n == 0 ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {

        N의배수 result = new N의배수();

        System.out.println("Result : " + result.solution_my(98, 2));
        System.out.println("Result : " + result.solution_my(34, 3));
        System.out.println("======================================");

        System.out.println("Result : " + result.solution_best(98, 2));
        System.out.println("Result : " + result.solution_best(34, 3));
    }
}
