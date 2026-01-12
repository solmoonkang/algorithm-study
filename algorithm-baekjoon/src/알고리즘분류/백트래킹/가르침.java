package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가르침 {

    private static final int ALPHABET_COUNT = 26;
    private static final char[] antarcticCharacter = {'a', 'n', 't', 'i', 'c'};
    private static final Set<String> antarcticLanguage = new HashSet<>();
    private static final boolean[] visited = new boolean[ALPHABET_COUNT];

    private static int N, K;
    private static int maxWordCombinations = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) antarcticLanguage.add(bufferedReader.readLine());
        for (char alphabet : antarcticCharacter) visited[alphabet - 'a'] = true;

        generateCombinationsFromRemainingCharacters(0, 0);
        bufferedWriter.write(String.valueOf(maxWordCombinations));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateCombinationsFromRemainingCharacters(int start, int count) {
        if (count == (K - antarcticCharacter.length)) {
            maxWordCombinations = Math.max(maxWordCombinations, countReadableWordsWithCombination());
            return;
        }

        for (int i = start; i < ALPHABET_COUNT; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateCombinationsFromRemainingCharacters(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 현재 선택된 알파벳 조합을 기반으로 각 단어가 그 조합을 포함하고 있는지를 검사해야 한다.
    private static int countReadableWordsWithCombination() {
        int readableWordCombination = 0;
        // 현재 선택된 알파벳들을 저장하기 위해 사용된다. 즉, visited 배열에서 true인 인덱스에 해당하는 알파벳을 수집하여, 나중에 각 단어가 이 알파벳들을 포함하고 있는지를 확인하는 데 사용된다.
        Set<Character> selectedLetters = new HashSet<>();

        // 현재 선택된 알파벳을 Set에 추가한다.
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            // visited 배열은 각 알파벳이 현재 선택되었는지를 나타낸다. true인 경우 해당 알파벳이 선택되었다는 의미이다.
            if (visited[i]) selectedLetters.add((char) (i + 'a'));
        }

        // 각 단어에 대해 읽을 수 있는지 체크한다. antarcticLanguage에 있는 각 단어가 현재 선택된 알파벳을 모두 포함하고 있는지를 확인한다.
        for (String word : antarcticLanguage) {
            // 각 단어의 문자를 하나씩 검사한다.
            boolean canReadable = true;

            for (char alphabet : word.toCharArray()) {
                // 만약, 현재 선택된 알파벳에 포함되지 않는 문자가 발견되면, canReadable를 false로 설정하고, break로 반복문을 종료한다.
                if (!selectedLetters.contains(alphabet)) {
                    canReadable = false;
                    // 한 번이라도 선택된 알파벳에 포함되지 않는 문자가 발견되면 그 단어는 더 이상 읽을 수 없다는 것을 의미한다.
                    // 따라서 모든 문자를 검사할 필요 없이 즉시 루프를 종료하고 다음 단어로 넘어간다.
                    break;
                }
            }

            if (canReadable) readableWordCombination++;
        }

        return readableWordCombination;
    }
}
