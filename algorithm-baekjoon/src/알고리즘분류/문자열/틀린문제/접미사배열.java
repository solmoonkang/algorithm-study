package 알고리즘분류.문자열.틀린문제;

import java.io.*;
import java.util.*;

public class 접미사배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String suffix = bufferedReader.readLine();

        Set<String> suffixSequence = new HashSet<>();
        suffixSequence.add(suffix);

        for (int i = 0; i < suffix.length(); i++) {
            suffixSequence.add(suffix.substring(i));
        }

        List<String> suffixList = new ArrayList<>(suffixSequence);
        Collections.sort(suffixList);

        for (String word : suffixList) bufferedWriter.write(word + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
