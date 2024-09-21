package programmers.기출문제.PCCE기출문제.LV0;

import java.util.Scanner;

public class 각도합치기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum_angle = (angle1 + angle2) % 360;
        System.out.println(sum_angle);
    }
}
