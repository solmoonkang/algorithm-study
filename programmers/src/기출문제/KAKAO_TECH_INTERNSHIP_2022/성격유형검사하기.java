package 기출문제.KAKAO_TECH_INTERNSHIP_2022;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    // TODO: 다른 사람 문제 풀이를 참고하여 해결했음. 다시 한 번 더 풀어보자.

    public String solution(String[] survey, int[] choices) {
        // choice에서 1~3점이 나오면, type의 첫 글자를 해시맵에 넣고, -3점을 추가한다.
        // choice에서 5~7점이 나오면, type의 끝 글자를 해시맵에 넣고, +3점을 추가한다.
        // choice에서 4점이 나오면, 아무런 값도 해시맵에 넣지 않는다.
        Map<Character, Integer> personalityType = new HashMap<>();

        personalityType.put('R', 0);
        personalityType.put('T', 0);
        personalityType.put('C', 0);
        personalityType.put('F', 0);
        personalityType.put('J', 0);
        personalityType.put('M', 0);
        personalityType.put('A', 0);
        personalityType.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];

            if (choice < 4) {
                int score = 4 - choice;
                personalityType.put(type.charAt(0), personalityType.get(type.charAt(0)) + score);
            } else if (choice > 4) {
                int score = choice - 4;
                personalityType.put(type.charAt(1), personalityType.get(type.charAt(1)) + score);
            }
        }

        return String.valueOf(getPersonalityType(personalityType, 'R', 'T')) +
                getPersonalityType(personalityType, 'C', 'F') +
                getPersonalityType(personalityType, 'J', 'M') +
                getPersonalityType(personalityType, 'A', 'N');
    }

    public char getPersonalityType(Map<Character, Integer> personalityType, char type1, char type2) {
        int score1 = personalityType.get(type1);
        int score2 = personalityType.get(type2);

        if (score1 > score2) {
            return type1;
        } else if (score1 < score2) {
            return type2;
        } else {
            return (type1 < type2 ? type1 : type2);
        }
    }

    public static void main(String[] args) {
        성격유형검사하기 personalityTypeAssessment = new 성격유형검사하기();

        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};
        System.out.println("personalityTypeAssessment = " + personalityTypeAssessment.solution(survey1, choices1));

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};
        System.out.println("personalityTypeAssessment = " + personalityTypeAssessment.solution(survey2, choices2));
    }
}
