package 알고리즘분류.구현;

import java.io.*;
import java.util.*;

public class 방배정 {

    private static final int GENDER = 2;
    private static final int GRADE = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] count = new int[GENDER][GRADE];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int gender = Integer.parseInt(stringTokenizer.nextToken());
            int grade = Integer.parseInt(stringTokenizer.nextToken());
            count[gender][grade]++;
        }

        int rooms = 0;

        for (int g = 0; g < GENDER; g++) {
            for (int y = 1; y < GRADE; y++) {
                if (count[g][y] > 0) rooms += (count[g][y] + K - 1) / K;
            }
        }

        bufferedWriter.write(String.valueOf(rooms));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateRoomsFromLists(int N, int K, BufferedReader bufferedReader) throws IOException {
        Map<Integer, Integer> girlsCountByGrade = new HashMap<>();
        Map<Integer, Integer> boysCountByGrade = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int gender = Integer.parseInt(stringTokenizer.nextToken());
            int years = Integer.parseInt(stringTokenizer.nextToken());

            if (gender == 0) girlsCountByGrade.put(years, girlsCountByGrade.getOrDefault(years, 0) + 1);
            else boysCountByGrade.put(years, boysCountByGrade.getOrDefault(years, 0) + 1);
        }

        List<Integer> girlsPerGrade = new ArrayList<>(girlsCountByGrade.values());
        List<Integer> boysPerGrade = new ArrayList<>(boysCountByGrade.values());

        int roomsNumber = 0;
        for (int girlsRoom : girlsPerGrade) {
            roomsNumber += (girlsRoom + K - 1) / K;
        }

        for (int boysRoom : boysPerGrade) {
            roomsNumber += (boysRoom + K - 1) / K;
        }

        return roomsNumber;
    }
}
