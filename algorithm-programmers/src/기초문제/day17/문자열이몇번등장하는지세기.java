package 기초문제.day17;

public class 문자열이몇번등장하는지세기 {

    public int solution(String myString, String pat) {

        // myString 에서 pat 이 등장하는 횟수를 반환하라

        int answer = 0;

        for (int i = 0; i <= myString.length() - pat.length(); i++) {

            if (myString.substring(i, i + pat.length()).contains(pat)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        문자열이몇번등장하는지세기 count = new 문자열이몇번등장하는지세기();

        System.out.println("Result : " + count.solution("banana", "ana"));
        System.out.println("Result : " + count.solution("aaaa", "aa"));
    }
}
