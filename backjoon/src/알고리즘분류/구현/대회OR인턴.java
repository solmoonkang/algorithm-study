package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 대회OR인턴 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int maxTeams = getMaxTeam(N, M, K);
        bufferedWriter.write(String.valueOf(maxTeams));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 1. 한 팀에 필요한 인원은 여학생 2명과 남학생 1명으로 총 3명이 필요하다.
     * 2. 각 자원을 따로따로 보고 최대 몇 팀을 만들 수 있나 계산한다.
     *      - 여학생만으로 볼 때: 한 팀에 여학생이 2명 필요하므로 최대 만들어질 팀 수는 N / 2팀이다.
     *      - 남학생만으로 볼 때: 한 팀에 남학생이 1명 필요하므로 최대 만들어진 팀 수는 M팀이다.
     *      - 전체 인원(인턴 제외)으로 볼 때: 총 N+M명 중 K명은 인턴에 가니까, 대회에는 (N + M - K)명만 참가가 가능하다.
     *        해당 인원들로 한 팀에 3명씩 꾸리면 (N + M - K) / 3팀이다.
     * 3. 실제 만들 수 있는 팀 수는 이 세 조건 중 가장 작은 값을 구하면 된다.
     */
    private static int getMaxTeam(int N, int M, int K) {
        int teamByGirls = N / 2;
        int teamByBoys = M;
        int teamByPeople = (N + M - K) / 3;

        return Math.min(teamByGirls,
                Math.min(teamByBoys, teamByPeople));
    }
}
