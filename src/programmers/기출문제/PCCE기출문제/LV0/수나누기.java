package programmers.기출문제.PCCE기출문제.LV0;

import java.util.Scanner;

public class 수나누기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < number; i++) {
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}
