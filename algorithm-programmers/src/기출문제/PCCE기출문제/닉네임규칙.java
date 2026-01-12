package 기출문제.PCCE기출문제;

public class 닉네임규칙 {

    public String solution(String nickname) {
        String answer = "";

        for (int i = 0; i < nickname.length(); i++) {
            if (nickname.charAt(i) == 'l') answer += "I";
            else if (nickname.charAt(i) == 'w') answer += "vv";
            else if (nickname.charAt(i) == 'W') answer += "VV";
            else if (nickname.charAt(i) == 'O') answer += "0";
            else answer += nickname.charAt(i);
        }

        if (answer.length() < 3) answer += "o".repeat(4 - answer.length());
        if (answer.length() > 8) answer = answer.substring(0, 8);

        return answer;
    }

    public static void main(String[] args) {
        닉네임규칙 problem = new 닉네임규칙();

        System.out.println("problem = " + problem.solution("WORLDworld"));
        System.out.println("problem = " + problem.solution("GO"));
    }
}
