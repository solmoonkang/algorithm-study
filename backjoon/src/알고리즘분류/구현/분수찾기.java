package 알고리즘분류.구현;

import java.io.*;

public class 분수찾기 {

    /**
     * ✅ 규칙 찾기: 대각선 기준으로 그룹화
     * X (순서)   	대각선 그룹	방향	    분수
     * 1            1          ↗       1/1
     * 2            2          ↘       1/2
     * 3            2          ↘       2/1
     * 4            3          ↗       3/1
     * <p>
     * 대각선 N번째는 항의 개수가 N개이므로, N번째 그룹까지의 항 수: 1 + 2 + ... + N = N(N + 1)/2
     * 짝수 그룹이면 ↘ 방향: 분자 = i, 분모 = N - i + 1
     * 홀수 그룹이면 ↗ 방향: 분자 = N - i + 1, 분모 = i
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bufferedReader.readLine());

        // 1️⃣ 몇 번째 그룹인지 찾는다.
        int line = 1, sum = 0;
        while (sum + line < X) {
            sum += line;
            line++;
        }

        // 2️⃣ 그룹 내에서 몇 번째인지 찾는다.
        int indexInLine = X - sum;

        // 3️⃣ 분자와 분모를 결정한다.
        int numerator, denominator;
        if (line % 2 == 0) {    // 짝수이므로 ↘ 방향
            numerator = indexInLine;
            denominator = line - indexInLine + 1;
        } else {                // 홀수이므로 ↗ 방향
            numerator = line - indexInLine + 1;
            denominator = indexInLine;
        }

        bufferedWriter.write(numerator + "/" + denominator);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
