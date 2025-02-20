package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;

public class 뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int minActionNumber = getMinNumberOfActions(S);
        bufferedWriter.write(String.valueOf(minActionNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinNumberOfActions(String consecutiveNumbers) {
        int minActionNumber = 0;
        int groupNumberOne = 0;
        int groupNumberZero = 0;

        char currentNumber = consecutiveNumbers.charAt(0);
        if (currentNumber == '0') groupNumberZero++;
        else groupNumberOne++;

        for (int i = 1; i < consecutiveNumbers.length(); i++) {
            // 이전 문자와 현재 문자가 서로 다르다면 1에서 0으로, 0에서 1로 바뀌는 지점이므로 해당 시점에만 동작하도록 한다.
            if (currentNumber != consecutiveNumbers.charAt(i)) {
                if (consecutiveNumbers.charAt(i) == '0') groupNumberZero++;
                else groupNumberOne++;
                // 이전 문자를 현재 문자로 업데이트한다.
                currentNumber = consecutiveNumbers.charAt(i);
            }
        }
        minActionNumber = Math.min(groupNumberZero, groupNumberOne);

        return minActionNumber;
    }
}
