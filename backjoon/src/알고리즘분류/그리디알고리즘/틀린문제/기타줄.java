package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 기타줄 {

    private static final int GUITAR_STRINGS = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] guitarBrand = new int[M][2];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            guitarBrand[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            guitarBrand[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minAmount = getMinAmountForGuitarStrings(N, guitarBrand);
        bufferedWriter.write(String.valueOf(minAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinAmountForGuitarStrings(int N, int[][] guitarBrand) {
        // 한 번만 순회하며 최저 패키지/낱개 가격 찾기
        int minPacks = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;
        for (int[] guitars : guitarBrand) {
            minPacks = Math.min(minPacks, guitars[0]);
            minSingle = Math.min(minSingle, guitars[1]);
        }

        // 세 가지 구매 방식의 비용 계산
        int costOnlyPackages = ((N + GUITAR_STRINGS - 1) / GUITAR_STRINGS) * minPacks;
        int costPacksPlusSingles = (N / GUITAR_STRINGS) * minPacks + (N % GUITAR_STRINGS) * minSingle;
        int costOnlySingles = N * minSingle;

        return Math.min(costOnlyPackages,
                Math.min(costPacksPlusSingles, costOnlySingles));
    }
}
