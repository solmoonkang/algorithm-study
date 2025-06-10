package 모든문제.level2;

import java.io.*;

public class 모음사전 {

    /**
     * char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
     *  - 사전에 포함된 알파벳은 고정되어 있으므로, 인덱스를 쉽게 찾기 위해 배열로 선언한다.
     *  - "A"는 0, "E"는 1, ..., "U"는 4로 인덱스화된다.
     *
     * int[] WEIGHTS = {781, 156, 31, 6, 1};
     *  - 각 자릿수의 가중치를 미리 계산해 둔다.
     *  weights[0] = 5^4 + 5^3 + 5^2 + 5^1 + 5^0 = 781
     *  weights[1] = 5^3 + 5^2 + 5^1 + 5^0 = 156
     *  weights[2] = 5^2 + 5^1 + 5^0 = 31
     *  weights[3] = 5^1 + 5^0 = 6
     *  weights[4] = 5^0 = 1
     */
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static final int[] WEIGHTS = {781, 156, 31, 6, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        int index = getPositionWordInDictionary(word);
        bufferedWriter.write(String.valueOf(index));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getPositionWordInDictionary(String word) {
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char currentAlphabet = word.charAt(i);
            int index = 0;

            for (int j = 0; j < VOWELS.length; j++) {
                if (VOWELS[j] == currentAlphabet) {
                    index = j;
                    break;
                }
            }

            answer += index * WEIGHTS[i] + 1;
        }

        return answer;
    }
}
