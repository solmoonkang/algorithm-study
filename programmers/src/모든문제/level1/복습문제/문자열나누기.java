package 모든문제.level1.복습문제;

public class 문자열나누기 {

    public int solution(String s) {
        int countX = 0;
        int countNotX = 0;
        int answer = 0;

        char firstChar = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == firstChar) countX++;
            else countNotX++;

            if (countX == countNotX) {
                answer++;
                countX = 0;
                countNotX = 0;

                // 다음 문자열의 첫 글자를 업데이트
                if (i + 1 < s.length()) firstChar = s.charAt(i + 1);
            }
        }

        // 남은 부분이 있다면 추가로 하나 증가
        if (countX > 0 || countNotX > 0) answer++;

        return answer;
    }

    public static void main(String[] args) {
        문자열나누기 problem = new 문자열나누기();

        System.out.println("problem = " + problem.solution("banana"));
        System.out.println("problem = " + problem.solution("abracadabra"));
        System.out.println("problem = " + problem.solution("aaabbaccccabba"));
    }
}
