package 기출문제.PCCP기출문제.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 아날로그시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int H1 = Integer.parseInt(stringTokenizer.nextToken());
        int M1 = Integer.parseInt(stringTokenizer.nextToken());
        int S1 = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int H2 = Integer.parseInt(stringTokenizer.nextToken());
        int M2 = Integer.parseInt(stringTokenizer.nextToken());
        int S2 = Integer.parseInt(stringTokenizer.nextToken());

        int alarmTimeNumber = getTimesNotificationSounds(H1, M1, S1, H2, M2, S2);
        bufferedWriter.write(String.valueOf(alarmTimeNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getTimesNotificationSounds(int H1, int M1, int S1, int H2, int M2, int S2) {
        int alarmCount = 0;

        // 모든 시간을 동일한 단위로 표현하여 비교와 계산이 간편해지도록 시작 시간과 종료 시간을 초로 변환한다.
        int startTimeInSeconds = H1 * 3600 + M1 * 60 + S1;
        int endTimeInSeconds = H2 * 3600 + M2 * 60 + S2;

        for (int currentTime = startTimeInSeconds; currentTime < endTimeInSeconds; currentTime++) {
            int secondHand = currentTime % 60;
            int minuteHand = (currentTime / 60) % 60;
            int hourHand = (currentTime / 3600) % 12;

            if (hourHand == secondHand) alarmCount++;
            if (minuteHand == secondHand) alarmCount++;
        }

        return alarmCount;
    }
}
