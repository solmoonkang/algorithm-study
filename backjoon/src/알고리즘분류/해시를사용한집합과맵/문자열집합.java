package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 문자열집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> setS = new HashSet<>();

        for (int i = 0; i < N; i++) {
            setS.add(bufferedReader.readLine());
        }

        int numberToChecked = 0;
        for (int i = 0; i < M; i++) {
            String stringToChecked = bufferedReader.readLine();
            if (setS.contains(stringToChecked)) numberToChecked++;
        }

        bufferedWriter.write(String.valueOf(numberToChecked));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
