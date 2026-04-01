package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 점프와순간이동 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(getMinBatteryUsage(N)));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int getMinBatteryUsage(int N) {
		int jumpCount = 0;

		while (N != 0) {
			if (N % 2 != 0) {
				N--;
				jumpCount++;
			} else {
				N /= 2;
			}
		}

		return jumpCount;
	}

	private static int getMinBatteryUsageForBit(int N) {
		return Integer.bitCount(N);
	}
}
