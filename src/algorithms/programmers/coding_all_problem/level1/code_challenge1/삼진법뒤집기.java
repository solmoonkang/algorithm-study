package algorithms.programmers.coding_all_problem.level1.code_challenge1;

public class 삼진법뒤집기 {

    public int solution(int n) {
        StringBuilder builder = new StringBuilder(Integer.toString(n, 3));

        builder.reverse();

        return Integer.parseInt(builder.toString(), 3);
    }

    public static void main(String[] args) {
        삼진법뒤집기 three = new 삼진법뒤집기();

        System.out.println("three = " + three.solution(45));

        System.out.println("three = " + three.solution(125));
    }
}
