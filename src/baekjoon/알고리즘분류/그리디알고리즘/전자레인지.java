package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;

public class 전자레인지 {

    private static final int BUTTON_PRESS_A_TIME = 300;
    private static final int BUTTON_PRESS_B_TIME = 60;
    private static final int BUTTON_PRESS_C_TIME = 10;
    private static final int TIME_NOT_ACHIEVABLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        int[] buttonPresses = calculateMinimumButtonPresses(T);
        if (buttonPresses[0] == TIME_NOT_ACHIEVABLE) bufferedWriter.write(TIME_NOT_ACHIEVABLE);
        for (int buttonPressCount : buttonPresses) bufferedWriter.write(buttonPressCount + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] calculateMinimumButtonPresses(int cookingTime) {
        int buttonPressCountA = 0, buttonPressCountB = 0, buttonPressCountC = 0;

        buttonPressCountA = cookingTime / BUTTON_PRESS_A_TIME;
        cookingTime %= BUTTON_PRESS_A_TIME;

        buttonPressCountB = cookingTime / BUTTON_PRESS_B_TIME;
        cookingTime %= BUTTON_PRESS_B_TIME;

        buttonPressCountC = cookingTime / BUTTON_PRESS_C_TIME;
        cookingTime %= BUTTON_PRESS_C_TIME;

        if (cookingTime != 0) return new int[]{TIME_NOT_ACHIEVABLE};

        return new int[]{buttonPressCountA, buttonPressCountB, buttonPressCountC};
    }
}
