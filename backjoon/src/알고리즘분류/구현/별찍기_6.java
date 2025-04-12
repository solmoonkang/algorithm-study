package 알고리즘분류.구현;

import java.io.*;

public class 별찍기_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder starBuilder = new StringBuilder();

        // N번째 줄까지 차례대로 별을 출력하기 위해 N번 반복한다.
        for (int floor = 0; floor < N; floor++) {
            int leftSpaceCount = floor;
            int rightSpaceCount = floor;
            int starCount = 2 * (N - floor) - 1;

            // blank는 floor가 증가할수록 1개씩 증가한다.
            starBuilder.append(" ".repeat(leftSpaceCount));

            // star는 floor가 증가할수록 2개씩 줄어든다.
            starBuilder.append("*".repeat(Math.max(0, starCount)));

            starBuilder.append(" ".repeat(rightSpaceCount));

            starBuilder.append("\n");
        }

        bufferedWriter.write(starBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
