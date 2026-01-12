package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;

public class 전자레인지 {

    private static final int FIVE_MINUTES = 300;
    private static final int ONE_MINUTES = 60;
    private static final int TEN_SECONDS = 10;
    private static final String CAN_NOT_SET_T_SECONDS = "-1";

    // TODO: 런타임 에러 발생, 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        int[] minOperations = getMinButtonOperationToCookTSeconds(T);

        if (minOperations == null) bufferedWriter.write(CAN_NOT_SET_T_SECONDS);
        for (int operation : minOperations) bufferedWriter.write(operation + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getMinButtonOperationToCookTSeconds(int targetSeconds) {
        int[] operations = new int[3];

        operations[0] = targetSeconds / FIVE_MINUTES;
        targetSeconds %= FIVE_MINUTES;

        operations[1] = targetSeconds / ONE_MINUTES;
        targetSeconds %= ONE_MINUTES;

        operations[2] = targetSeconds / TEN_SECONDS;
        targetSeconds %= TEN_SECONDS;

        if (targetSeconds > 0) return null;

        return operations;
    }
}
