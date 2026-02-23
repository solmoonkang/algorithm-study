package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JadenCase문자열만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String sentence = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String jadenCase = convertJadenCaseSentence(sentence);
		bufferedWriter.write(jadenCase);
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static String convertJadenCaseSentence(String sentence) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean isFirst = true;

		for (char alphabet : sentence.toCharArray()) {
			if (alphabet == ' ') {
				stringBuilder.append(alphabet);
				isFirst = true;
			}

			else {
				if (isFirst) {
					stringBuilder.append(Character.toUpperCase(alphabet));
					isFirst = false;

				} else {
					stringBuilder.append(Character.toLowerCase(alphabet));
				}
			}
		}

		return stringBuilder.toString();
	}
}
