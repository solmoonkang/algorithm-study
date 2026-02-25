package 모든문제.level2.재복습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자의표현 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int naturalNumberCount = countConsecutiveSumForTwoPointer(N);
		bufferedWriter.write(String.valueOf(naturalNumberCount));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	// 연속된 자연수들로 N을 표현하는 방법의 수를 구하라는 조건
	// 		-> 내가 처음에 생각한 방법은 브루트포스
	// 		-> 그 외 다른 방법으로는 투 포인터 전략
	// 		-> 수학적 접근으로는 약수

	private static int countConsecutiveSumForBruteForce(int N) {
		/*
			1. 브루트포스 방식으로 구현할 수 있었던 이유
			이 문제에서 브루트포스가 성립하는 이유는 문제의 데이터 범위 때문이다.

			- 제한 사항: N은 10,000 이하이다.
			- 연산 횟수: 최악의 경우(1부터 10,000까지 다 더해보는 경우)를 따져봐도, 컴퓨터 입장에서 10,000 * 10,000 정도의 연산은 1초 이내에 처리할 수 있다.
			- 확실성: 모든 경우의 수를 다 확인하기 때문에, 로직만 정학하다면 예외 없는 정답을 보장한다.
		 */

		/*
			2. 이 방식이 비효율적인 이유
			하지만 N이 10,000이 아니라 1,000,000 혹은 그 이상이 된다면 브루트포스는 바로 한계에 부딪힌다.

			- ① 중복 계산이 너무 많다.
			- ② 시간 복잡도가 $O(N^2)$이다.
			- ③ 불필요한 탐색 구간: 시작 숫자가 N/2보다 커지면, 그 다음 숫자와 더하는 순간 무조건 N을 넘게 된다.
		 */

		int count = 0;

		for (int i = 1; i <= N; i++) {
			int sum = 0;

			for (int j = i; j <= N; j++) {
				sum += j;

				if (sum == N) {
					count++;
					break;
				}

				if (sum > N) {
					break;
				}
			}
		}

		return count;
	}

	private static int countConsecutiveSumForTwoPointer(int N) {


	}

	private static int countConsecutiveSumForDivisor(int N) {


	}
}
