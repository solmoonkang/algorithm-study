package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어제거하기 {

	private static final int RESULT_SUCCESS = 1;
	private static final int RESULT_FAILURE = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String sentence = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(canRemoveAdjacentPairs(sentence)));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int canRemoveAdjacentPairs(String sentence) {
		Deque<Character> remainingChars = new ArrayDeque<>();

		for (char alphabet : sentence.toCharArray()) {
			if (!remainingChars.isEmpty() && remainingChars.peekLast() == alphabet)
				remainingChars.pollLast();
			else
				remainingChars.offerLast(alphabet);
		}

		return remainingChars.isEmpty() ? RESULT_SUCCESS : RESULT_FAILURE;
	}
}
