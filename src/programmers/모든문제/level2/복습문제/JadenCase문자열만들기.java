package programmers.모든문제.level2.복습문제;

public class JadenCase문자열만들기 {

    // TODO: TEST8 케이스 실패,
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] splitString = s.split(" ");

        for (String word : splitString) {
            if (!word.isEmpty()) answer.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
            else answer.append(" ");
        }

        return answer.toString().trim();
    }

    public static void main(String[] args) {
        JadenCase문자열만들기 problem = new JadenCase문자열만들기();

        System.out.println("problem = " + problem.solution("3people unFollowed me"));
        System.out.println("problem = " + problem.solution("for the last week"));
    }
}
