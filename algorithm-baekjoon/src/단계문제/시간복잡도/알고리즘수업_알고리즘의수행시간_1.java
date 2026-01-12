package 단계문제.시간복잡도;

import java.io.*;

public class 알고리즘수업_알고리즘의수행시간_1 {

    /**
     * MenOfPassion 알고리즘의 수행 시간을 분석하고, 수행 횟수와 최고차항의 차수를 출력하는 문제이다.
     * 해당 알고리즘은 입력 배열의 중간 값을 반환하는 단순한 알고리즘이다.
     * <p>
     * 1. 수행 횟수
     * - 주어진 알고리즘에서 i = ⌊n / 2⌋;와 return A[i];의 수행 횟수를 계산한다.
     * - N의 크기에 관계없이 항상 1번의 계산과 1번의 반환이 이루어지므로, 수행 횟수는 항상 2이다.
     * 2. 다항식의 최고차항 차수
     * - 수행 횟수는 상수 2로, 이를 다항식으로 나타내면 O(1)이다.
     * - 따라서, 최고차항의 차수는 0이다.
     * 3. 차수가 3보다 크면 4를 출력
     * - 차수가 0인 경우는 3보다 작으므로, 이 경우에는 차수를 그대로 출력하면 된다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 크기 N을 입력받는다.
        int N = Integer.parseInt(bufferedReader.readLine());

        // 수행 횟수는 항상 2이다.
        int count = 1;

        // 최고차항의 차수는 0이다.
        int degree = 0;

        bufferedWriter.write(count + "\n" + degree);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
