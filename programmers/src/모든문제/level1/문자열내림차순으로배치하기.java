package 모든문제.level1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 문자열내림차순으로배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        String sort = sortSentenceDesc(sentence);
        bufferedWriter.write(sort);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String sortSentenceDesc(String sentence) {
        char[] chars = sentence.toCharArray();
        Character[] characters = new Character[chars.length];

        for (int i = 0; i < chars.length; i++) characters[i] = chars[i];
        Arrays.sort(characters, Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (char alphabet : characters) stringBuilder.append(alphabet);

        return stringBuilder.toString();
    }

    /**
     * 1. 박싱/언박싱 비용
     * char → int → Integer → 정렬 → int → char
     * → 필요 이상의 변환이 반복됨. 특히 Integer[]를 쓰면 자동 박싱/언박싱이 발생해서 오버헤드가 조금 생깁니다.
     * <p>
     * 2. 간단한 방식으로도 가능함
     * char[]는 Arrays.sort()로 정렬 가능하니까, 다음과 같이 줄일 수 있어요:
     */
    private static String wrongSolution(String sentence) {
        Integer[] sequence = new Integer[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) sequence[i] = (int) sentence.charAt(i);

        Arrays.sort(sequence, Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (int number : sequence) stringBuilder.append((char) number);

        return stringBuilder.toString();
    }

    private static String anotherSolution(String sentence) {
        return sentence.chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new,
                        (builder, i) -> builder.append((char) (int) i),
                        StringBuilder::append)
                .toString();
    }
}
