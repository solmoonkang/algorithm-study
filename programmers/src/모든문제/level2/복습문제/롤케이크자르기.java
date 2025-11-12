package 모든문제.level2.복습문제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 롤케이크자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] topping = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) topping[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int fairSliceCount = getRollCakeCountFairSlices(topping);
        bufferedWriter.write(String.valueOf(fairSliceCount));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getRollCakeCountFairSlices(int[] topping) {
        Set<Integer> leftPointerSet = new HashSet<>();
        Set<Integer> rightPointerSet = new HashSet<>();

        int[] leftKinds = new int[topping.length];
        int[] rightKinds = new int[topping.length];

        for (int i = 0; i < topping.length; i++) {
            leftPointerSet.add(topping[i]);
            leftKinds[i] = leftPointerSet.size();
        }

        for (int i = topping.length - 1; i >= 0; i--) {
            rightPointerSet.add(topping[i]);
            rightKinds[i] = rightPointerSet.size();
        }

        int fairSliceCount = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            int leftKindsCount = leftKinds[i];
            int rightKindsCount = rightKinds[i + 1];
            if (leftKindsCount == rightKindsCount) fairSliceCount++;
        }

        return fairSliceCount;
    }
}
