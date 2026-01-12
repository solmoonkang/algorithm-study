package 알고리즘고득점KIT.복습문제.해시;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 전화번호목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] phoneBook = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) phoneBook[i] = stringTokenizer.nextToken();
        bufferedReader.close();

        boolean canPrefix = isNumberPrefix(phoneBook);
        bufferedWriter.write(String.valueOf(canPrefix));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static boolean isNumberPrefix(String[] phoneBook) {
        Set<String> phoneBookSet = new HashSet<>(Arrays.asList(phoneBook));

        for (String phoneNumber : phoneBook) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                String currentPrefix = phoneNumber.substring(0, i);
                if (phoneBookSet.contains(currentPrefix)) return false;
            }
        }

        return true;
    }
}
