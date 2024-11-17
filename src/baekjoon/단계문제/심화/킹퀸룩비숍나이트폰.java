package baekjoon.단계문제.심화;

import java.io.*;
import java.util.StringTokenizer;

public class 킹퀸룩비숍나이트폰 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int king = 1 - Integer.parseInt(stringTokenizer.nextToken());
        int queen = 1 - Integer.parseInt(stringTokenizer.nextToken());
        int rook = 2 - Integer.parseInt(stringTokenizer.nextToken());
        int bishop = 2 - Integer.parseInt(stringTokenizer.nextToken());
        int knight = 2 - Integer.parseInt(stringTokenizer.nextToken());
        int pawn = 8 - Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(king + " " + queen + " " + rook + " " + bishop + " " + knight + " " + pawn);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
