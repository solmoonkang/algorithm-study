package 모든문제.level2;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class 일차캐시 {

    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int cacheSize = Integer.parseInt(stringTokenizer.nextToken());
        int citySize = Integer.parseInt(stringTokenizer.nextToken());

        String[] cities = new String[citySize];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < citySize; i++) cities[i] = stringTokenizer.nextToken();

        int executionTime = calculateExecutionTimeWithCache(cacheSize, cities);
        bufferedWriter.write(String.valueOf(executionTime));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * LRU 알고리즘: 가장 오랫동안 사용되지 않은 데이터를 가장 먼저 제거하는 캐시 전략이다.
     *  - initialCapacity: 초기 버킷 수 (map 내부 배열 크기)
     *  - loadFactor: 버킷의 적정 채움 비율 (기본 0.75f)
     *  - accessOrder: true면 LRU 구현 가능 (접근 순서 유지), 기본은 false
     */
    private static int calculateExecutionTimeWithCache(int cacheSize, String[] cities) {
        // 캐시 크기가 0이면, 캐시가 아예 없다는 의미로 무조건 Cache Miss로 5초씩 걸리는 상황이다.
        if (cacheSize == 0) return cities.length * CACHE_MISS;

        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.7f, true);
        int time = 0;

        for (String city : cities) {
            // equals와 HashMap은 대소문자를 구분하고, 문제 조건은 대소문자를 구분하지 않으므로 모든 도시 이름을 소문자로 통일한다.
            city = city.toLowerCase();

            if (cache.containsKey(city)) {
                time += CACHE_HIT;
            } else {
                time += CACHE_MISS;
                if (cache.size() >= cacheSize) {
                    // keySet(): 키(Set<String>)만 반환하며 순회, 삭제에 주로 사용한다.
                    // entrySet(): Map.Entry<K, V> 객체로 Set을 반환하며 키 + 값을 동시에 필요할 때 주로 사용한다.
                    String LRU = cache.keySet().iterator().next();
                    cache.remove(LRU);
                }
            }
            // LRU 캐시는 key의 순서에만 관심이 있어 value는 무의미하다. 때문에 단지 자리를 채우기 위한 값으로 0을 넣어준다.
            cache.put(city, 0);
        }

        return time;
    }
}
