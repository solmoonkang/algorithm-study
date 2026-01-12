package 알고리즘분류.구현;

import java.io.*;

public class 단어뒤집기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        StringBuilder wordBuilder = new StringBuilder();
        StringBuilder reverseBuilder = new StringBuilder();
        boolean isTag = false;

        for (char alphabet : S.toCharArray()) {
            if (alphabet == '<') {
                wordBuilder.append(reverseBuilder.reverse());
                reverseBuilder.setLength(0);
                isTag = true;
                wordBuilder.append(alphabet);
            } else if (alphabet == '>') {
                isTag = false;
                wordBuilder.append(alphabet);
            } else if (isTag) {
                wordBuilder.append(alphabet);
            } else {
                if (alphabet == ' ') {
                    wordBuilder.append(reverseBuilder.reverse());
                    wordBuilder.append(' ');
                    reverseBuilder.setLength(0);
                } else {
                    reverseBuilder.append(alphabet);
                }
            }
        }

        wordBuilder.append(reverseBuilder.reverse());
        bufferedWriter.write(wordBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
