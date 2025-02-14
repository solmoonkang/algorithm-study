package 알고리즘분류.해시를사용한집합과맵.틀린문제;

import java.io.*;
import java.util.*;

public class 빈도정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int messageLength = Integer.parseInt(stringTokenizer.nextToken());
        int byNumber = Integer.parseInt(stringTokenizer.nextToken());

        // 숫자를 KEY로, 해당 숫자의 빈도와 처음 등장한 인덱스를 저장하는 배열을 VALUE로 구성한다.
        Map<Integer, int[]> messageSequencesMap = new HashMap<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < messageLength; i++) {
            int messageNumber = Integer.parseInt(stringTokenizer.nextToken());

            if (messageNumber <= byNumber) {
                messageSequencesMap.put(messageNumber, messageSequencesMap.getOrDefault(messageNumber, new int[2]));
                // 배열의 첫 번째 요소에는 해당 숫자의 빈도가 저장된다. 해당 숫자가 메시지에서 몇 번 등장했는지를 나타낸다.
                messageSequencesMap.get(messageNumber)[0]++;
                // 배열의 두 번째 요소에는 해당 숫자가 처음 등장한 인덱스가 저장된다. 해당 숫자가 메시지에서 처음 나타난 위치를 기록한다.
                messageSequencesMap.get(messageNumber)[1] = i;
            }
        }

        List<Map.Entry<Integer, int[]>> entryList = new ArrayList<>(messageSequencesMap.entrySet());

        entryList.sort((entryA, entryB) -> {
            int frequencyCompare = Integer.compare(entryB.getValue()[0], entryA.getValue()[0]);
            if (frequencyCompare != 0) return frequencyCompare;
            return Integer.compare(entryA.getValue()[1], entryB.getValue()[1]);
        });

        for (Map.Entry<Integer, int[]> entry : entryList) {
            int number = entry.getKey();
            int frequency = entry.getValue()[0];

            for (int i = 0; i < frequency; i++) bufferedWriter.write(number + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
