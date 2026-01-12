package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 뉴스클러스터링 {

    private static final int MOD = 65536;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String str1 = stringTokenizer.nextToken();
        String str2 = stringTokenizer.nextToken();

        int jaccardSimilarity = getJaccardSimilarity(str1, str2);
        bufferedWriter.write(String.valueOf(jaccardSimilarity));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getJaccardSimilarity(String str1, String str2) {
        List<String> bigrams1 = extractBigrams(str1);
        List<String> bigrams2 = extractBigrams(str2);

        Map<String, Integer> freqMap1 = getCountMap(bigrams1);
        Map<String, Integer> freqMap2 = getCountMap(bigrams2);

        // 모든 2-그램 종류를 통합하고 각 키마다 Math.min과 Math.max를 통해 교집합과 합집합을 구한다.
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(freqMap1.keySet());
        allKeys.addAll(freqMap2.keySet());

        int intersection = 0;
        int union = 0;

        for (String key : allKeys) {
            int count1 = freqMap1.getOrDefault(key, 0);
            int count2 = freqMap2.getOrDefault(key, 0);
            // 두 집합에서 최소 등장 횟수와 두 집합에서 최대 등장 횟수를 더한다.
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        if (union == 0) return MOD;
        return (int) ((double) intersection / union * MOD);
    }

    /**
     * 문자열을 2글자씩 끊어서 -> "fr", "ra", ..." 식으로 만든다.
     * Character.isLetter()로 알파벳이 아닌 문자는 제외한다.
     * 리스트에 중복을 허용하도록 추가한다.
     */
    private static List<String> extractBigrams(String str) {
        List<String> bigrams = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) bigrams.add("" + a + b);
        }

        return bigrams;
    }

    /**
     * 각 2-그램의 등장 횟수(빈도)를 저장한다.
     * 중복된 2-그램이 있을 경우를 대비하여 Map<String, Interger>를 사용한다.
     * ["fr", "ra", "an", "nc", "ce"] -> "fr":1, "ra":1, ...
     */
    private static Map<String, Integer> getCountMap(List<String> list) {
        Map<String, Integer> getFrequencyMap = new HashMap<>();
        for (String s : list) getFrequencyMap.put(s, getFrequencyMap.getOrDefault(s, 0) + 1);
        return getFrequencyMap;
    }
}
