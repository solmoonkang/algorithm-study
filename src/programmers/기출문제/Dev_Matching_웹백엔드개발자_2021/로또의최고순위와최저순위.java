package programmers.기출문제.Dev_Matching_웹백엔드개발자_2021;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 로또의최고순위와최저순위 {

    // TODO: 시간 복잡도는 O(N)이며, Map의 경우 키의 존재 여부만 확인하므로 Set 자료구조가 더 적합하긴 하다.
    //  다만, maxRank와 minRank를 계산하는 방식을 더 명확하게 드러낼 필요가 있을 것 같다.

    private static final int LOTTO_NUMBER = 6;
    private static final int[] RANKS = {6, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] lottos = new int[LOTTO_NUMBER];
        int[] win_nums = new int[LOTTO_NUMBER];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < LOTTO_NUMBER; i++) lottos[i] = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < LOTTO_NUMBER; i++) win_nums[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] ranks = getLottoRank(lottos, win_nums);
        bufferedWriter.write(Arrays.toString(ranks));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getLottoRank(int[] lottos, int[] win_nums) {
        Set<Integer> matchLottoNumberSet = new HashSet<>();
        for (int winnerNumber : win_nums) matchLottoNumberSet.add(winnerNumber);

        int matchLottoNumberCount = 0, randomLottoNumberCount = 0;
        for (int currentLottoNumber : lottos) {
            if (matchLottoNumberSet.contains(currentLottoNumber)) matchLottoNumberCount++;
            if (currentLottoNumber == 0) randomLottoNumberCount++;
        }

        return new int[]{RANKS[matchLottoNumberCount + randomLottoNumberCount], RANKS[matchLottoNumberCount]};
    }

    private static int[] getLottoRankRefactoring(int[] lottos, int[] win_nums) {
        Set<Integer> matchLottoNumberSet = new HashSet<>();
        for (int winnerNumber : win_nums) matchLottoNumberSet.add(winnerNumber);

        int matchLottoNumberCount = 0, randomLottoNumberCount = 0;
        for (int currentLottoNumber : lottos) {
            if (matchLottoNumberSet.contains(currentLottoNumber)) matchLottoNumberCount++;
            if (currentLottoNumber == 0) randomLottoNumberCount++;
        }

        // RANKS 배열을 사용하지 않고, 로또의 순위를 계산하는 논리를 직접적으로 나타내므로 코드의 가독성이 향상된다.
        int highestRank = 7 - (matchLottoNumberCount + randomLottoNumberCount);
        int lowestRank = 7 - matchLottoNumberCount;

        if (highestRank > LOTTO_NUMBER) highestRank = LOTTO_NUMBER;
        if (lowestRank > LOTTO_NUMBER) lowestRank = LOTTO_NUMBER;

        return new int[]{highestRank, lowestRank};
    }
}
