package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 신입사원 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            int[][] newEmployeeRecruitment = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                newEmployeeRecruitment[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                newEmployeeRecruitment[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int maxNewEmployeeNumber = getMaxRecruitmentCount(newEmployeeRecruitment);
            bufferedWriter.write(maxNewEmployeeNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxRecruitmentCount(int[][] newEmployeeRecruitment) {
        Arrays.sort(newEmployeeRecruitment, Comparator.comparingInt(a -> a[0]));

        int newEmployeeNumber = 1;
        int currentInterviewRankEmployee = newEmployeeRecruitment[0][1];

        for (int i = 1; i < newEmployeeRecruitment.length; i++) {
            if (newEmployeeRecruitment[i][1] < currentInterviewRankEmployee) {
                newEmployeeNumber++;
                currentInterviewRankEmployee = newEmployeeRecruitment[i][1];
            }
        }

        return newEmployeeNumber;
    }
}
