package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine()), M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        int count = 0, index = 0;

        while (index < M - 1) {
            if (S.charAt(index) == 'I') {
                int nextIndex = 1;

                while (nextIndex <= N && index + 2 * nextIndex < M &&
                        S.charAt(index + 2 * nextIndex - 1) == 'O' &&
                        S.charAt(index + 2 * nextIndex) == 'I') {
                    nextIndex++;
                }

                if (nextIndex > N) {
                    count++;
                    index += 2 * (nextIndex - 1);
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
