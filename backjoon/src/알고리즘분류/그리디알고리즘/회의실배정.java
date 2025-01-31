package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] meetingRoomSchedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            meetingRoomSchedule[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            meetingRoomSchedule[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(meetingRoomSchedule, Comparator.comparingInt(a -> a[1]));

        // 최대 회의 개수
        int maxMeetingRoomNumber = 0;
        // 마지막 회의 종료 시간
        int lastEndMeetingTime = 0;

        for (int i = 0; i < N; i++) {
            int currentStartTime = meetingRoomSchedule[i][0];
            int currentEndTime = meetingRoomSchedule[i][1];

            // 현재 회의의 시작 시간이 마지막 회의 종료 시간보다 크거나 같으면 회의 추가
            if (currentStartTime >= lastEndMeetingTime) {
                maxMeetingRoomNumber++;
                // 마지막 회의 종료 시간 업데이트
                lastEndMeetingTime = currentEndTime;
            }
        }

        bufferedWriter.write(String.valueOf(maxMeetingRoomNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
