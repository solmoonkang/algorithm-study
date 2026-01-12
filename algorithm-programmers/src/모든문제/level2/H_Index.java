package 모든문제.level2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_Index {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] citations = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) citations[i] = Integer.parseInt(stringTokenizer.nextToken());

        int HIndex = getHIndex(citations);
        bufferedWriter.write(String.valueOf(HIndex));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 인용 횟수를 높은 것부터 순회하면서, 해당 인용 횟수 이상인 논문이 몇 개인지 계산한다.
     * 그 수(i)가 인용 횟수(citations[i])보다 작아질 때까지만 H-Index 후보로 본다.
     */
    private static int getHIndex(int[] citations) {
        Arrays.sort(citations);

        int N = citations.length;
        int HIndex = 0;

        for (int i = 0; i < N; i++) {
            int H = N - i;
            if (citations[i] >= H) {
                HIndex = H;
                break;
            }
        }

        return HIndex;
    }

    private static int getHIndexWithMath(int[] citations) {
        Arrays.sort(citations);

        int HIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            HIndex = Math.max(HIndex, smaller);
        }

        return HIndex;
    }
}
