package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String sentence = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int validParentheses = getNumberOfValidParentheses(sentence);
		bufferedWriter.write(String.valueOf(validParentheses));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int getNumberOfValidParentheses(String sentence) {
		if (sentence.length() % 2 != 0)
			return 0;

		int validParenthesesCount = 0;
		for (int i = 0; i < sentence.length(); i++) {
			String rotatedParentheses = sentence.substring(i) + sentence.substring(0, i);
			if (validateParentheses(rotatedParentheses))
				validParenthesesCount++;
		}

		return validParenthesesCount;
	}

	private static boolean validateParentheses(String rotateParentheses) {
		Deque<Character> openBracket = new ArrayDeque<>();

		for (int i = 0; i < rotateParentheses.length(); i++) {
			char currentParenthies = rotateParentheses.charAt(i);

			if (currentParenthies == '(' || currentParenthies == '[' || currentParenthies == '{') {
				openBracket.offerLast(currentParenthies);
			} else {
				if (openBracket.isEmpty())
					return false;

				char top = openBracket.pollFirst();
				if (currentParenthies == ')' && top != '(')
					return false;
				if (currentParenthies == ']' && top != '[')
					return false;
				if (currentParenthies == '}' && top != '{')
					return false;
			}
		}

		return openBracket.isEmpty();
	}
}
