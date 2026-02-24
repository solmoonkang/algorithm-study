package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String parentheses = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(validParenthesesForStack(parentheses)));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static boolean validParenthesesForStack(String parentheses) {
		// 여는 괄호를 만나면 "나중에 짝꿍 오면 나가야지"하고 보관함(Stack)에 쌓아둔다.
		Deque<Character> openBrackets = new ArrayDeque<>();

		for (char parenthesis : parentheses.toCharArray()) {
			if (parenthesis == '(') {
				openBrackets.offerLast(parenthesis);

			// 닫는 괄호가 나오면 보관함에서 가장 최근에 들어간 여는 괄호 하나를 꺼내서 같이 사라진다.
			} else {
				// 보관함이 비어있는데 꺼내려 할 때 짝꿍 없이 혼자 온 것이므로 즉시 실패한다.
				if (openBrackets.isEmpty())
					return false;
				openBrackets.pollFirst();
			}
		}

		return openBrackets.isEmpty();
	}

	private static boolean validParenthesesForCounter(String parentheses) {
		int count = 0;

		for (char parenthesis : parentheses.toCharArray()) {
			if (parenthesis == '(') {
				count++;

			} else {
				count--;
				if (count < 0) return false;
			}
		}

		return count == 0;
	}
}
