package 알고리즘분류.문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 접미사배열 {

    private static List<String> suffixesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        generateSuffixes(S);

        Collections.sort(suffixesList);

        for (String suffixes : suffixesList) {
            bufferedWriter.write(suffixes + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSuffixes(String suffixes) {

        for (int i = 0; i < suffixes.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = i; j < suffixes.length(); j++) {
                stringBuilder.append(suffixes.charAt(j));
            }
            suffixesList.add(stringBuilder.toString());
        }
    }
}
