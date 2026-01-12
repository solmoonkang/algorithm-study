package 전체문제;

import java.io.*;

public class 별찍기2 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        // ❌ 이유는 모르겠으나 제출 시 컴파일 에러가 발생하여, 단순히 bufferedWriter.write로 출력하고, newLine으로 개행처리하는 게 가장 좋을 듯 싶다.
        StringBuilder stringBuilder = new StringBuilder();

        // 기본적인 별 찍기처럼 별을 출력하면 되지만, 왼쪽 정렬된 별 찍기와는 다르게 우측 정렬된 방법으로 별을 출력해야 한다.
        // 그러기 위해서는 별 앞에 공백이 존재해야 하며, 결론적으로는 N-i만큼의 공백을 저장하고, i개만큼의 별을 stringBuilder에 저장해야 한다.
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(" ".repeat(N-i));
            stringBuilder.append(STAR.repeat(i));
            stringBuilder.append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
