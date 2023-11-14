package programmers.coding_basic_training.day3;

public class 두수의연산값비교하기 {

    public int solution_my(int a, int b) {

        int num = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int result = 2 * a * b;

        if (num == result) {
            return num;
        } else if (num > result) {
            return num;
        } else {
            return result;
        }
    }

    public int solution_best(int a, int b) {

        return Math.max(Integer.parseInt(String.valueOf(a) + String.valueOf(b)), 2 * a * b);
    }

    public static void main(String[] args) {

        두수의연산값비교하기 compare = new 두수의연산값비교하기();

        System.out.println("Result : " + compare.solution_my(2, 91));
        System.out.println("Result : " + compare.solution_my(91, 2));
        System.out.println("======================================");

        System.out.println("Result : " + compare.solution_best(2, 91));
        System.out.println("Result : " + compare.solution_best(91, 2));
    }
}
