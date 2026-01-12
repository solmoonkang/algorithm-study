package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 유연근무제 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] schedules = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            schedules[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        int[][] timeLogs = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                timeLogs[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int startDay = Integer.parseInt(bufferedReader.readLine());

        int recipientNumber = getRecipientNumber(schedules, timeLogs, startDay);
        bufferedWriter.write(String.valueOf(recipientNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getRecipientNumber(int[] schedules, int[][] timeLogs, int startDay) {
        int recipientNumber = schedules.length;

        for (int i = 0; i < schedules.length; i++) {
            int deadlineMinute = calculateMinutesFromFormat(schedules[i]) + 10;

            for (int j = 0; j < timeLogs.length; j++) {
                int currentDay = (startDay - 1 + j) % 7;
                if (currentDay == 5 || currentDay == 6) continue;

                int actualMinutes = calculateMinutesFromFormat(timeLogs[i][j]);
                if (actualMinutes > deadlineMinute) {
                    recipientNumber--;
                    break;
                }
            }
        }

        return recipientNumber;
    }

    private static int calculateMinutesFromFormat(int timeFormat) {
        int hour = timeFormat / 100;
        int minute = timeFormat % 100;
        return (hour * 60) + minute;
    }
}
