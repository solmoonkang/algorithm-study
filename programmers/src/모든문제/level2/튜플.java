package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 튜플 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String arrayAsString = bufferedReader.readLine();

        int[] parseTuple = parseTupleToIntArray(arrayAsString);
        for (int tuple : parseTuple) bufferedWriter.write(tuple + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 문제 풀이 전략
     * - 중첩된 집합들을 파싱해서 각각을 문자열 배열로 분리한다.
     * - 집합들을 길이 순으로 정렬한다.
     * - 각 집합의 숫자를 순서대로 보면서 기존에 없던 숫자만 추가한다.
     * - 튜플의 원래 순서대로 저장된 배열을 반환한다.
     */
    private static int[] parseTupleToIntArray(String arrayAsString) {
        // 입력 문자열의 양 끝 "{{"와 "}}"를 제거한다.
        String trimmed = arrayAsString.substring(2, arrayAsString.length() - 2);
        // "},{" 구분자로 집합들을 나눈다. -> ["2", "2,1", "2,1,3", "2,1,3,4"]
        String[] sets = trimmed.split("\\},\\{");

        // 집합들을 길이 기준으로 오름차순 정렬한다.
        Arrays.sort(sets, Comparator.comparingInt(String::length));

        // 중복된 숫자 방지를 위한 Set, 결과를 담을 List
        Set<String> seen = new HashSet<>();
        List<Integer> parseTuple = new ArrayList<>();

        for (String set : sets) {
            String[] numbers = set.split(",");
            for (String number : numbers) {
                // 중복되지 않은 숫자라면 결과 List에 추가한다.
                if (seen.add(number)) parseTuple.add(Integer.parseInt(number));
            }
        }

        return parseTuple.stream().mapToInt(i -> i).toArray();
    }
}
