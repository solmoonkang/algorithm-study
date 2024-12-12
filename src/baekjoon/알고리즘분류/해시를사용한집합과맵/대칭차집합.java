package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭차집합 {

    // TODO: 대칭차집합에 대한 이해가 부족하다. 또한 Set 자료구조에 대한 활용도가 아직 미숙하다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int setAElementSize = Integer.parseInt(stringTokenizer.nextToken());
        int setBElementSize = Integer.parseInt(stringTokenizer.nextToken());

        Set<Integer> setA = new HashSet<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < setAElementSize; i++) {
            setA.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Set<Integer> setB = new HashSet<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < setBElementSize; i++) {
            setB.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        /**
         * 대칭 차집합 계산 구문
         * <p>
         * 1. 대칭 차집합은 A와 B의 모든 원소를 포함해야 하므로, setA의 원소를 먼저 포함시키고, 이후 B의 원소를 추가한다.
         * 2. symmetricDifference는 A와 B의 모든 원소를 포함하게 된다.
         */
        Set<Integer> symmetricDifference = new HashSet<>(setA);
        symmetricDifference.addAll(setB);

        /**
         * 교집합 계산 구문
         * <p>
         * 1. 교집합을 구하기 위해 A의 원소를 기준으로 B와 비교해야 하므로, A의 원소를 복사하여 intersection를 선언한다.
         * 2. intersection에 있는 원소 중 setB에도 존재하는 원소만 남긴다. 즉, intersection은 A와 B의 교집합이다.
         */
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        // symmetricDifference에서 intersection에 포함된 모든 원소를 제거한다. 즉, A와 B에 공통으로 존재하는 원소들을 삭제한다.
        symmetricDifference.removeAll(intersection);

        bufferedWriter.write(String.valueOf(symmetricDifference.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
