package 알고리즘분류.구현.복습문제;

import java.io.*;

public class 방번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();

        int[] counts = new int[10];

        // 각 숫자별 빈도 수를 카운트한다.
        for (char number : N.toCharArray()) {
            counts[number - '0']++;
        }

        // 6과 9를 합쳐서 필요한 세트 수를 계산한다.
        int max = (counts[6] + counts[9] + 1) / 2;
        for (int i = 0; i <= 9; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, counts[i]);
        }

        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
