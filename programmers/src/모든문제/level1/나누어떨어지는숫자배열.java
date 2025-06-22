package 모든문제.level1;

import java.io.*;
import java.util.*;

public class 나누어떨어지는숫자배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(stringTokenizer.nextToken());

        int divisor = Integer.parseInt(bufferedReader.readLine());

        int[] divisibleNumbers = getDivisibleNumbers(array, divisor);
        for (int element : divisibleNumbers) bufferedWriter.write(element + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getDivisibleNumbers(int[] array, int divisor) {
        List<Integer> sequences = new ArrayList<>();

        for (int element : array) {
            if (element % divisor == 0) sequences.add(element);
        }

        if (sequences.isEmpty()) return new int[]{-1};

        Collections.sort(sequences);
        return sequences.stream().mapToInt(i -> i).toArray();
    }

    private static int[] anotherSolution(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
}
