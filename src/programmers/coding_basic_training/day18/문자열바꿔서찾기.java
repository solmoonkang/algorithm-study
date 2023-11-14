package programmers.coding_basic_training.day18;

public class 문자열바꿔서찾기 {

    public int solution(String myString, String pat) {

        // myString 의 "A"를 "B"로,    "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중
        // pat 이 있으면 1을, 아니면 0을 반환하라

        String before = myString.replace("A", "C");
        String after = before.replace("B", "A");
        String answer = after.replace("C", "B");

        if (answer.contains(pat)) {

            return 1;

        } else {

            return 0;

        }
    }

    public int solution_other(String myString, String pat) {

        myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");

        return myString.contains(pat) ? 1 : 0;

    }

    public static void main(String[] args) {

        문자열바꿔서찾기 find = new 문자열바꿔서찾기();

        System.out.println("Result : " + find.solution("ABBAA", "AABB"));
        System.out.println("Result : " + find.solution("ABAB", "ABAB"));
    }
}
