package programmers.coding_basic_introduction;

import java.util.Arrays;

public class 이해되지않았던문제들 {

    public int[] determineCareerPaths(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            // 외부 반복문이 한 번 반복할 때마다, 내부 반복문은 전체를 다시 반복한다.
            // 즉, i가 0일 때, j는 0부터 emergency.length 까지 반복하게 된다. 다시 i가 1일 때, j는 0부터 반복한다.
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) {
                    answer[i]++;
                }
            }
            answer[i]++;
        }
        return answer;
    }

    public String morseCode(String letter) {
        String[] morseCode = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        String[] morse = letter.split(" ");

        String answer = "";
        for (String s : morse) {
            for (int i = 0; i < morseCode.length; i++) {
                if (morseCode[i].equals(s)) {
                    answer += Character.toString(i + 'a');
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        이해되지않았던문제들 notSolvedProblems = new 이해되지않았던문제들();
        int[] firstEmergency = {3, 76, 24};
        int[] secondEmergency = {1, 2, 3, 4, 5, 6, 7};
        int[] thirdEmergency = {30, 10, 23, 6, 100};
        System.out.println("Result: " + Arrays.toString(notSolvedProblems.determineCareerPaths(firstEmergency)));
        System.out.println("Result: " + Arrays.toString(notSolvedProblems.determineCareerPaths(secondEmergency)));
        System.out.println("Result: " + Arrays.toString(notSolvedProblems.determineCareerPaths(thirdEmergency)));

        System.out.println("Result: " + notSolvedProblems.morseCode(".... . .-.. .-.. ---"));
        System.out.println("Result: " + notSolvedProblems.morseCode(".--. -.-- - .... --- -."));
    }
}
