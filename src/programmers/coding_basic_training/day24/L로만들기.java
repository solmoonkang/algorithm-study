package programmers.coding_basic_training.day24;

public class L로만들기 {

    public String solution(String myString) {

        // 알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 반환하라

        StringBuilder answer = new StringBuilder(myString);

        for (int i = 0; i < myString.length(); i++) {

            if ('l' > myString.charAt(i)) {

                answer.deleteCharAt(i);
                answer.insert(i, 'l');
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        L로만들기 l = new L로만들기();

        System.out.println("Result : " + l.solution("abcdevwxyz"));
        System.out.println("Result : " + l.solution("jjnnllkkmm"));
    }
}
