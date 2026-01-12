package 전체문제;

import java.io.*;

public class 별찍기5 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        // 별은 꼭 중간에 채워져야 하며 양 옆으로는 공백이 존재해야 한다.
        // 출력되는 별의 개수는 2 * N-1 형식으로 증가하게 된다.

        // 별이 모두 출력되었을 때의 개수는 2 * N - 1로 총 9개 출력되어야 한다. 별은 9에서 2개씩 줄어들어 9 7 5 3 1 상태로 출력된다.
        // 별은 i+2 만큼씩 계속 증가하면 되고, ❌ 이렇게 되면 규칙적인 연산이 불가능해진다.
        for (int i = 1; i <= 2 * N - 1; i += 2) {
            // 여기서 j는 별의 개수를 의미, 그 뜻은 공백은 (2N - 1) - 별의 개수를 의미하므로 (2N - 1) - j를 해주면 공백의 개수를 알 수 있다.
            bufferedWriter.write(" ".repeat(((2 * N - 1) - i) / 2));
            bufferedWriter.write(STAR.repeat(i));
            bufferedWriter.newLine();
        }

        for (int i = 1; i <= N; i++) {
            bufferedWriter.write(" ".repeat(N - i));        // 공백: N - i
            bufferedWriter.write("*".repeat(2 * i - 1));    // 별: 2 * i - 1
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
