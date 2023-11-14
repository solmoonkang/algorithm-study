package programmers.coding_basic_training.day16;

public class 특정한문자를대문자로바꾸기 {

    public String solution(String my_string, String alp) {

        // 영소문자로 이루어진 문자열 my_string 과 영소문자 1글자로 이루어진 문자열 alp 가 매개변수로 주어질 때,
        // my_string 에서 alp 에 해당하는 모든 글자를 대문자로 바꾼 문자열을 반환하라

        String answer = my_string.replace(alp, alp.toUpperCase());

        return answer;
    }

    public static void main(String[] args) {

        특정한문자를대문자로바꾸기 upper = new 특정한문자를대문자로바꾸기();

        System.out.println("Result : " + upper.solution("programmers", "p"));
        System.out.println("Result : " + upper.solution("lowercase", "x"));
    }
}
