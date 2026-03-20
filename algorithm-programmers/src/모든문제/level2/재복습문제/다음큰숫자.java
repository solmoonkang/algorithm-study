package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 다음큰숫자 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = nextBigNumber(N);
		bufferedWriter.write(String.valueOf(number));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int nextBigNumber(int N) {
		int targetCount = Integer.bitCount(N);

		int count = 0;
		while (count != targetCount) {
			N++;
			count = Integer.bitCount(N);
		}

		return N;
	}
}
