package 단계문제.그리디알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> coinList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(bufferedReader.readLine());
            if (money <= K) coinList.add(money);
        }

        // 1. 선택 절차: 거스름돈에서 가장 가치가 큰 동전부터 선택을 한다.
        coinList.sort(Comparator.reverseOrder());

        int count = 0;
        // 2. 적절성 검사: 만약, 선택된 동전의 가치가 거스름돈보다 크다면 다음으로 작은 동전을 선택한다.
        for (int i = 0; i < coinList.size(); i++) {
            if (K == 0) break;
            count += K / coinList.get(i);
            K %= coinList.get(i);
        }

        // 3. 해답 검사: 합이 일치하면 거스름돈 문제가 해결된다.
        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
