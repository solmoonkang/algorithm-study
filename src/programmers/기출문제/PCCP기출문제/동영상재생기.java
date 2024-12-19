package programmers.기출문제.PCCP기출문제;

import java.time.Duration;

public class 동영상재생기 {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Duration videoLength = Duration.parse("PT" + video_len.replace(":", "M") + "S");
        Duration currentPosition = Duration.parse("PT" + pos.replace(":", "M") + "S");
        Duration openingStartTime = Duration.parse("PT" + op_start.replace(":", "M") + "S");
        Duration openingEndTime = Duration.parse("PT" + op_end.replace(":", "M") + "S");

        Duration videoStartTime = Duration.ZERO;

        for (String command : commands) {
            switch (command) {
                case "prev":
                    if (currentPosition.minusSeconds(10).isNegative()) currentPosition = videoStartTime;
                    else currentPosition = currentPosition.minusSeconds(10);
                    break;
                case "next":
                    if (currentPosition.plusSeconds(10).compareTo(videoLength) >= 0) currentPosition = videoLength;
                    else currentPosition = currentPosition.plusSeconds(10);
                    break;
            }

            if (currentPosition.compareTo(openingStartTime) > 0 && currentPosition.compareTo(openingEndTime) < 0)
                currentPosition = openingEndTime;
        }

        long minutes = currentPosition.toMinutes();
        long seconds = currentPosition.toSeconds() % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static void main(String[] args) {
        동영상재생기 videoPlayer = new 동영상재생기();

        String video_len1 = "34:33", pos1 = "13:00";
        String op_start1 = "00:55", op_end1 = "02:55";
        String[] commands1 = {"next", "prev"};
        System.out.println("videoPlayer = " + videoPlayer.solution(video_len1, pos1, op_start1, op_end1, commands1));

        String video_len2 = "10:55", pos2 = "00:05";
        String op_start2 = "00:15", op_end2 = "06:55";
        String[] commands2 = {"prev", "next", "next"};
        System.out.println("videoPlayer = " + videoPlayer.solution(video_len2, pos2, op_start2, op_end2, commands2));

        String video_len3 = "07:22", pos3 = "04:05";
        String op_start3 = "00:15", op_end3 = "04:07";
        String[] commands3 = {"next"};
        System.out.println("videoPlayer = " + videoPlayer.solution(video_len3, pos3, op_start3, op_end3, commands3));
    }
}
