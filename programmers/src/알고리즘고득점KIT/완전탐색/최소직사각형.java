package 알고리즘고득점KIT.완전탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소직사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] sizes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            sizes[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            sizes[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int walletSize = getSmallestWalletRefactor(sizes);
        bufferedWriter.write(String.valueOf(walletSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 반복문O(N)과 정렬O(N logN)로 인해 시간 복잡도로 O(N logN)을 갖게 된다. -> 10000 * 13.3 = 133000 정도로 10^8를 넘지 않으므로 통과 가능하다.
    private static int getSmallestWallet(int[][] sizes) {
        int[] longestWidthLengths = new int[sizes.length];
        int[] shortestHeightLengths = new int[sizes.length];

        int maxWidth, minHeight;

        // 배열을 만들고 정렬하는 과정이 있는데, maxWidth와 maxHeight의 최대값만 구하면 되므로 배열을 정렬할 필요가 없다.
        for (int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(sizes[i][0], sizes[i][1]);
            minHeight = Math.min(sizes[i][0], sizes[i][1]);

            longestWidthLengths[i] = maxWidth;
            shortestHeightLengths[i] = minHeight;
        }

        // 정렬을 할 경우 시간 복잡도로 O(N logN)를 갖는다.
        Arrays.sort(longestWidthLengths);
        Arrays.sort(shortestHeightLengths);

        return longestWidthLengths[sizes.length - 1] * shortestHeightLengths[sizes.length - 1];
    }

    // 반복문을 한 번만 사용하여 O(N)의 시간 복잡도를 갖도록 개선했다.
    private static int getSmallestWalletRefactor(int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxWidth * maxHeight;
    }
}
