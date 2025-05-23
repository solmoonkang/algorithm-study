package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 롤케이크자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] topping = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) topping[i] = Integer.parseInt(stringTokenizer.nextToken());

        int fairlyWay = getCutRollCakeFairlyWay(topping);
        bufferedWriter.write(String.valueOf(fairlyWay));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getCutRollCakeFairlyWay(int[] topping) {
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int top : topping) rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);

        int fairlyWay = 0;

        for (int i = 0; i < topping.length - 1; i++) {
            leftSet.add(topping[i]);

            int toppingCount = rightMap.get(topping[i]) - 1;
            if (toppingCount == 0) rightMap.remove(topping[i]);
            else rightMap.put(topping[i], toppingCount);

            if (leftSet.size() == rightMap.size()) fairlyWay++;
        }

        return fairlyWay;
    }
}
