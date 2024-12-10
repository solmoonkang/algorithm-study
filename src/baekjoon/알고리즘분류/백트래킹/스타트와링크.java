package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 스타트와링크 {

    private static int N;
    private static int[][] S;
    private static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 팀을 나누기 위한 비트마스크를 사용
        boolean[] selected = new boolean[N];
        findDivideTeams(selected, 0, 0);

        bufferedWriter.write(String.valueOf(minDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 스타트 팀의 인원이 N/2명이 될 때까지 팀원을 선택하기 위해 재귀적으로 팀을 나누는 메서드이다.
    private static void findDivideTeams(boolean[] selected, int index, int count) {
        // 스타트 팀이 N/2명이 되었을 경우
        if (count == N / 2) {
            calculateMinAbilityDifference(selected);
            return;
        }

        for (int i = index; i < N; i++) {
            selected[i] = true;     // 스타트 팀에 포함
            findDivideTeams(selected, i + 1, count + 1);
            selected[i] = false;    // 스타트 팀에 제외
        }
    }

    // 선택된 팀원에 따라 스타트 팀과 링크 팀의 능력치를 계산하는 메서드이다.
    private static void calculateMinAbilityDifference(boolean[] selected) {
        int startTeamAbility = 0;
        int linkTeamAbility = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) startTeamAbility += S[i][j];        // 스타트 팀 능력치 합산
                else if (!selected[i] && !selected[j]) linkTeamAbility += S[i][j];  // 링크 팀 능력치 합산
            }
        }

        int difference = Math.abs(startTeamAbility - linkTeamAbility);
        minDifference = Math.min(minDifference, difference);                        // 최소 차이 업데이트
    }
}
