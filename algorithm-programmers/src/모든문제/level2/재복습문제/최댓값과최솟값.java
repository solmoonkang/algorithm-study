package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class 최댓값과최솟값 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String numbers = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String minAndMaxNumber = getMinAndMaxNumbers(numbers);
		bufferedWriter.write(minAndMaxNumber);
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static String getMinAndMaxNumbers(String numbers) {
		String[] splitNumbers = numbers.split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (String numStr : splitNumbers) {
			int num = Integer.parseInt(numStr);

			if (num < min)
				min = num;
			if (num > max)
				max = num;
		}

		return min + " " + max;
	}

	private static String getMinAndMaxNumbersForStream(String numbers) {
		IntSummaryStatistics intSummaryStatistics = Arrays.stream(numbers.split(" "))
			.mapToInt(Integer::parseInt)
			.summaryStatistics();

		return intSummaryStatistics.getMin() + " " + intSummaryStatistics.getMax();
	}
}
