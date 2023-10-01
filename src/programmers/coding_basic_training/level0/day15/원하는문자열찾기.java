package programmers.coding_basic_training.level0.day15;

public class 원하는문자열찾기 {

    public int solution(String myString, String pat) {

        // myString 의 연속된 부분 문자열 중 pat 이 존재하면 1을, 그렇지 않으면 0을 반환하라
        // 단, 알파벳 대문자와 소문자는 구분하지 않습니다.

        int answer = 0;

        for (int i = 0; i < pat.length(); i++) {

            String my = myString.toLowerCase();
            String p = pat.toLowerCase();

            if (my.contains(p)) {

                answer = 1;

            } else {

                answer = 0;
            }

        }

        return answer;
    }

    public static void main(String[] args) {

        원하는문자열찾기 find = new 원하는문자열찾기();

        System.out.println("Result : " + find.solution("AbCdEfG", "aBc"));
        System.out.println("Result : " + find.solution("aaAA", "aaaaa"));
    }
}
