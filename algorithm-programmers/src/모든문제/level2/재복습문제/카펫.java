package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카펫 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int brown = Integer.parseInt(bufferedReader.readLine());
		int yellow = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] size = solution(brown, yellow);
		for (int a : size)
			bufferedWriter.write(a + " ");
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int[] solution(int brown, int yellow) {
		int W = 0;
		int H = 0;

		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i == 0) {
				int yH = i;
				int yW = yellow / i;

				int tempW = yW + 2;
				int tempH = yH + 2;

				if ((tempW * tempH) - yellow == brown) {
					W = tempW;
					H = tempH;
					break;
				}
			}
		}

		return new int[] {W, H};
	}
}
