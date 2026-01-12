package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 삼각형과세변 {

    private static final String TRIANGLE_TYPE_EQUILATERAL = "Equilateral";
    private static final String TRIANGLE_TYPE_ISOSCELES = "Isosceles";
    private static final String TRIANGLE_TYPE_SCALENE = "Scalene";
    private static final String TRIANGLE_TYPE_INVALID = "Invalid";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());

            if (A == 0 && B ==0 && C == 0) break;

            String answer = determineTriangleType(A, B, C);
            bufferedWriter.write(answer + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String determineTriangleType(int A, int B, int C) {
        int maxSide = Math.max(A, Math.max(B, C));
        int otherSide = (A + B + C) - maxSide;

        if (maxSide >= otherSide) return TRIANGLE_TYPE_INVALID;

        if (A == B && A == C) return TRIANGLE_TYPE_EQUILATERAL;
        else if (A == B || B == C || A == C) return TRIANGLE_TYPE_ISOSCELES;
        else  return TRIANGLE_TYPE_SCALENE;
    }
}
