package 알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 붙임성좋은총총이 {

    private static final String CHONG_CHONG_NAME = "ChongChong";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> meetingPersonLogSet = new HashSet<>();
        meetingPersonLogSet.add(CHONG_CHONG_NAME);

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String currentName = stringTokenizer.nextToken();
            String meetingName = stringTokenizer.nextToken();

            if (meetingName.equals(CHONG_CHONG_NAME)) meetingPersonLogSet.add(currentName);

            if (meetingPersonLogSet.contains(currentName) || meetingPersonLogSet.contains(meetingName)) {
                meetingPersonLogSet.add(currentName);
                meetingPersonLogSet.add(meetingName);
            }
        }

        bufferedWriter.write(String.valueOf(meetingPersonLogSet.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
