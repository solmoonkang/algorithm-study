package 모든문제.level1.복습문제;

public class 크기가작은부분문자열 {

    public int solution(String t, String p) {
        int count = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String answer = t.substring(i, i + p.length());
            if (Long.parseLong(answer) <= Long.parseLong(p)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        크기가작은부분문자열 problem = new 크기가작은부분문자열();

        System.out.println("problem = " + problem.solution("3141592", "271"));
        System.out.println("problem = " + problem.solution("500220839878", "7"));
        System.out.println("problem = " + problem.solution("10203", "15"));
    }
}
