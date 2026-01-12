package 모든문제.level1;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class 성격유형검사하기 {

    private static final String[] PERSONALITY_TYPE_PAIRS = {"RT", "CF", "JM", "AN"};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] survey = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            survey[i] = stringTokenizer.nextToken();
        }

        int[] choices = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            choices[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        String personalityType = getPersonalityTypeTestResult(survey, choices);
        bufferedWriter.write(personalityType);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getPersonalityTypeTestResult(String[] survey, int[] choices) {
        // 성격 유형에 따른 점수를 저장하는 Map을 생성
        Map<Character, Integer> scoreMap = new HashMap<>();
        for (String pair : PERSONALITY_TYPE_PAIRS) {
            scoreMap.put(pair.charAt(0), 0);
            scoreMap.put(pair.charAt(1), 0);
        }

        // 설문 조사로 받은 각 유형별 점수를 계산
        for (int i = 0; i < survey.length; i++) {
            // choices 배열의 각 점수가 4 미만일 때와 4 초과일 때를 조건으로 분류하여 계산을 진행
            char targetAlphabet = ' ';
            int score = 0;

            if (choices[i] < 4) {
                // 비동의 성격 유형이 점수를 얻는 경우
                targetAlphabet = survey[i].charAt(0);
                score = 4 - choices[i];
            } else if (choices[i] > 4) {
                // 동의 성격 유형이 점수를 얻는 경우
                targetAlphabet = survey[i].charAt(1);
                score = choices[i] - 4;
            }

            // 성격 유형에 따른 점수를 저장하는 Map에 어떤 성격 유형이 몇 점의 점수를 얻었는지 기록
            scoreMap.put(targetAlphabet, scoreMap.getOrDefault(targetAlphabet, 0) + score);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String pair : PERSONALITY_TYPE_PAIRS) {
            char personalityType1 = pair.charAt(0);
            char personalityType2 = pair.charAt(1);

            int score1 = scoreMap.get(personalityType1);
            int score2 = scoreMap.get(personalityType2);

            // 두 성격 유형 중 더 점수가 높은 유형을 선택
            if (score1 > score2) stringBuilder.append(personalityType1);
            else if (score2 > score1) stringBuilder.append(personalityType2);
            else {
                // 점수가 동일할 경우 사전 순으로 더 빠른 성격 유형을 선택
                if (personalityType1 < personalityType2) stringBuilder.append(personalityType1);
                else stringBuilder.append(personalityType2);
            }
        }

        return stringBuilder.toString();
    }
}
