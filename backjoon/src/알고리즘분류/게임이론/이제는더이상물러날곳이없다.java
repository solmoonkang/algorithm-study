package 알고리즘분류.게임이론;

import java.io.*;

public class 이제는더이상물러날곳이없다 {

    private static final String GEONDEOK_WINS = "Duck";
    private static final String GUNGOOSE_WINS = "Goose";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(N % 2 == 0 ? GEONDEOK_WINS : GUNGOOSE_WINS);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
