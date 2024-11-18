package baekjoon.단계문제.심화;

import java.io.*;
import java.util.StringTokenizer;

public class 너의평점은 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] credits = new double[20];
        double[] grades = new double[20];

        double sumCredit = 0;
        double weightedSum = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringTokenizer.nextToken();

            credits[i] = Double.parseDouble(stringTokenizer.nextToken());
            String grade = stringTokenizer.nextToken();

            switch (grade) {
                case "A+":
                    grades[i] = 4.5;
                    break;
                case "A0":
                    grades[i] = 4.0;
                    break;
                case "B+":
                    grades[i] = 3.5;
                    break;
                case "B0":
                    grades[i] = 3.0;
                    break;
                case "C+":
                    grades[i] = 2.5;
                    break;
                case "C0":
                    grades[i] = 2.0;
                    break;
                case "D+":
                    grades[i] = 1.5;
                    break;
                case "D0":
                    grades[i] = 1.0;
                    break;
                case "P":
                    grades[i] = 0.0;
                    continue;
                default:
                    grades[i] = 0.0;
                    break;
            }

            weightedSum += credits[i] * grades[i];
            sumCredit += credits[i];
        }

        double majorGPA = weightedSum / sumCredit;

        bufferedWriter.write(String.format("%.6f", majorGPA));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
