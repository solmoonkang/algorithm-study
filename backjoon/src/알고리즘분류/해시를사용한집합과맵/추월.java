package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 추월 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());


        List<String> tunnelEntranceCarNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) tunnelEntranceCarNumbers.add(bufferedReader.readLine());

        List<String> tunnelExitCarNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) tunnelExitCarNumbers.add(bufferedReader.readLine());

        List<String> overtakingCarNumbersList = new ArrayList<>();

        Map<String, Integer> entranceIndexMap = new HashMap<>();
        // 터널 입구를 지나는 차량 번호와 인덱스를 매핑하여 저장한다.
        for (int i = 0; i < tunnelEntranceCarNumbers.size(); i++) {
            entranceIndexMap.put(tunnelEntranceCarNumbers.get(i), i);
        }

        // 터널 출구 차량 목록을 순회한다.
        for (String carNumbers : tunnelExitCarNumbers) {
            // 만약, 터널 입구를 지나는 차량 번호와 터널 출구 차량 번호가 동일할 경우,
            if (entranceIndexMap.containsKey(carNumbers)) {
                // 출구 목록에서 현재 차량 번호의 인덱스를 찾는다.
                int exitIndex = tunnelExitCarNumbers.indexOf(carNumbers);
                // 차량 번호에 해당하는 터널 입구를 지난 인덱스를 가져온다.
                int entranceIndex = entranceIndexMap.get(carNumbers);
                // 출구 목록에서의 인덱스가 입구에서의 인덱스보다 작으면, 해당 차량은 추월한 차량으로 간주한다.
                if (exitIndex < entranceIndex) overtakingCarNumbersList.add(carNumbers);
            }
        }

        bufferedWriter.write(String.valueOf(overtakingCarNumbersList.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
