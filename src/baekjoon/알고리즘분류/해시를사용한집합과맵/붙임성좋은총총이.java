package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 붙임성좋은총총이 {

    private static final String CHONG_CHONG_NAME = "ChongChong";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Boolean> dancingStatusMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String currentUserName = stringTokenizer.nextToken();
            String meetingUserName = stringTokenizer.nextToken();

            if (meetingUserName.equals(CHONG_CHONG_NAME)) dancingStatusMap.put(currentUserName, true);
            if (dancingStatusMap.get(currentUserName) != null && dancingStatusMap.get(currentUserName))
                dancingStatusMap.put(meetingUserName, true);
        }

        bufferedWriter.write(String.valueOf(dancingStatusMap.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int optimizedCountDancingPeople(int N, List<String[]> meetingRecords) {
        Map<String, Boolean> dancingStatusMap = new HashMap<>();
        dancingStatusMap.put(CHONG_CHONG_NAME, true);

        for (String[] record : meetingRecords) {
            String currentUserName = record[0];
            String meetingUserName = record[1];

            if (dancingStatusMap.getOrDefault(currentUserName, false) ||
                    dancingStatusMap.getOrDefault(meetingUserName, false)) {
                dancingStatusMap.put(currentUserName, true);
                dancingStatusMap.put(meetingUserName, true);
            }
        }

        return dancingStatusMap.size();
    }
}
