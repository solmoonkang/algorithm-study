package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 스택2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());

            switch (command) {
                case 1:
                    int X = Integer.parseInt(stringTokenizer.nextToken());
                    numberStack.offerLast(X);
                    break;
                case 2:
                    if (!numberStack.isEmpty()) bufferedWriter.write(numberStack.pollLast() + "\n");
                    else bufferedWriter.write("-1\n");
                    break;
                case 3:
                    bufferedWriter.write(numberStack.size() + "\n");
                    break;
                case 4:
                    if (!numberStack.isEmpty()) bufferedWriter.write("0\n");
                    else bufferedWriter.write("1\n");
                    break;
                case 5:
                    if (!numberStack.isEmpty()) bufferedWriter.write(numberStack.peekLast() + "\n");
                    else bufferedWriter.write("-1\n");
                    break;
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
