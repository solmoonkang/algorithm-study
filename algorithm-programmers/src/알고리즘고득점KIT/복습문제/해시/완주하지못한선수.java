package 알고리즘고득점KIT.복습문제.해시;

import java.io.*;
import java.util.*;

public class 완주하지못한선수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] participant = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) participant[i] = stringTokenizer.nextToken();

        int M = Integer.parseInt(bufferedReader.readLine());
        String[] completion = new String[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) completion[i] = stringTokenizer.nextToken();

        String participantName = findNotCompletionParticipantNames(participant, completion);
        bufferedWriter.write(participantName);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String findNotCompletionParticipantNames(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        for (String player : participant) {
            participantMap.put(player, participantMap.getOrDefault(player, 0) + 1);
        }

        for (String completePlayer : completion) {
            participantMap.put(completePlayer, participantMap.get(completePlayer) - 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : participantMap.entrySet()) {
            if (entry.getValue() == 0) stringBuilder.append(entry.getKey()).append(" ");
        }

        return stringBuilder.toString();
    }
}
