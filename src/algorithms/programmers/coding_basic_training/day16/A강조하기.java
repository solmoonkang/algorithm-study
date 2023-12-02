package algorithms.programmers.coding_basic_training.day16;

public class A강조하기 {

    public String solution(String myString) {

        // myString 에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고,
        // "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 반환하라

        String answer = "";

        String my = myString.toLowerCase();

        answer = my.replace("a", "A");

        return answer;
    }

    public static void main(String[] args) {

        A강조하기 a = new A강조하기();

        System.out.println("Result : " + a.solution("abstract algebra"));
        System.out.println("Result : " + a.solution("PrOgRaMmErS"));
    }
}
