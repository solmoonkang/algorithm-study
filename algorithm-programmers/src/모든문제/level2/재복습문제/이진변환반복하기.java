package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이진변환반복하기 {

	/**
	 * TODO: 다시 풀어보기 (복습 포인트)
	 * 1. 물리적 제거(replace)보다 '1의 개수'를 세는 것이 성능과 로직 면에서 훨씬 효율적임.
	 * 2. 0을 제거한 후의 길이(int)를 'Integer.toBinaryString()'을 이용해 이진수 문자열로 갱신하는 단계 누락 주의.
	 * 3. 0을 지우는 행위에 매몰되지 말고, '남은 길이 = 1의 개수'라는 발상의 전환이 핵심.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String sentence = bufferedReader.readLine();
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] binaryInfo = getBinaryTransformation(sentence);
		for (int number : binaryInfo)
			bufferedWriter.write(number + " ");
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static int[] getBinaryTransformation(String sentence) {
		/*
			[요약]
			1. replace("0", "")를 통해 물리적으로 0을 지운다.
			2. (현재 코드에서 놓친 부분) 남은 문자열의 길이를 구한다.
			3. 그 길이를 이진수 문자열로 변환하여 sentence에 다시 넣고 1이 될 때까지 반복한다.

			[잘못된 점 / 보완할 점]
			- 물리적 조작의 한계: replace는 매번 새로운 문자열 객체를 만든다. 때문에 문자열 길이가 15만인데 이를 반복하면 메모리와 시간이 많이 소요된다.
			- 이진수 변환 누락: 정수(길이)를 다시 이진수 문자열로 바꾸는 과정이 빠져있어 다음 루프를 돌 수 있다.
		 */

		/*
			첫 번째 전환: 0을 지우지 말고, 1을 세자
			- 0을 지운 문자열의 길이는 결국 원래 문자열에 들어있던 1의 개수와 일치한다.
			- 문자열을 한 글자씩 훑으면서 1이 보이면 count++한다.
			- 그러면 제거된 0의 개수는 원래 문자열 길이 - 1의 개수가 된다.
			- 이렇게 하면 replace 같은 무거운 메서드 없이도 순식간에 필요한 정보를 얻을 수 있다.

			두 번째 전환: 숫자를 다시 문자열로 바꾸는 도구
			- 자바에는 정수를 이진수 형태의 문자열로 바꿔주는 Integer.toBinaryString(n) 메서드가 있다.
		 */

		int totalTransform = 0;        	// 변환 횟수
		int totalRemoveZeros = 0;    	// 제거된 총 0의 개수

		while (!sentence.equals("1")) {
			int originalLength = sentence.length();
			int oneCount = 0;

			// 1. 문자열을 한 바퀴 돌며 '1'의 개수만 센다. (0을 제거한 효과)
			for (int i = 0; i < originalLength; i++) {
				if (sentence.charAt(i) == '1')
					oneCount++;
			}

			// 2. 제거된 0의 개수를 누적한다.
			totalRemoveZeros += (originalLength - oneCount);

			// 3. '1의 개수'를 이진수 문자열로 변환하여 다음 sentence로 만든다.
			sentence = Integer.toBinaryString(oneCount);

			// 4. 변환 횟수 증가
			totalTransform++;
		}

		return new int[] {totalTransform, totalRemoveZeros};
	}
}
