package 모든문제.level2.복습문제;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 캐시 {

    private static final int CACHE_HIT_EXECUTION_TIME = 1;
    private static final int CACHE_MISS_EXECUTION_TIME = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int cacheSize = Integer.parseInt(bufferedReader.readLine());

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] cities = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) cities[i] = stringTokenizer.nextToken();
        bufferedReader.close();

        int totalExecutionTime = measureExecutionTimeWithCache(cacheSize, cities);
        bufferedWriter.write(String.valueOf(totalExecutionTime));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int measureExecutionTimeWithCache(int cacheSize, String[] cities) {
        // cacheSize가 0인 경우 캐시를 사용할 수 없으므로 모든 접근은 MISS이다.
        if (cacheSize == 0) return cities.length * CACHE_MISS_EXECUTION_TIME;

        int totalExecutionTime = 0;
        LinkedList<String> cacheStorage = new LinkedList<>();   // LinkedList는 제거/삽입에 더 유리하다.

        for (String city : cities) {
            String currentCity = city.toLowerCase();

            // 캐시 히트 처리를 위한 조건
            if (cacheStorage.contains(currentCity)) {
                totalExecutionTime += CACHE_HIT_EXECUTION_TIME;
                cacheStorage.remove(currentCity);
                cacheStorage.addLast(currentCity);
            }

            // 캐시 미스 처리를 위한 조건
            else {
                totalExecutionTime += CACHE_MISS_EXECUTION_TIME;
                if (cacheStorage.size() == cacheSize) cacheStorage.pollFirst();
                cacheStorage.addLast(currentCity);
            }
        }

        return totalExecutionTime;
    }

    private static int getCachePerformanceTime(int cacheSize, String[] cities) {
        // 초기 cities 배열의 첫 cacheSize개의 도시를 무조건 캐시에 넣고, 그에 해당하는 CACHE_MISS를 미리 한 번에 더해버렸다.
        // 그 결과 실제 도시 접근 순서와 상관없이 초기 실행 시간을 계산하게 되어, 특히 cities 배열의 길이가 cacheSize보다 작을 때나, 초기 도시들이 반복될 때 정확한 시뮬레이션이 불가능하다.
        // -> 초기 cacheSize개를 별도로 처리하지 말고, 모든 도시를 for 루프 하나로 처음부터 순서대로 처리해야 한다.

        // 크기가 cacheSize인 덱을 선언해서 cities에 담긴 원소를 cacheSize만큼을 덱에 추가한다.
        Deque<String> cacheStorage = new ArrayDeque<>(cacheSize);
        for (int i = 0; i < cacheSize; i++) cacheStorage.offerLast(cities[i]);

        int totalExecutionTime = CACHE_MISS_EXECUTION_TIME * cacheSize;

        // 캐시에 저장된 값과 도시이름을 서로 비교할 수 있어야 한다.
        for (int i = cacheSize; i < cities.length; i++) {
            String currentCity = cities[i];

            // LRU 캐시의 핵심은 히트가 발생하면, 해당 항목이 '가장 최근에 사용됨'으로 업데이트되어야 한다.
            // cacheStorage.contains(currentCity)가 true일 때, 실행 시간만 추가하고 도시의 위치를 갱신하지 않고 있다.
            // 그 결과 히트된 도시가 캐시의 가장 오래된 위치에 남아있게 되어, 이후 불필요하게 밀려나는 오류가 발생한다.
            // -> 캐시 히트 시, 해당 도시를 캐시에서 제거한 후, 가장 최근 위치에 다시 추가해야 한다.
            if (cacheStorage.contains(currentCity)) {
                totalExecutionTime += CACHE_HIT_EXECUTION_TIME;
            }

            // 캐시 미스 시, 무조건 pollFirst로 가장 오래된 항목을 제거하고 새 항목을 추가한다. 하지만 cacheSize가 0이거나, 캐시가 아직 가득 차지 않은 상태일 경우를 고려해야 한다.
            // -> cacheSize가 0일 때는 특수 처리하고, cachSize > 0일 때, 캐시가 가득 찼을 때만 가장 오래된 항목을 제거해야 한다.
            else {
                cacheStorage.pollFirst();
                cacheStorage.offerLast(currentCity);
                totalExecutionTime += CACHE_MISS_EXECUTION_TIME;
            }
        }

        return totalExecutionTime;
    }
}
