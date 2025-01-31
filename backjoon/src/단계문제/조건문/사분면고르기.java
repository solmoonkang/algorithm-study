package 단계문제.조건문;

import java.io.*;

public class 사분면고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bufferedReader.readLine());
        int Y = Integer.parseInt(bufferedReader.readLine());

        if (X > 0) {
            if (Y > 0) bufferedWriter.write("1");
            else bufferedWriter.write("4");
        } else {
            if (Y > 0) bufferedWriter.write("2");
            else bufferedWriter.write("3");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
