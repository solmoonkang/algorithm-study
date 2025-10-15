package 알고리즘고득점KIT.복습문제.탐욕법;

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
        for (int i = 0; i < M; i++) {
            lost[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] reserve = new int[K];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            reserve[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int studentCount = getListeningMaxStudentsForPE(N, lost, reserve);
        bufferedWriter.write(String.valueOf(studentCount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getListeningMaxStudentsForPE(int N, int[] lost, int[] reserve) {
        // 1. 학생 상태 배열 초기화 (1-based) / 값의 의미: 1(기본), 0(도난), 2(여벌)
        int[] studentStatus = new int[N + 1];
        Arrays.fill(studentStatus, 1);

        // 2. Lost 및 Reserve 상태 반영, 상태 통합으로 여벌이면서 도난당한 학생은 status가 1로 남으며, 자동으로 제외
        for (int lostStudent : lost) studentStatus[lostStudent]--;
        for (int reserveStudent : reserve) studentStatus[reserveStudent]++;

        // 3. 탐욕법 처리: 앞 번호를 우선하여 대여
        for (int i = 1; i <= N; i++) {
            // i번 학생이 빌려줄 수 있는 상태(여벌 체육복 2벌)인지 확인
            if (studentStatus[i] == 2) {
                // 앞 번호 학생에게 먼저 빌려주며, 경계를 넘지 않고(i > 1) i-1이 도난 상태(0)일 때
                if (i > 1 && studentStatus[i - 1] == 0) {
                    studentStatus[i]--;
                    studentStatus[i - 1]++;
                    // 앞 번호에 빌려줬으면 뒷 번호는 볼 필요 없으므로 다음 학생으로 넘어감
                    continue;
                }

                // 앞 번호가 필요 없을 경우, 뒷 번호 학생에게 대여, 경계를 넘지 않고(i < N) i+1이 도난 상태(0)일 때
                if (i < N && studentStatus[i + 1] == 0) {
                    studentStatus[i]--;
                    studentStatus[i + 1]++;
                }
            }
        }

        // 4. 체육복이 1벌 이상인 학생 수 카운트
        int attendedStudents = 0;
        for (int i = 1; i <= N; i++) {
            if (studentStatus[i] >= 1) attendedStudents++;
        }

        return attendedStudents;
    }
}
