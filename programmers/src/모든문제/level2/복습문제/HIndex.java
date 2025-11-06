package 모든문제.level2.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class HIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] citations = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) citations[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int hIndex = computeAuthorHIndex(citations);
        bufferedWriter.write(String.valueOf(hIndex));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int computeAuthorHIndex(int[] citations) {
        Integer[] sortedCitations = Arrays.stream(citations)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(sortedCitations, Collections.reverseOrder());

        int N = sortedCitations.length;

        for (int H = 0; H < N; H++) {
            // 현재까지 검토한 논문의 개수 H-Index 후보를 구한다.
            int hCandidate = H + 1;

            // H번 이상 인용된 논문(sortedCitations[H])이 H편(hCandidate) 이상이어야 한다.
            // 해당 조건이 성립하는 순간 (H+1)번째 논문의 인용 횟수가 (H+1)편이 되지 못했으므로 H의 최댓값은 H+1이 아니라 그 직전 값인 H가 된다.
            if (sortedCitations[H] < hCandidate) return H;
        }

        // 루프를 모두 통과했다면, 모든 논문이 N회 이상 인용된 경우로 H-Index는 논문의 총 개수인 N이 된다.
        return N;
    }
}
