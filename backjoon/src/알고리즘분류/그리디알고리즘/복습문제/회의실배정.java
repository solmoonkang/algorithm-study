package 알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;
import java.util.*;

public class 회의실배정 {

    /**
     * 전체적인 그리디 알고리즘 문제들을 구현할 때, 정렬과 기본적인 구조로 틀을 잡는 방향은 올바르게 접근하고 있다.
     * 반면, 적절성 검사 로직의 미흡함이 보이고 불필요한 자료구조를 사용하여 복잡성을 더하여 개선이 필요하다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] meetingSchedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 2; j++) {
                meetingSchedule[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxMeetingPossible = calculateMaxMeetings(meetingSchedule);
        bufferedWriter.write(String.valueOf(maxMeetingPossible));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMaxMeetings(int[][] meetingSchedule) {
        // 1. 선택 절차: 회의가 끝나는 시간이 가장 짧은 순으로 정렬한다.
        Arrays.sort(meetingSchedule, Comparator.comparingInt(a -> a[1]));

        // 2. 적절성 검사: 현재 회의의 시작 시간이 마지막 회의의 끝나는 시간보다 크거나 같을 때
        int maxMeetingPossible = 0;
        int lastEndMeetingTime = 0;

        for (int i = 1; i < meetingSchedule.length; i++) {
            if (meetingSchedule[i][0] >= lastEndMeetingTime) {
                maxMeetingPossible++;
                lastEndMeetingTime = meetingSchedule[i][1];
            }
        }


        // 3. 해답 검사: 최대 회의 개수를 반환한다.
        return maxMeetingPossible;
    }
}
