package 알고리즘분류.브루트포스알고리즘;

import java.io.*;

public class 일곱난쟁이 {

    private static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dwarfHeights = new int[N];

        for (int i = 0; i < N; i++) {
            dwarfHeights[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int heightSum = 0;

                for (int k = 0; k < N; k++) {
                    if (k != i && k != j) heightSum += dwarfHeights[k];
                }

                if (heightSum == 100) {
                    for (int k = 0; k < N; k++) {
                        if (k != i && k != j) bufferedWriter.write(dwarfHeights[k] + "\n");
                    }

                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedReader.close();
                    return;
                }
            }
        }
    }
}
