package 단계문제.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {

    // TODO: 크래머의 법칙(Cramer's Rule)
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        int f = Integer.parseInt(stringTokenizer.nextToken());

        int D = a * d - b * c;

        int DX = e * d - b * f;
        int DY = a * f - e * c;

        int x = DX / D;
        int y = DY / D;

        bufferedWriter.write(x + " " + y);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
