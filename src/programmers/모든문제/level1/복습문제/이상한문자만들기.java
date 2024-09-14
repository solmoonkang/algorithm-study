package programmers.모든문제.level1.복습문제;

public class 이상한문자만들기 {

    public String solution(String s) {
        String[] words = s.toUpperCase().split(" ");
        StringBuilder answer = new StringBuilder();

        for (String word : words) {
            StringBuilder transformedWord = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char currentWord = word.charAt(i);
                if (i % 2 == 0) transformedWord.append(Character.toUpperCase(currentWord));
                else transformedWord.append(Character.toLowerCase(currentWord));
            }

            answer.append(transformedWord).append(" ");
        }

        return answer.toString().trim();
    }

    public static void main(String[] args) {
        이상한문자만들기 problem = new 이상한문자만들기();

        System.out.println("problem = " + problem.solution("try hello world"));
    }
}
