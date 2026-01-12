package 기출문제.PCCP기출문제.복습문제;

import java.io.*;
import java.time.Duration;

public class 동영상재생기 {

    private static final String DURATION_PREFIX = "PT";
    private static final String MINUTE_SUFFIX = "M";
    private static final String SECOND_SUFFIX = "S";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String videoLength = bufferedReader.readLine();
        String position = bufferedReader.readLine();
        String openingStart = bufferedReader.readLine();
        String openingEnd = bufferedReader.readLine();

        String command = bufferedReader.readLine();
        String[] commands = command.split(", ");

        String videoLocation = getCurrentVideoLocation(videoLength, position, openingStart, openingEnd, commands);
        bufferedWriter.write(videoLocation);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getCurrentVideoLocation(String videoLength, String position, String openingStart, String openingEnd, String[] commands) {
        String positionFormat = DURATION_PREFIX + position.replace(":", MINUTE_SUFFIX) + SECOND_SUFFIX;
        Duration currentVideoTime = Duration.parse(positionFormat);

        String openingStartFormat = DURATION_PREFIX + openingStart.replace(":", MINUTE_SUFFIX) + SECOND_SUFFIX;
        Duration openingStartVideoTime = Duration.parse(openingStartFormat);

        String openingEndFormat = DURATION_PREFIX + openingEnd.replace(":", MINUTE_SUFFIX) + SECOND_SUFFIX;
        Duration openingEndVideoTime = Duration.parse(openingEndFormat);

        Duration startVideoTime = Duration.ZERO;
        String videoLengthFormat = DURATION_PREFIX + videoLength.replace(":", MINUTE_SUFFIX) + SECOND_SUFFIX;
        Duration endVideoTime = Duration.parse(videoLengthFormat);

        for (String command : commands) {
            switch (command) {
                case "prev":
                    Duration previousTime = currentVideoTime.minusSeconds(10);

                    if (previousTime.isNegative()) currentVideoTime = startVideoTime;
                    else if (previousTime.compareTo(openingStartVideoTime) >= 0 && previousTime.compareTo(openingEndVideoTime) <= 0)
                        currentVideoTime = openingEndVideoTime;
                    else currentVideoTime = previousTime;
                    break;
                case "next":
                    Duration nextTime = currentVideoTime.plusSeconds(10);

                    if (nextTime.compareTo(endVideoTime) > 0) currentVideoTime = endVideoTime;
                    else if (nextTime.compareTo(openingStartVideoTime) >= 0 && nextTime.compareTo(openingEndVideoTime) <= 0)
                        currentVideoTime = openingEndVideoTime;
                    else currentVideoTime = nextTime;
                    break;
            }
        }

        long minutes = currentVideoTime.toMinutes();
        long seconds = currentVideoTime.getSeconds() % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
