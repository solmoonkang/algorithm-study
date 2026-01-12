package 알고리즘고득점KIT.전체문제.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 카펫 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int brown = Integer.parseInt(stringTokenizer.nextToken());
        int yellow = Integer.parseInt(stringTokenizer.nextToken());

        int[] carpetSize = getLengthAndWidthCarpet(brown, yellow);
        for (int size : carpetSize) bufferedWriter.write(size + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getLengthAndWidthCarpet(int brown, int yellow) {
        int[] carpetSize = new int[2];
        int grids = brown + yellow;

        for (int height = 2; height <= grids / 2; height++) {
            if (grids % height == 0) {
                int width = grids / height;

                // 갈색 카펫은 가장자리, 노란색 카펫은 갈색 카펫 내부에 존재한다.
                // 따라서 노란색 카펫의 가로와 세로 길이는 왼쪽과 오른쪽, 위쪽과 아래쪽의 갈색 부분을 제거하기 위해 각각 2를 빼야 한다.
                if ((width - 2) * (height - 2) == yellow) {
                    carpetSize[0] = width;
                    carpetSize[1] = height;
                    break;
                }
            }
        }

        return carpetSize;
    }
}
