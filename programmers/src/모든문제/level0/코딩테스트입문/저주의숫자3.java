package 모든문제.level0.코딩테스트입문;

public class 저주의숫자3 {

    public int solution(int n) {
        int count = 0;
        int currentNumber = 0;

        while (count < n) {
            currentNumber++;

            if (currentNumber % 3 != 0 && !String.valueOf(currentNumber).contains("3")) count++;
        }

        return currentNumber;
    }

    public static void main(String[] args) {
        저주의숫자3 theCursedNumber = new 저주의숫자3();

        System.out.println("theCursedNumber = " + theCursedNumber.solution(15));
        System.out.println("theCursedNumber = " + theCursedNumber.solution(40));
    }
}
