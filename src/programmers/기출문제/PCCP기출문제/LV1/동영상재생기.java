package programmers.기출문제.PCCP기출문제.LV1;

public class 동영상재생기 {

    // TODO: 문제 풀이 흐름은 정답과 유사했으나 효율성과 가독성이 떨어졌다. 그리고 시간 출력 포맷을 제대로 지키지 못했다.
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = convertToSeconds(video_len);
        int currentPosition = convertToSeconds(pos);
        int openingStart = convertToSeconds(op_start);
        int openingEnd = convertToSeconds(op_end);

        for (String command : commands) {
            if (currentPosition >= openingStart && currentPosition <= openingEnd) currentPosition = openingEnd;

            if (command.equals("next")) {
                currentPosition += 10;
                if (currentPosition > videoLength) currentPosition = videoLength;
            } else if (command.equals("prev")) {
                currentPosition -= 10;
                if (currentPosition < 0) currentPosition = 0;
            }
        }

        return convertToTimeFormat(currentPosition);
    }

    public int convertToSeconds(String time) {
        String[] splitTime = time.split(":");
        int minutes = Integer.parseInt(splitTime[0]);
        int seconds = Integer.parseInt(splitTime[1]);
        return minutes * 60 + seconds;
    }

    private String convertToTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static void main(String[] args) {
        동영상재생기 problem = new 동영상재생기();

        String[] commands1 = {"next", "prev"};
        System.out.println("problem = " + problem.solution("34:33", "13:00", "00:55", "02:55", commands1));

        String[] commands2 = {"prev", "next", "next"};
        System.out.println("problem = " + problem.solution("10:55", "00:05", "00:15", "06:55", commands2));

        String[] commands3 = {"next"};
        System.out.println("problem = " + problem.solution("07:22", "04:05", "00:15", "04:07", commands3));
    }
}
