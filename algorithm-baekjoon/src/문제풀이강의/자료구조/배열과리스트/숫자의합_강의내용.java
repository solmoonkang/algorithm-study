package 문제풀이강의.자료구조.배열과리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자의합_강의내용 {

	/**
	 * 입력 조건에 따른 타입 선택
	 *
	 * [입력] 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
	 * N이 최대 100이므로, 둘쨰 줄 입력은 100자리의 정수가 들어올 수 있다.
	 * - int형은 약 10자리로 2,147,483,647까지 가능하다.
	 * - long형은 약 19자리로 9,223,372,036,854,775,807까지 가능하다.
	 * 따라서 100자리의 숫자는 long의 범위를 아득히 초과하므로 String 수신이 필수적이다.
	 */

	/**
	 * 슈도코드 작성
	 *
	 * N값 입력받기
	 * 길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기
	 * sNum을 다시 char[]형 변수 cNum에 변환하여 저장하기
	 * int형 변수 sum 선언하기
	 * for (cNum 길이만큼 반복하기) { 배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적하기 }
	 * sum 출력하기
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		String sNum = bufferedReader.readLine();
		bufferedReader.close();

		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0';
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		bufferedWriter.write(String.valueOf(sum));
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
