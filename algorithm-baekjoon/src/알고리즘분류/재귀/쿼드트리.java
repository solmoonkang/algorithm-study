package 알고리즘분류.재귀;

import java.io.*;

public class 쿼드트리 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        char[][] videos = new char[N][N];

        for (int i = 0; i < N; i++) {
            String video = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                videos[i][j] = video.charAt(j);
            }
        }

        videoCompression(videos, 0, 0, N);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void videoCompression(char[][] videos, int x, int y, int size) {
        // isUniform을 호출하여 현재 영역이 동일한 색인지 판단하고 동일하면 해당 색을 StringBuilder에 추가하고 메서드를 종료한다.
        if (isUniform(videos, x, y, size)) {
            stringBuilder.append(videos[x][y]);
            return;
        }

        // 동일하지 않다면 현재 영역을 4개의 하위 영역으로 나누어 각각을 재귀적으로 호출한다. 이때, 각 호출은 newSize로 크기를 줄여 하위 영역을 처리한다.
        int newSize = size / 2;

        stringBuilder.append("(");
        videoCompression(videos, x, y, newSize);
        videoCompression(videos, x, y + newSize, newSize);
        videoCompression(videos, x + newSize, y, newSize);
        videoCompression(videos, x + newSize, y + newSize, newSize);
        stringBuilder.append(")");
    }

    private static boolean isUniform(char[][] videos, int x, int y, int size) {
        char first = videos[x][y];

        // 반복문을 통해 현재 영역의 모든 색을 검사하고, 하나라도 다르면 FALSE를 반환한다.
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (videos[i][j] != first) return false;
            }
        }

        // 모든 색이 같다면 TRUE를 반환한다.
        return true;
    }
}
