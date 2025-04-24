package 기출문제.PCCE기출문제.복습문제;

import java.io.*;
import java.util.*;

public class 데이터분석 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] data = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            data[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            data[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            data[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            data[i][3] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String ext = stringTokenizer.nextToken();
        int val_ext = Integer.parseInt(stringTokenizer.nextToken());
        String sort_by = stringTokenizer.nextToken();

        int[][] results = solution(data, ext, val_ext, sort_by);

        for (int[] result : results) {
            for (int answer : result) {
                bufferedWriter.write(answer + " ");
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // switch로 ext가 무엇인지에 따라서 값을 선택하고, 선택된 값이 ext보다 작다면 배열에 넣음.
        // 2차원 배열에 있는 값을 sort_by 값으로 오름차순 정렬해서 반환함.
        int extIndex = getColumnIndex(ext);
        int sortIndex = getColumnIndex(sort_by);

        List<int[]> dataList = new ArrayList<>();
        for (int[] elements : data) {
            if (elements[extIndex] < val_ext) {
                dataList.add(elements);
            }
        }

        dataList.sort(Comparator.comparingInt(a -> a[sortIndex]));

        return dataList.toArray(new int[0][]);
    }

    private static int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getColumnIndex(ext);
        int sortIndex = getColumnIndex(sort_by);

        return Arrays.stream(data)
                .filter(d -> d[extIndex] < val_ext)
                .sorted(Comparator.comparing(d -> d[sortIndex]))
                .toArray(int[][]::new);
    }

    private static int getColumnIndex(String ext) {
        return switch (ext) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}
