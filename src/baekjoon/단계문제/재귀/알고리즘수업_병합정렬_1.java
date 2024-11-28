package baekjoon.단계문제.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 알고리즘수업_병합정렬_1 {

    // TODO: 배열이 어떻게 정렬되는지 이해하지 못했다. 각 재귀함수에 대해서 다시 이해해보자.

    private static int N, K;
    private static int[] numbers;
    private static int[] tempNumbers;
    private static int saveNumber = 0;
    private static int kthNumber = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        tempNumbers = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        mergeSort(0, N - 1);

        bufferedWriter.write(String.valueOf(kthNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, end);
            merge(start, middle, end);
        }
    }

    private static void merge(int start, int middle, int end) {
        int leftPointer = start;
        int rightPointer = middle + 1;
        int arrayPointer = 0;

        while (leftPointer <= middle && rightPointer <= end) {
            if (numbers[leftPointer] <= numbers[rightPointer]) tempNumbers[arrayPointer++] = numbers[leftPointer++];
            else tempNumbers[arrayPointer++] = numbers[rightPointer++];
        }

        while (leftPointer <= middle) {
            tempNumbers[arrayPointer++] = numbers[leftPointer++];
        }

        while (rightPointer <= end) {
            tempNumbers[arrayPointer++] = numbers[rightPointer++];
        }

        leftPointer = start;
        arrayPointer = 0;

        while (leftPointer <= end) {
            numbers[leftPointer++] = tempNumbers[arrayPointer++];
            saveNumber++;

            if (saveNumber == K) kthNumber = numbers[leftPointer - 1];
        }
    }
}
