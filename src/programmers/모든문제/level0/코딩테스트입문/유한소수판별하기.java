package programmers.모든문제.level0.코딩테스트입문;

public class 유한소수판별하기 {

    // TODO: 유한소수 판별하는 부분에 문제가 있음.
    public int solution(int a, int b) {
        if (b / getGCD(a, b) % 2 == 0 || b / getGCD(a, b) % 5 == 0) return 1;
        return 2;
    }

    private int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }



    public int solution1(int a, int b) {
        int gcd = getGCD(a, b);
        b /= gcd;

        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;

        return b == 1 ? 1 : 2;
    }

    public static void main(String[] args) {
        유한소수판별하기 determiningIfANumberIsATerminationDecimal = new 유한소수판별하기();

        System.out.println("determiningIfANumberIsATerminationDecimal = " +
                determiningIfANumberIsATerminationDecimal.solution1(7, 20));
        System.out.println("determiningIfANumberIsATerminationDecimal = " +
                determiningIfANumberIsATerminationDecimal.solution1(11, 22));
        System.out.println("determiningIfANumberIsATerminationDecimal = " +
                determiningIfANumberIsATerminationDecimal.solution1(12, 21));
    }
}
