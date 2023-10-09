package programmers.coding_basic_training.level0.day17;

public class 특정문자열로끝나는가장긴부분문자열찾기 {

    public String solution(String myString, String pat) {

        // myString 의 부분 문자열 중 pat 으로 끝나는 가장 긴 부분 문자열을 찾아서 반환하라

        int index = myString.lastIndexOf(pat);

        String answer = myString.substring(0, index) + pat;

        return answer;
    }

    public static void main(String[] args) {

        특정문자열로끝나는가장긴부분문자열찾기 find = new 특정문자열로끝나는가장긴부분문자열찾기();

        System.out.println("Result : " + find.solution("AbCdEFG", "dE"));
        System.out.println("Result : " + find.solution("AAAAaaaa", "a"));
    }
}
