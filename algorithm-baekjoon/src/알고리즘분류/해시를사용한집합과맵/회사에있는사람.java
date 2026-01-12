package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, String> accessLogMap = new HashMap<>();
        List<String> enteredUsers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            accessLogMap.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }

        for (Map.Entry<String, String> entry : accessLogMap.entrySet()) {
            if (entry.getValue().equals("enter")) enteredUsers.add(entry.getKey());
        }

        enteredUsers.sort(Collections.reverseOrder());
        for (String userName : enteredUsers) {
            bufferedWriter.write(userName + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
