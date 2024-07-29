package programmers.기출문제.Summer_Winter_Coding_2019;

public class 소수만들기 {

    public int solution(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int answer = nums[i] + nums[j] + nums[k];
                    if (isPrime(answer)) count++;
                }
            }
        }

        return count;
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        소수만들기 makingPrime = new 소수만들기();

        int[] firstNums = {1, 2, 3, 4};
        System.out.println("makingPrime = " + makingPrime.solution(firstNums));

        int[] secondNums = {1, 2, 7, 6, 4};
        System.out.println("makingPrime = " + makingPrime.solution(secondNums));
    }
}
