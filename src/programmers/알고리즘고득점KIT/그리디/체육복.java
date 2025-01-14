package programmers.알고리즘고득점KIT.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 체육복 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] lost = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) lost[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] reserve = new int[K];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < K; i++) reserve[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxStudentsForPE = findMaximumStudentsForPE(N, lost, reserve);
        bufferedWriter.write(String.valueOf(maxStudentsForPE));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMaximumStudentsForPE(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 잃어버린 경우를 제외
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    // 대여할 수 없으므로 -1로 표시
                    lost[j] = -1;
                    // 여벌 체육복을 가진 학생도 빌려줄 수 없으므로 -1로 표시
                    reserve[i] = -1;
                    break;
                }
            }
        }

        // 잃어버린 학생 수
        int maxStudentForPE = (int) (n - Arrays.stream(lost).filter(lostStudent -> lostStudent != -1).count());

        for (int currentLostStudent : lost) {
            // 이미 처리된 학생은 건너뜀
            if (currentLostStudent == -1) continue;

            int leftLostStudent = currentLostStudent - 1;
            int rightLostStudent = currentLostStudent + 1;

            for (int i = 0; i < reserve.length; i++) {
                // 이미 처리된 여벌 체육복을 갖는 학생은 건너뜀
                if (reserve[i] == -1) continue;

                if (leftLostStudent == reserve[i] || rightLostStudent == reserve[i]) {
                    maxStudentForPE++;
                    // 빌려준 학생은 더 이상 사용할 수 없으므로 -1로 설정
                    reserve[i] = -1;
                    break;
                }
            }
        }

        return maxStudentForPE;
    }
}
