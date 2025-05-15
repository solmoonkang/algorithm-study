package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 예상대진표 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int round = getParticipantsMeetRound(N, A, B);
        bufferedWriter.write(String.valueOf(round));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 주어진 매개변수를 모두 활용하려 하다보니 생각하는 방향이 고정되어 있었다.
     * - 홀수라면 우측의 값을, 짝수라면 좌측의 값이 참가자와 경쟁자가 같은지 확인하려고 했다.
     * - 토너먼트 번호는 매 라운드마다 절반으로 줄고, A와 B가 언제 같은 그룹이 되는지를 확인하면 된다.
     * - 따라서 참가자/경쟁자 + 1 / 2를 하면 매 다음 라운드의 번호를 갱신할 수 있고, A와 B가 같지 않다면 라운드 수를 증가시킨다.
     */
    private static int getParticipantsMeetRound(int N, int A, int B) {
        int round = 0;

        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            round++;
        }

        return round;
    }
}
