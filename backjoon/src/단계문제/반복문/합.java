package 단계문제.반복문;

import java.util.Scanner;

public class 합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += i;
        }

        System.out.println(answer);
    }
}
