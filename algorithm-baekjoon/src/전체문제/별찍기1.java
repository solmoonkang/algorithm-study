package 전체문제;

import java.io.*;

public class 별찍기1 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        // 입력으로 주어진 정수 N만큼의 별을 찍기 위한 반복문
        for (int i = 0; i <= N; i++) {
            // stringBuilder.append(STAR).append("\n");     // ❌ 이렇게 할 경우 한 줄에 하나의 별만 찍고 총 5개의 별이 출력된다.

            for (int j = 0; j < i; j++) {
                // i만큼 별을 출력하기 위해서는 0부터 i까지의 개수만큼 별을 stringBuilder에 저장
                stringBuilder.append(STAR);
            }

            // stringBuilder.append(STAR.repeat(i));        // ⭕️ 위처럼 반복문으로 처리해도 되고 아래와 같이 stringBuilder의 repeat를 활용해도 된다.

            // i로 넘어가기 전 개행 처리를 하여 출력 값과 동일한 별을 찍을 수 있도록 한다.
            stringBuilder.append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        bufferedReader.close();
    }
}
