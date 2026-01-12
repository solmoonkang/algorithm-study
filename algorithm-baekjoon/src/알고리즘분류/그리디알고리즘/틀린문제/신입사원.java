package 알고리즘분류.그리디알고리즘.틀린문제;

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
            int applicantsNumber = Integer.parseInt(bufferedReader.readLine());
            int[][] selectionTest = new int[applicantsNumber][2];

            for (int j = 0; j < applicantsNumber; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                selectionTest[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                selectionTest[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int maxEmployeesNumber = getMaxNewEmployeesNumber(selectionTest);
            bufferedWriter.write(maxEmployeesNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxNewEmployeesNumber(int[][] selectionTest) {
        // 지원자 서류 심사 성적을 기준으로 오름차순 정렬을 한다.
        Arrays.sort(selectionTest, Comparator.comparingInt(a -> a[0]));

        // 첫 번째 지원자는 무조건 선발되므로 1로 초기화한다.
        int newEmployeesNumber = 1;
        // 첫 번째 지원자의 면접 성적을 현재 면접 성적 기준으로 잡는다.
        int minInterviewRank = selectionTest[0][1];

        for (int i = 1; i < selectionTest.length; i++) {
            // 현재 면접 성적이 최저 면접 성적보다 낮을 경우에 선발한다.
            if (minInterviewRank > selectionTest[i][1]) {
                // 선발될 경우 선발 지원자 수를 증가시킨다.
                newEmployeesNumber++;
                // 현재 면접 성적을 기준으로 선발을 진행하면서 최저 면접 성적 기준을 업데이트한다.
                minInterviewRank = selectionTest[i][1];
            }
        }

        return newEmployeesNumber;
    }
}
