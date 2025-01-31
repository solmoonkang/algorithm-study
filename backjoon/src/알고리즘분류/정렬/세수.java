package 알고리즘분류.정렬;

import java.io.*;

public class 세수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputList = bufferedReader.readLine().split(" ");
        int A = Integer.parseInt(inputList[0]);
        int B = Integer.parseInt(inputList[1]);
        int C = Integer.parseInt(inputList[2]);

        int secondLargest;
        if ((A >= B && A <= C) || (A <= B && A >= C)) secondLargest = A;
        else if ((B >= A && B <= C) || (B <= A && B >= C)) secondLargest = B;
        else secondLargest = C;

        bufferedWriter.write(String.valueOf(secondLargest));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
