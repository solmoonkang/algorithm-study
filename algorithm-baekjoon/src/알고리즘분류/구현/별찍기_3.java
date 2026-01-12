package 알고리즘분류.구현;

import java.io.*;

public class 별찍기_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder starBuilder = new StringBuilder();

        for (int floor = 0; floor < N; floor++) {
            int starCount = N - floor;
            starBuilder.append("*".repeat(starCount));
            starBuilder.append("\n");
        }

        bufferedWriter.write(starBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
