package baekjoon.알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 스타트와링크 {

    private static int N;
    private static boolean[] selected;
    private static int[][] teamAbilityTable;
    private static int minDifference;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        teamAbilityTable = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                teamAbilityTable[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        selectTeam(0, 0);

        bufferedWriter.write(String.valueOf(minDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void selectTeam(int index, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectTeam(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    private static void calculateDifference() {
        int starterTeamAbility = 0;
        int linkTeamAbility = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) starterTeamAbility += teamAbilityTable[i][j] + teamAbilityTable[j][i];
                else if (!selected[i] && !selected[j])
                    linkTeamAbility += teamAbilityTable[i][j] + teamAbilityTable[j][i];
            }

            int difference = Math.abs(starterTeamAbility - linkTeamAbility);
            minDifference = Math.min(minDifference, difference);
        }
    }
}
