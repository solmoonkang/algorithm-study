package baekjoon.알고리즘분류.백트래킹.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 전화기키패드 {

    /**
     * 문제 설명
     * 전화기 키패드를 살펴보면 "2" = "ABC", "3" = "DEF", ..., "9" = "WXYZ"의 값을 갖는다.
     * 이때, "25"라는 숫자를 입력을 받았을 때 조합이 가능한 알파벳의 경우의 수를 모두 구하는 문제이다.
     * 더 깊게 살펴보면 숫자 "25"를 입력받았을 때, 조합 가능한 알파벳은 다음과 같다:
     * - "2" = "ABC", "5" = "JKL"
     * - AJ, AK, AL, BJ, BK, BL, CJ, CK, CL -> 9가지의 알파벳 조합을 만들 수 있다.
     * 만들어진 9가지의 알파벳 조합을 반환하는 문제를 구현하면 된다.
     */

    private static final Map<Character, String> keypadMap = new HashMap<>();
    private static final List<String> combinations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 전화기 키패드 매핑을 설정한다.
        keypadMap.put('2', "ABC");
        keypadMap.put('3', "DEF");
        keypadMap.put('4', "GHI");
        keypadMap.put('5', "JKL");
        keypadMap.put('6', "MNO");
        keypadMap.put('7', "PQRS");
        keypadMap.put('8', "TUV");
        keypadMap.put('9', "WXYZ");

        // 전화기 키패드에 입력할 즉, 알파벳 조합을 만들어 낼 숫자를 입력받는다.
        String digits = bufferedReader.readLine();

        // 입력된 숫자에 대한 조합을 생성한다.
        if (!digits.isEmpty()) generateLetterForKeypadNumber(digits, 0, new StringBuilder());
        for (String combination : combinations) bufferedWriter.write(combination + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateLetterForKeypadNumber(String digits, int index, StringBuilder currentCombination) {
        // 모든 숫자를 사용한 경우
        if (index == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        // 현재 숫자에 대한 문자들을 가져온다.
        char digit = digits.charAt(index);
        String letters = keypadMap.get(digit);

        // 각 문자에 대한 재귀 호출을 진행한다.
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);                                          // 현재 조합에 문자를 추가한다.
            generateLetterForKeypadNumber(digits, index + 1, currentCombination);       // 다음 숫자로 진행한다.
            currentCombination.deleteCharAt(currentCombination.length() - 1);           // 마지막 문자를 제거한다.
        }
    }
}
