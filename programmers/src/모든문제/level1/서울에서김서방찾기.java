package 모든문제.level1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서울에서김서방찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] seoul = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) seoul[i] = stringTokenizer.nextToken();

        String kimLocation = findKimLocation(seoul);
        bufferedWriter.write(kimLocation);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String findKimLocation(String[] seoul) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("김서방은 ");

        for (int index = 0; index < seoul.length; index++) {
            if (seoul[index].equals("Kim")) {
                stringBuilder.append(index).append("에 있다");
                break;
            }
        }

        return stringBuilder.toString();
    }

    private static String anotherSolution(String[] seoul) {
        int X = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + X + "에 있다";
    }
}
