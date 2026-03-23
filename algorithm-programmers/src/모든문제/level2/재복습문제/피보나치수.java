package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치수 {

	private static final int MOD = 1234567;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(getFibonacciRemainder(N)));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int getFibonacciRemainder(int N) {
		int[] fibonacciNumbers = new int[N + 1];

		fibonacciNumbers[0] = 0;
		fibonacciNumbers[1] = 1;

		for (int i = 2; i <= N; i++) {
			fibonacciNumbers[i] = (fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2]) % MOD;
		}

		return fibonacciNumbers[N];
	}
}
