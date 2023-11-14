package programmers.coding_basic_training.day3;

public class 문자열섞기 {

    public String solution(String str1, String str2) {

        String answer = "";

        for (int i = 0; i < str1.length(); i++) {

            answer += str1.substring(i, i + 1);
            answer += str2.substring(i, i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        String str1 = "aaaaa";
        String str2 = "bbbbb";

        문자열섞기 mix = new 문자열섞기();

        System.out.println("Result : " + mix.solution(str1, str2));
    }
}
