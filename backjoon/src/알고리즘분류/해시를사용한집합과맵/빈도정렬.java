package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 빈도정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> frequencySortedSequenceList = new ArrayList<>();
        Map<Integer, Integer> sequenceFrequencyMap = new HashMap<>();
        Map<Integer, Integer> sequenceIndexMap = new HashMap<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            frequencySortedSequenceList.add(number);
            sequenceFrequencyMap.put(number, sequenceFrequencyMap.getOrDefault(number, 0) + 1);
            sequenceIndexMap.putIfAbsent(number, i);        // 첫 번째 등장 인덱스 저장
        }

        frequencySortedSequenceList.sort((a, b) -> {
            int frequencyA = sequenceFrequencyMap.get(a);
            int frequencyB = sequenceFrequencyMap.get(b);

            if (frequencyA != frequencyB) return Integer.compare(frequencyB, frequencyA);       // 빈도가 높은 순서로 정렬
            else return Integer.compare(sequenceIndexMap.get(a), sequenceIndexMap.get(b));      // 원래 순서를 유지
        });

        for (int number : frequencySortedSequenceList) bufferedWriter.write(number + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
