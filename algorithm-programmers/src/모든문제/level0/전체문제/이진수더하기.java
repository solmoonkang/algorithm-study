package 모든문제.level0.전체문제;

public class 이진수더하기 {

    public String solution(String bin1, String bin2) {

        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }

    public static void main(String[] args) {
        이진수더하기 sumOfBinary = new 이진수더하기();

        System.out.println("sumOfBinary = " + sumOfBinary.solution("10", "11"));
        System.out.println("sumOfBinary = " + sumOfBinary.solution("1001", "1111"));
    }
}
