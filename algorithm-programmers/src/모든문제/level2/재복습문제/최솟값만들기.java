package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최솟값만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] A = new int[N];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(stringTokenizer.nextToken());

		int[] B = new int[N];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(stringTokenizer.nextToken());

		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(getMinimumProductSum(A, B)));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int getMinimumProductSum(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int total = 0;
		for (int i = 0; i < A.length; i++) {
			total += A[i] * B[A.length - 1 - i];
		}

		return total;
	}
}
