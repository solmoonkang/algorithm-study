package codingTest.level0.day4_calculate_condition;

import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class 조건문자열 {

    /**
     * 문제 설명
     *
     * ineq 는 "<" 와 ">" 중 하나이고,
     * eq 는 "=" 와 "!" 중 하나이다
     * n 과 m 이 ineq 와 eq 의 조건에 맞으면 1을 아니면 0을 반환한다
     */

    public int solution_my(String ineq, String eq, int n, int m) {

        // Runtime Error

//        int answer = 0;
//
//        // 만약, ineq 가 < 이고 eq 가 = 일 경우
//        if (Objects.equals(ineq, "<") && Objects.equals(eq, "=")) {
//
//            // n 과 m 을 <= 으로 비교하고, 참일 경우 1을 거짓일 경우 0을 반환하도록 한다
//            if (n <= m) {
//                answer = 1;
//            } else {
//                answer = 0;
//            }
//        } else if (Objects.equals(ineq, ">") && Objects.equals(eq, "=")) {
//
//            if (n >= m) {
//                answer = 1;
//            } else {
//                answer = 0;
//            }
//        } else if (Objects.equals(ineq, ">") && Objects.equals(eq, "!")) {
//
//            if (n > m) {
//                answer = 1;
//            } else {
//                answer = 0;
//            }
//        } else {
//
//            if (n < m) {
//                answer = 1;
//            } else {
//                answer = 0;
//            }
//        }
//
//        return answer;

        if (ineq.contains(">")) {

            if (eq.contains("=")) {
                return n >= m ? 1 : 0;
            } else if (eq.contains("!")) {
                return n > m ? 1 : 0;
            }
        } else if (ineq.contains("<")) {

            if (eq.contains("=")) {
                return n <= m ? 1 : 0;
            } else if (eq.contains("!")) {
                return n < m ? 1 : 0;
            }
        }

        return 0;
    }

    public int solution_best(String ineq, String eq, int n, int m) {

        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
                ">=", (a, b) -> a >= b,
                "<=", (a, b) -> a <= b,
                ">!", (a, b) -> a > b,
                "<!", (a, b) -> a < b
        );

        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }

    public static void main(String[] args) {

        조건문자열 result = new 조건문자열();

        Scanner scanner = new Scanner(System.in);

        String ineq = scanner.nextLine();
        String eq = scanner.nextLine();

        System.out.println("Result My : " + result.solution_my(ineq, eq, 20, 50));
        System.out.println("Result Best : " + result.solution_best(ineq, eq, 20, 50));
//        System.out.println(result.solution_my(ineq, eq, 41, 78));
    }
}
