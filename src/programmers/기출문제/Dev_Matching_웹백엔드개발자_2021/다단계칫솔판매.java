package programmers.기출문제.Dev_Matching_웹백엔드개발자_2021;

import java.io.*;
import java.util.*;

public class 다단계칫솔판매 {

    private static final int TOOTHBRUSH_PRICE = 100;

    // TODO: 기대 값과 예상 값이 다르다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()), M = Integer.parseInt(stringTokenizer.nextToken());

        String[] enroll = new String[N];    // 각 판매원의 이름을 담은 배열
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) enroll[i] = stringTokenizer.nextToken();

        String[] referral = new String[N];  // 각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) referral[i] = stringTokenizer.nextToken();

        String[] seller = new String[M];    // 판매량 집계 데이터의 판매원 이름을 나열한 배열
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) seller[i] = stringTokenizer.nextToken();

        int[] amount = new int[M];          // 판매량 집계 데이터의 판매 수량을 나열한 배열
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) amount[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] salespersonsNames = getTotalProfitsAllocatedSalesRepresentatives(enroll, referral, seller, amount);
        bufferedWriter.write(Arrays.toString(salespersonsNames));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getTotalProfitsAllocatedSalesRepresentatives(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, List<String>> adjacencyListMap = new HashMap<>();
        Map<String, Integer> earningsMap = new HashMap<>();

        for (String sellerName : enroll) {
            adjacencyListMap.put(sellerName, new ArrayList<>());
            earningsMap.put(sellerName, 0);
        }

        for (int i = 0; i < enroll.length; i++) {
            String childName = enroll[i];
            String parentName = referral[i];
            if (!parentName.equals("-")) adjacencyListMap.get(parentName).add(childName);
        }

        for (int i = 0; i < amount.length; i++) {
            String sellerName = seller[i];
            int saleAmount = amount[i] * TOOTHBRUSH_PRICE;
            distributeEarnings(sellerName, saleAmount, adjacencyListMap, earningsMap);
        }

        int[] salespersonsNames = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) salespersonsNames[i] = earningsMap.get(enroll[i]);

        return salespersonsNames;
    }

    private static void distributeEarnings(String seller, int amount, Map<String, List<String>> adjacencyListMap, Map<String, Integer> earningsMap) {
        if (amount == 0 || seller.equals("-")) return;

        int earnings = (int) (amount * 0.9);
        int parentEarnings = (int) (amount * 0.1);

        earningsMap.put(seller, earningsMap.get(seller) + earnings);

        String parentName = findParent(seller, adjacencyListMap);
        if (parentName != null && !parentName.equals("-"))
            distributeEarnings(parentName, parentEarnings, adjacencyListMap, earningsMap);
    }

    private static String findParent(String seller, Map<String, List<String>> adjacencyListMap) {
        for (Map.Entry<String, List<String>> entry : adjacencyListMap.entrySet()) {
            if (entry.getValue().contains(seller)) return entry.getKey();
        }

        return null;
    }
}
