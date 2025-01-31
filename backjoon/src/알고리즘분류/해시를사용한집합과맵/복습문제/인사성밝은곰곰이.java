package 알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 인사성밝은곰곰이 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Boolean> openChatEntranceMap = new HashMap<>();

        int gomGomEmoticonUsage = 0;
        for (int i = 0; i < N; i++) {
            String nickname = bufferedReader.readLine();

            if (nickname.equals("ENTER")) {
                openChatEntranceMap.clear();
            } else {
                if (!openChatEntranceMap.containsKey(nickname)) {
                    gomGomEmoticonUsage++;
                    openChatEntranceMap.put(nickname, true);
                }
            }
        }

        bufferedWriter.write(String.valueOf(gomGomEmoticonUsage));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
