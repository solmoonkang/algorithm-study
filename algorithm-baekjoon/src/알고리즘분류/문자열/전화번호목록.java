package 알고리즘분류.문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 전화번호목록 {

    private static final String CONSISTENT_COLLECTION = "YES";
    private static final String INCONSISTENT_COLLECTION = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            List<String> phoneNumberList = new ArrayList<>();

            int N = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < N; j++) phoneNumberList.add(bufferedReader.readLine());

            boolean isConsistentPhoneNumber = isConsistentPhoneNumberList(phoneNumberList);
            bufferedWriter.write(isConsistentPhoneNumber ? CONSISTENT_COLLECTION + "\n" : INCONSISTENT_COLLECTION + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isConsistentPhoneNumberList(List<String> phoneNumberList) {
        Collections.sort(phoneNumberList);

        for (int i = 0; i < phoneNumberList.size() - 1; i++) {
            String currentNumber = phoneNumberList.get(i);
            String nextNumber = phoneNumberList.get(i + 1);

            if (nextNumber.startsWith(currentNumber)) return false;
        }

        return true;
    }
}
