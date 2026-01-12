package 전체문제;

import java.io.*;

public class 별찍기3 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        // 별을 역순으로 찍기 위해 반복문을 감소식으로 설정하여 순회한다.
        for (int i = N; i >= 1; i--) {
            bufferedWriter.write(STAR.repeat(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
