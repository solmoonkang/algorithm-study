package 모든문제.level1.복습문제;

public class 하샤드수 {

    public boolean solution(int x) {
        int digits = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            digits += Character.getNumericValue(c);
        }

        return x % digits == 0;
    }

    public static void main(String[] args) {
        하샤드수 problem = new 하샤드수();

        System.out.println("problem = " + problem.solution(10));
        System.out.println("problem = " + problem.solution(12));
        System.out.println("problem = " + problem.solution(11));
        System.out.println("problem = " + problem.solution(13));
    }
}
