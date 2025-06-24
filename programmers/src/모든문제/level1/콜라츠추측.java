package 모든문제.level1;

import java.io.*;

public class 콜라츠추측 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bufferedReader.readLine());

        int count = getCollatzNumber(num);
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getCollatzNumber(int num) {
        if (num == 1) return 0;

        long number = num;
        int count = 0;

        while (number != 1) {
            if (number % 2 == 0) number /= 2;
            else number = number * 3 + 1;
            count++;

            if (count == 500) return -1;
        }

        return count;
    }

    private static int anotherSolution(int num) {
        long current = num;

        for (int steps = 0; steps < 500; steps++) {
            if (current == 1) return steps;
            current = (current % 2 == 0) ? current / 2 : current * 3 + 1;
        }

        return -1;
    }
}
