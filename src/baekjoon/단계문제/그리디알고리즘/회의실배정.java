package baekjoon.단계문제.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] meetingSchedules = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            meetingSchedules[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            meetingSchedules[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 1. 선택 절차: 회의가 끝나는 시점을 기준으로 정렬하여, 종료 시간이 빠른 회의를 우선 선택한다.
        Arrays.sort(meetingSchedules, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int endMeetingTime = 0;
        // 2. 적절성 검사: 선택된 회의의 종료 시간보다 시작 시간이 늦은 회의를 선택한다.
        for (int[] meetingSchedule : meetingSchedules) {
            if (endMeetingTime <= meetingSchedule[0]) {
                endMeetingTime = meetingSchedule[1];
                count++;
            }
        }

        // 3. 해답 검사: 선택한 회의들이 겹치지 않으면 회의의 최대 개수를 구할 수 있다.
        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
