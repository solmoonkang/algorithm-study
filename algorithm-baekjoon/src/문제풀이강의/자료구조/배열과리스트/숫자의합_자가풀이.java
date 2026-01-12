package 문제풀이강의.자료구조.배열과리스트;

import java.io.*;

public class 숫자의합_자가풀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		String number = bufferedReader.readLine();
		bufferedReader.close();

		int sum = 0;

		char[] numbers = number.toCharArray();
		for (int num : numbers) {
			sum += (num - '0');
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(sum));
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
