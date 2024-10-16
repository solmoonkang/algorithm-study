package programmers.기출문제.KAKAO_BLIND_RECRUITMENT_2018;

public class 다트게임 {

    // TODO: 옵션 처리를 하는 부분에서 이해를 완전히 하지 못했다. 다시 한 번 풀어보자.
    public int solution(String dartResult) {
        char[] dartGame = dartResult.toCharArray();
        int[] scores = new int[3];
        int scoreIndex = 0;

        for (int i = 0; i < dartGame.length; i++) {
            if (Character.isDigit(dartGame[i])) {
                int score = Character.getNumericValue(dartGame[i]);

                if (i + 1 < dartGame.length && dartGame[i + 1] == '0') {
                    score = 10;
                    i++;
                }

                i++;
                char bonus = dartGame[i];

                if (bonus == 'S') scores[scoreIndex] = score;
                else if (bonus == 'D') scores[scoreIndex] = (int) Math.pow(score, 2);
                else if (bonus == 'T') scores[scoreIndex] = (int) Math.pow(score, 3);
                scoreIndex++;
            }

            if (i + 1 < dartGame.length) {
                if (dartGame[i + 1] == '*' || dartGame[i + 1] == '#') {
                    char option = dartGame[i + 1];
                    if (option == '*') {
                        scores[scoreIndex - 1] *= 2;
                        if (scoreIndex > 1) scores[scoreIndex - 2] *= 2;
                    } else if (option == '#') scores[scoreIndex - 1] *= -1;
                    i++;
                }

            }
        }

        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }

    public static void main(String[] args) {
        다트게임 problem = new 다트게임();

        System.out.println("problem = " + problem.solution("1S2D*3T"));
        System.out.println("problem = " + problem.solution("1D2S#10S"));
    }
}
