## 동적 계획법, Dynamic Programming 이란?

---

동적 계획법은 특정 범위까지의 값을 구하기 위해서 그것과 다른 범위까지의 값을 이용하여 효율적으로 값을 구하는 알고리즘 설계 기법이다.

쉽게 말하면 다음과 같다.

- 하나의 큰 문제를 여러 개의 작은 문제로 나누어 그 결과를 저장하여 다시 큰 문제를 해결할 때 사용한다.
- 큰 문제를 작은 문제로 쪼개서 그 답을 저장해 두었다가 재활용한다.

### 중복되는 부분 문제

피보나치 수열을 구현한다고 했을 때, 점화식이 F(n) = F(n - 1) + F(n - 2)이므로 재귀 함수로 구현을 한다고 가정하자.

**[ 단순 재귀 코드 ]**

```java
public class Solution {
		static int[] dp;

		public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			
			dp = new int[number + 1];
			System.out.println(fibo(number));
		}
		
		// 단순 재귀
		static int fibo(int x) {
			if( x ==1 || x==2) return 1;
			return fibo(x-1) + fibo(x-2);
		}
}
```

---

위와 같이 메모이제이션을 사용하지 않고 계속해서 중복 호출을 하면 시간 복잡도는 O($2^n$)을 갖게 된다.

따라서 다음과 같이 중복되는 호출로 인해 좋지 않은 효율을 갖는 것을 확인할 수 있다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/4be87b18-fde5-4cd5-9c82-b17595c1d06c/Untitled.png)

---

이를 좀 더 효율적으로 코딩하는 방법으로는 DP를 사용할 수 있고, DP가 성립하는 조건으로는 다음과 같다.

1. 최적 부분 구조 (Optimal Substructure)
    - 상위 문제를 하위 문제로 나눌 수 있으며, 하위 문제의 답을 모아서 상위 문제를 해결할 수 있다.
2. 중복되는 부분 문제 (Overlapping Subproblem)
    - 동일한 작은 문제를 반복적으로 해결해야 한다.

때문에, 피보나치 수열은 이러한 DP 사용 조건에 만족하게 된다.

### DP 알고리즘 기법은 무엇인가?

---

DP 알고리즘 기법은 이미 계산된 결과 (하위 문제)는 별도의 메모리 영역에 저장하여

다시 계산하지 않도록 설계하여 메모리를 적절히 사용해 수행 시간과 효율성을 비약적으로 향상시키는 방법이다.

이러한 DP 구현 방법으로는 일반적으로 두 가지 방식, Top-down과 Bottom-up 방식으로 구성된다.

## Top-Down VS Bottom-Up

---

### Top-down, 하향식

상위 문제를 해결하기 위해 하위 문제를 재귀적으로 호출하여 하위 문제를 해결함으로써 상위 문제를 해결한다.

- 이때, 해결한 하위 문제를 저장하기 위해 메모이제이션을 사용한다.

예를 들어, 피보나치 함수를 만들 때, Top-down 방식을 사용하면 재귀 호출을 사용하여 구현하게 된다.

```java
public class Topdown {
		static int[] dp;
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			
			dp  = new int[number + 1];
			System.out.println(fibo(number));
			
		}
		
	  // Top-down
		static int fibo(int x) {
			if( x ==1 || x==2) return 1;
			if(dp[x] != 0) return dp[x];
			
			dp[x] = fibo(x-1) + fibo(x-2);
			
			return dp[x];
		}
}
```

### Bottom-up, 상향식

하위에서부터 문제를 해결해나가며 계산했던 문제들의 값을 활용해서 상위 문제를 해결해나가는 방식이다.

- DP의 전형적인 형태는 Bottom-up 방식이다.
- 또한, 여기서 사용되는 문제 결과 값 저장용 리스트는 DP 테이블이라고도 부른다.

마찬가지로, 피보나치 문제를 구현한다고 했을 때, Bottom-up 방식을 사용하면 반복문을 사용해 구현한다.

```java
public class Bottomup {
		static int[] dp;
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			
			dp = new int[number + 1];
			
			System.out.println(fibo(number));
		}
		
	  // Bottom-up
		static int fibo(int x) {
			dp[1] = 1;
			dp[2] = 1;
			
			for(int i = 3; i < x + 1; i++) {
					dp[i] = dp[i-1] + dp[i-2];
			}
			
			return dp[x];
		}
}
```

## 메모이제이션, Memoization

---

메모이제이션은 DP 구현 방법 중 하나로, 한 번 계산된 결과를 메모리 공간에 메모하는 기법이다.

이를 사용하면 모든 부분 문제가 한 번씩만 계산된다 보장할 수 있어 함수 호출 횟수가 감소하게 된다.

위에서 살펴본 재귀 함수와 Top-down 방식을 비교하면 직곽적으로 이해할 수 있다.

```java
// 일반 재귀 함수
// 중복된 계산을 반복해서 하게 된다. 시간복잡도 O(2^n)으로 x의 수가 커질수록 복잡도가 엄청나게 커진다.
static int fibo(int x) {
   if( x ==1 || x==2) return 1;
   
   return fibo(x-1) + fibo(x-2);
}

// Memoization 
// 하위 문제의 결과 값을 dp[] 배열에 저장해놓고 필요할 때마다 계산된 값을 호출한다.
static int fibo(int x) {
   if( x ==1 || x==2) return 1;
   if(dp[x] != 0) return dp[x];
   
   dp[x] = fibo(x-1) + fibo(x-2);
   
   return dp[x];
}
```

---

메모이제이션은 다음과 같은 특징을 갖는다.

- 같은 문제를 다시 호출하면 메모했던 결과 그대로 다시 가져온다.
- 값을 기록한다는 점에서 캐싱이라고 한다.
- DP에만 국한되는 것이 아닌, 한 번 계산된 결과를 담아 놓고 DP가 아닌 다른 방식으로도 사용될 수 있다.

예를 들어, 피보나치 함수의 경우 이미 계산된 결과를 저장하면

다음과 같이 색칠된 노드만 계산이 처리되어 프로그램의 작업속도를 크게 향상시킬 수 있게 된다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/4be87b18-fde5-4cd5-9c82-b17595c1d06c/Untitled.png)

## 동적 계획법 (Dynamic Programming) VS 분할정복 (Divide and Conquer)

---

이전에 살펴본 DP 성립 조건 중 하나인 최적 부분 구조는 분할 정복 방식으로도 풀 수 있다.

- DP와 분할 정복은 해당 문제가 최적 부분 구조의 조건을 가질 때 사용할 수 있다.
- 즉, 상위 문제를 작게 나눠 하위 문제로 나누어서 해결하는 방식으로 처리하면 된다.

그러나, 동적 계획법과 분할정복 방식의 차이점은 “하위 문제의 중복” 이다.

하위 문제가 독립적이지 않고 중복이 되는 경우에는 DP가 분할정복보다 더 나은 시간 복잡도를 갖게 된다.

- 분할정복에서는 동일한 하위 문제는 각각 독립적으로 구성되어 있어 반복적으로 계산되지 않기 때문이다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/7f4099ac-211d-47c0-a3a4-946c74d92b6d/Untitled.png)