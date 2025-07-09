package 모든문제.level2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String message = bufferedReader.readLine();

        int[] dictionaryIndexes = getIndexAfterLempelZivWelch(message);
        for (int index : dictionaryIndexes) bufferedWriter.write(index + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getIndexAfterLempelZivWelch(String message) {
        // 압축 결과(색인 번호)를 저장할 리스트
        List<Integer> sequenceNumbers = new ArrayList<>();
        // 사전을 Map 형태로 선언: 문자열 -> 색인 번호
        Map<String, Integer> alphabetDictionary = new HashMap<>();

        // 초기 사전 세팅: A ~ Z를 1부터 26까지 색인으로 등록
        int dictionaryIndex = 1;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            alphabetDictionary.put(String.valueOf(alphabet), dictionaryIndex++);
        }

        // 현재 메시지 처리 위치
        int currentMessageIndex = 0;

        // 메시지 끝까지 처리할 때까지 반복
        while (currentMessageIndex < message.length()) {
            // 현재 문자로 시작하는 문자열 current
            String current = String.valueOf(message.charAt(currentMessageIndex));
            int nextMessageIndex = currentMessageIndex + 1;

            // current에 문자를 하나씩 더해가며 사전에 존재하는 가장 긴 문자열 찾기
            while (nextMessageIndex <= message.length() && alphabetDictionary.containsKey(message.substring(currentMessageIndex, nextMessageIndex))) {
                // 사전에 존재하면 current를 업데이트
                current = message.substring(currentMessageIndex, nextMessageIndex);
                // 다음 문자까지 포함해서 시도
                nextMessageIndex++;
            }

            // 찾은 문자열 current의 색인 번호를 출력 목록에 추가
            sequenceNumbers.add(alphabetDictionary.get(current));

            // 아직 입력이 남아 있다면, current + 다음 글자를 사전에 등록
            if (nextMessageIndex <= message.length()) {
                // current + next
                String next = message.substring(currentMessageIndex, nextMessageIndex);
                // 새로운 문자열 등록
                alphabetDictionary.put(next, dictionaryIndex++);
            }

            // 처리한 길이만큼 인덱스 이동
            currentMessageIndex += current.length();
        }

        return sequenceNumbers.stream().mapToInt(i -> i).toArray();
    }
}
