package programmers.모든문제.level1.전체문제;

public class 기사단원의무기 {

    public int solution(int number, int limit, int power) {
        // 기사단원의 수 = number, 공격력 제한 수치 = limit, 무기 공격력 = power
        // 무기 공격력 1당 1kg의 철이 필요한데, 무기점에서 무기를 만들기 위해 필요한 철의 무게를 반환
        int[] divisors = new int[number];

        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            // 숫자를 1부터 시작했기 때문에 배열 인덱싱 0으로 만들어주기 위함
            divisors[i - 1] = count;
        }

        int answer = 0;
        for (int i = 0; i < divisors.length; i++) {
            if (divisors[i] > limit) {
                divisors[i] = power;
            }

            answer += divisors[i];
        }

        return answer;
    }

    public int solution2(int number, int limit, int power) {
        // 각 숫자에 대한 약수의 개수를 구하는 과정을 최적화
        int[] divisors = new int[number];

        for (int i = 1; i <= number; i++) {
            int count = 0;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    if (i / j == j) count++;
                    else count += 2;
                }
            }

            divisors[i - 1] = count;
        }

        int answer = 0;
        for (int i = 0; i < divisors.length; i++) {
            if (divisors[i] > limit) {
                answer += power;
            } else {
                answer += divisors[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        기사단원의무기 knightWeapon = new 기사단원의무기();

        System.out.println("knightWeapon = " + knightWeapon.solution2(5, 3, 2));
        System.out.println("knightWeapon = " + knightWeapon.solution2(10, 3, 2));
    }
}
