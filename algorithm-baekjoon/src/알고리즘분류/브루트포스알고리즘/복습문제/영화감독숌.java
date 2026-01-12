package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;

public class 영화감독숌 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int index = getNumberInTheMovieTitle(N);
        bufferedWriter.write(String.valueOf(index));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 문자열 변환과 "666"임을 검사하므로, O(N logN) 정도의 시간 복잡도를 가진다.
    private static int getNumberInTheMovieTitle(int number) {
        int count = 0;
        int index = 666;

        while (count != number) {
            if (String.valueOf(index).contains("666")) count++;
            index++;
        }

        return index - 1;
    }
}
