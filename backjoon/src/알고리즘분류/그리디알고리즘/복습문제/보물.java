package 알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 보물 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minValue = calculateMinSValue(A, B);
        bufferedWriter.write(String.valueOf(minValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMinSValue(int[] A, int[] B) {
        // 1. 선택 절차: A[i] * B[i]의 값을 최솟값으로 만들기 위해 A는 오름차순, B는 내림차순 정렬을 한다.
        Arrays.sort(A);

        // 처음부터 Integer[] 배열로 선언하면, 박싱 혹은 언박싱 과정이 필요 없어 효율적이지만, Integer 배열을 사용하면 더 많은 메모리를 사용한다.
        B = Arrays.stream(B).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        // 2. 적절성 검사: A와 B의 값들을 곱한 값을 모두 더한다.
        int minValue = 0;
        for (int i = 0; i < A.length; i++) {
            minValue += A[i] * B[i];
        }

        // 3. 해답 검사: A와 B의 값을 각각 곱하고 모두 더한 값 즉, 최솟값을 반환한다.
        return minValue;
    }
}
