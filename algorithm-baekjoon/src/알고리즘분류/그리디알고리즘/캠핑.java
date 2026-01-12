package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 캠핑 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> maxCampingDaysList = new ArrayList<>();

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int L = Integer.parseInt(stringTokenizer.nextToken());
            int P = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            maxCampingDaysList.add(getMaxCampingDays(L, P, V));
        }

        for (int i = 1; i <= maxCampingDaysList.size(); i++) {
            bufferedWriter.write("Case " + i + ": " + maxCampingDaysList.get(i - 1) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxCampingDays(int usableCampingDays, int periodLength, int vacationDays) {
        int maxCampingDays = 0;

        maxCampingDays += (vacationDays / periodLength) * usableCampingDays;
        int remainingDays = vacationDays % periodLength;

        maxCampingDays += Math.min(remainingDays, usableCampingDays);

        return maxCampingDays;
    }
}
