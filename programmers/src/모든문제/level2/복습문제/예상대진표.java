package 모든문제.level2.복습문제;

import java.io.*;
import java.util.*;

public class 예상대진표 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int participantA = Integer.parseInt(stringTokenizer.nextToken());
        int participantB = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int matchRound = findRoundNumberToMeet(N, participantA, participantB);
        bufferedWriter.write(String.valueOf(matchRound));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findRoundNumberToMeet(int N, int participantA, int participantB) {
        // 라운드1: (1 2 3 4 5 6 7 8): 1 <-> 2, 3 <-> 4, 5 <-> 6, 7 <-> 8
        // 라운드2: (1 4 6 7): 1 <-> 4, 6 <-> 7
        // 라운드3: (4 7): 4 <-> 7
        int matchRound = 0;

        // 매 라운드가 거듭될 수록 남아있는 참가자의 수는 N/2 씩 줄어들게 된다. 라운드1: 8명, 라운드2: 4명, 라운드3: 2명
        // 참가자A와 참가자B가 만나게 될 부분을 구해야 한다. index=1: (1, 2), index=2: (3, 4), index=3: (5, 6), index=4: (7, 8)

        // 참가자는 (2k-1, 2k) 쌍으로 경기를 진행한다. 승리한 참가자는 새로운 번호 k를 부여받는다.
        // K = (K+1) / 2를 통해 다음 라운드에서 부여받을 번호를 계산한다.
        while (participantA != participantB) {
            participantA = (participantA + 1) / 2;
            participantB = (participantB + 1) / 2;
            matchRound++;
        }


        return matchRound;
    }
}
