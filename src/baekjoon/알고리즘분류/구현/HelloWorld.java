package baekjoon.알고리즘분류.구현;

import java.io.*;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write("Hello World!");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
