package 모든문제.level1.복습문제;

public class 가운데글자가져오기 {

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        if (s.length() % 2 == 0) builder.append(s.charAt(s.length() / 2 - 1)).append(s.charAt(s.length() / 2));
        else builder.append(s.charAt(s.length() / 2));

        return builder.toString();
    }

    public static void main(String[] args) {
        가운데글자가져오기 problem = new 가운데글자가져오기();

        System.out.println("problem = " + problem.solution("abcde"));
        System.out.println("problem = " + problem.solution("qwer"));
    }
}
