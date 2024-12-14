package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 인사성밝은곰곰이 {

    // TODO: 이전 풀이인 Map에 저장된 VALUE를 모두 더한 값은 불필요한 반복문으로 인해 시간 복잡도가 증가하여 비효율적이었다.
    //  때문에, 사용자 닉네임을 키로, 해당 사용자가 이미 채팅했는지 여부를 저장하고 이모티콘 사용 횟수를 카운트하여 반환하고, 새로운 사용자가 들어오면 Map에 저장된 이전 사용자 정보를 초기화한다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Boolean> gomGomEmoticonCountMap = new HashMap<>();

        int gomGomEmoticonUsageFrequency = 0;

        for (int i = 0; i < N; i++) {
            String nicknameOrStatus = bufferedReader.readLine();

            if (nicknameOrStatus.equals("ENTER")) {
                gomGomEmoticonCountMap.clear();
            } else {
                if (!gomGomEmoticonCountMap.containsKey(nicknameOrStatus)) {
                    gomGomEmoticonUsageFrequency++;
                    gomGomEmoticonCountMap.put(nicknameOrStatus, true);
                }
            }
        }

        bufferedWriter.write(String.valueOf(gomGomEmoticonUsageFrequency));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
