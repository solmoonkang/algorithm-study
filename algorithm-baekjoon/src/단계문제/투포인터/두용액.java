package 단계문제.투포인터;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] solution = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(solution);

        int left = 0, right = N - 1;
        int closestSum = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        while (left < right) {
            int sum = solution[left] + solution[right];

            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                closestPair[0] = solution[left];
                closestPair[1] = solution[right];
            }

            if (sum < 0) left++;
            else right--;
        }


        bufferedWriter.write(closestPair[0] + " " + closestPair[1]);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
