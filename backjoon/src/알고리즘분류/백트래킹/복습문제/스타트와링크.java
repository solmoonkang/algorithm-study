package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 스타트와링크 {

    private static int N;
    private static boolean[] visited;
    private static int[][] S;
    private static int minAbilityDifference = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N];
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 5. 해당 과정을 재귀적으로 반복
        findDivideTeams(0, 0);
        bufferedWriter.write(String.valueOf(minAbilityDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 1. 후보해를 만들기 위한 상태 공간 탐색: 각 사람을 스타트 팀에 포함할지 여부를 결정한다. index는 현재 선택할 사람의 인덱스, count는 스타트 팀에 포함된 사람 수를 나타낸다.
    private static void findDivideTeams(int index, int count) {
        // 2. 후보해를 확인하고 주어진 조건에 부합하는지 판단: 스타트 팀에 N/2명이 선택되었다면 선택된 조합이 유효한 후보해로 간주되며, computeMinimumAbilityDifference를 호출하여 능력치 차이를 계산한다.
        if (count == N / 2) {
            computeMinimumAbilityDifference();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findDivideTeams(i + 1, count + 1);
                // 4. 조건에 부합하는 후보해를 찾지 못하면 이전 상태로 돌아가 다음 후보해를 생성: 현재 사람을 스타트 팀에 포함한 후, 재귀 호출을 통해 다음 사람을 선택한 뒤, 호출이 끝나면 visited[i] = false로 설정하여 이전 상태로 돌아간다. 이를 통해 다른 조합을 탐색할 수 있게 된다.
                visited[i] = false;
            }
        }
    }

    // 3. 조건에 부합하는 후보해를 찾으면 해를 찾은 것으로 판단하여 결과를 출력: 현재 선택된 팀 조합의 능력치를 계산하고, 스타트 팀과 링크 팀의 능력치 차이를 구한다. 이 차이를 통해 최소값인지 확인하여 minAbilityDifference를 업데이트한다.
    private static void computeMinimumAbilityDifference() {
        int startTeamAbility = 0;
        int linkTeamAbility = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) startTeamAbility += S[i][j];
                else if (!visited[i] && !visited[j]) linkTeamAbility += S[i][j];
            }
        }

        int difference = Math.abs(startTeamAbility - linkTeamAbility);
        minAbilityDifference = Math.min(minAbilityDifference, difference);
    }
}
