package programmers.모든문제.level1.복습문제;

public class 자릿수더하기 {

    public int solution(int n) {
        int answer = 0;

        for (char c : String.valueOf(n).toCharArray()) {
            answer += Character.getNumericValue(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        자릿수더하기 problem = new 자릿수더하기();

        System.out.println("problem = " + problem.solution(123));
        System.out.println("problem = " + problem.solution(987));
    }
}
