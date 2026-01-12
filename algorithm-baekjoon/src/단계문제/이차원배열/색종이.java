package 단계문제.이차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int coloredPaperNumber = Integer.parseInt(bufferedReader.readLine());

        // 100 X 100 크기의 도화지를 설정
        boolean[][] canvas = new boolean[100][100];

        for (int i = 0; i < coloredPaperNumber; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            // 색종이를 붙이는 영역을 true로 설정
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    canvas[j][k] = true;
                }
            }
        }

        int area = 0;

        // 검은 영역의 넓이 계산
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (canvas[i][j]) area++;
            }
        }

        bufferedWriter.write(String.valueOf(area));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
