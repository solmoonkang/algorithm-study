package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 학점계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> gradeMap = new HashMap<>();
        gradeMap.put("A+", "4.3");
        gradeMap.put("A0", "4.0");
        gradeMap.put("A-", "3.7");
        gradeMap.put("B+", "3.3");
        gradeMap.put("B0", "3.0");
        gradeMap.put("B-", "2.7");
        gradeMap.put("C+", "2.3");
        gradeMap.put("C0", "2.0");
        gradeMap.put("C-", "1.7");
        gradeMap.put("D+", "1.3");
        gradeMap.put("D0", "1.0");
        gradeMap.put("D-", "0.7");
        gradeMap.put("F", "0.0");

        String grade = bufferedReader.readLine();

        bufferedWriter.write(gradeMap.get(grade));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
