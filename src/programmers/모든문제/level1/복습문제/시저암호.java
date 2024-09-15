package programmers.모든문제.level1.복습문제;

public class 시저암호 {

    // TODO: 아스키코드로 'z' 혹은 'Z'로 끝날 경우, 해당 알파벳이 다시 'a' 혹은 'A'로 시작할 수 있도록 하는 부분에서 미숙하다.
    public String solution(String s, int n) {
        StringBuilder encrypt = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c - base + n) % 26 + base);
                encrypt.append(shifted);
            } else {
                encrypt.append(c);
            }
        }

        return encrypt.toString();
    }

    public static void main(String[] args) {
        시저암호 problem = new 시저암호();

        System.out.println("problem = " + problem.solution("AB", 1));
        System.out.println("problem = " + problem.solution("z", 1));
        System.out.println("problem = " + problem.solution("a B z", 4));
    }
}
