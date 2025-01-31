package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 듣보잡 {

    // TODO: 요소를 지속적으로 추가 및 삭제하며, 항상 정렬된 상태가 필요한 경우 TreeSet이 효율적일 수 있지만,
    //  현재 상황에서는 요소를 추가한 후 한 번에 정렬하는 방식이 더 효율적일 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> nonHeardPeople = new HashSet<>();
        Set<String> nonHeardOrSeenPeople = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            nonHeardPeople.add(bufferedReader.readLine());
        }

        for (int i = 0; i < M; i++) {
            String nonSeenPersonName = bufferedReader.readLine();
            if (nonHeardPeople.contains(nonSeenPersonName)) nonHeardOrSeenPeople.add(nonSeenPersonName);
        }

        bufferedWriter.write(nonHeardOrSeenPeople.size() + "\n");
        for (String nonHeardOrSeenPersonName : nonHeardOrSeenPeople) {
            bufferedWriter.write(nonHeardOrSeenPersonName + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
