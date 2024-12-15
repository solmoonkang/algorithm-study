package baekjoon.알고리즘분류.구현;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());

        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String command = bufferedReader.readLine();

            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("add") || action.equals("remove") || action.equals("check") || action.equals("toggle")) {
                if (parts.length < 2) continue;
                int number = Integer.parseInt(parts[1]);

                switch (action) {
                    case "add":
                        numberSet.add(number);
                        break;
                    case "remove":
                        numberSet.remove(number);
                        break;
                    case "check":
                        bufferedWriter.write(numberSet.contains(number) ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        if (numberSet.contains(number)) numberSet.remove(number);
                        else numberSet.add(number);
                        break;
                }
            } else if (action.equals("all")) {
                numberSet.clear();
                IntStream.rangeClosed(1, 20).forEach(numberSet::add);
            } else if (action.equals("empty")) {
                numberSet.clear();
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
