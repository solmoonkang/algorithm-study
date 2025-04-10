package 알고리즘분류.구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 고려대는사랑입니다 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write("고려대학교");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
