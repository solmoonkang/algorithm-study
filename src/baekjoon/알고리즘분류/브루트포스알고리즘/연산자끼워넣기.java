package baekjoon.알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    private static int[] A;
    private static int maxNumber = Integer.MIN_VALUE;
    private static int minNumber = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        A = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] operators = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        List<String> operatorList = new ArrayList<>();
        for (int i = 0; i < operators[0]; i++) operatorList.add("+");
        for (int i = 0; i < operators[1]; i++) operatorList.add("-");
        for (int i = 0; i < operators[2]; i++) operatorList.add("*");
        for (int i = 0; i < operators[3]; i++) operatorList.add("/");

        calculateExpression(operatorList, 0);
        bufferedWriter.write(maxNumber + "\n" + minNumber);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void calculateExpression(List<String> operatorList, int start) {
        if (start == operatorList.size()) {
            int currentNumber = A[0];

            for (int i = 0; i < operatorList.size(); i++) {
                String currentOperator = operatorList.get(i);

                switch (currentOperator) {
                    case "+":
                        currentNumber += A[i + 1];
                        break;
                    case "-":
                        currentNumber -= A[i + 1];
                        break;
                    case "*":
                        currentNumber *= A[i + 1];
                        break;
                    case "/":
                        if (currentNumber < 0) currentNumber = -(-currentNumber / A[i + 1]);
                        else currentNumber /= A[i + 1];
                        break;
                }
            }

            maxNumber = Math.max(maxNumber, currentNumber);
            minNumber = Math.min(minNumber, currentNumber);
            return;
        }

        for (int i = start; i < operatorList.size(); i++) {
            swap(operatorList, start, i);
            calculateExpression(operatorList, start + 1);
            swap(operatorList, start, i);
        }
    }

    private static void swap(List<String> operatorList, int i, int j) {
        String temp = operatorList.get(i);
        operatorList.set(i, operatorList.get(j));
        operatorList.set(j, temp);
    }
}
