package programmers.coding_basic_training.level0.day23;

public class 부분문자열 {

    public int solution(String str1, String str2) {

        // str1 이 str2 의 부분 문자열이라면 1을
        // 부분 문자열이 아니라면 0을 반환하라

        return str2.contains(str1) ? 1 : 0;
    }

    public static void main(String[] args) {

        부분문자열 part = new 부분문자열();

        System.out.println("Result : " + part.solution("abc", "aabcc"));
        System.out.println("Result : " + part.solution("tbt", "tbbttb"));

    }
}
