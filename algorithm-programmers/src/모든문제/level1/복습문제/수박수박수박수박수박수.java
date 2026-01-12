package 모든문제.level1.복습문제;

public class 수박수박수박수박수박수 {

    public String solution(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) builder.append("박");
            else builder.append("수");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 problem = new 수박수박수박수박수박수();

        System.out.println("problem = " + problem.solution(3));
        System.out.println("problem = " + problem.solution(4));
    }
}
